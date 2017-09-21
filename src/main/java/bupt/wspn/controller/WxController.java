package bupt.wspn.controller;

import java.awt.Event;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConfig;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageRouter;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxMenu;
import com.soecode.wxtools.bean.WxMenu.WxMenuButton;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.wxtools.util.xml.XStreamTransformer;

import bupt.wspn.handler.DemoHandler;
import bupt.wspn.handler.EventHandler;
import bupt.wspn.handler.MessageHandler;
import bupt.wspn.interceptor.DemoInterceptor;
import bupt.wspn.interceptor.EventInterceptor;
import bupt.wspn.mapper.UserMapper;
import bupt.wspn.matcher.DemoMatcher;

@Controller
public class WxController {
	
	@Autowired
	UserMapper userMapper;

	//实例化 统一业务API入口
	private IService iService = new WxService();
	
	@ModelAttribute
	public void createMenu(){
		WxMenu menu = new WxMenu();
		ArrayList<WxMenuButton> btnList = new ArrayList<>();
		WxMenuButton btn1 = new WxMenuButton();
		btn1.setType(WxConsts.BUTTON_CLICK);
		btn1.setKey("btn1_key");
		btn1.setName("btn1");
	    WxMenuButton btn2 = new WxMenuButton();
	    btn2.setType(WxConsts.BUTTON_CLICK);
	    btn2.setKey("registry");
	    btn2.setName("完善信息");
	    
	    btnList.add(btn1);
	    btnList.add(btn2);
	    menu.setButton(btnList);
	    
	    try {
	        //参数1--menu ，参数2--是否是个性化定制。如果是个性化菜单栏，需要设置MenuRule
	            iService.createMenu(menu, false);
	        } catch (WxErrorException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	@RequestMapping(value = "/w")
	public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String method = request.getMethod();
		if("GET".equalsIgnoreCase(method)){
			PrintWriter out = response.getWriter();
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			if (iService.checkSignature(signature, timestamp, nonce, echostr)) {
				out.print(echostr);
				System.out.println("收到"+request.getMethod()+echostr);
			}
		}else{
			request.setCharacterEncoding("UTF-8");
	 		response.setCharacterEncoding("UTF-8");
			// 返回消息给微信服务器
			PrintWriter out = response.getWriter();
			// 获取encrypt_type 消息加解密方式标识
			String encrypt_type = request.getParameter("encrypt_type");
			// 创建一个路由器
			WxMessageRouter router = new WxMessageRouter(iService);
			try {
				// 判断消息加解密方式，如果是加密模式。encrypt_type==aes
				if (encrypt_type != null && "aes".equals(encrypt_type)) {
//					String signature = request.getParameter("signature");
					String timestamp = request.getParameter("timestamp");
					String nonce = request.getParameter("nonce");
					String msg_signature = request.getParameter("msg_signature");

					// 微信服务器推送过来的加密消息是XML格式。使用WxXmlMessage中的decryptMsg()解密得到明文。
					WxXmlMessage wx = WxXmlMessage.decryptMsg(request.getInputStream(), WxConfig.getInstance(), timestamp,
							nonce, msg_signature);
					System.out.println("加密消息：\n " + wx.toString()+" Type:"+wx.getMsgType());
					// 添加规则；这里的规则是所有消息都交给DemoMatcher处理，交给DemoInterceptor处理，交给DemoHandler处理
					// 注意！！每一个规则，必须由end()或者next()结束。不然不会生效。
					// end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
					router.rule().matcher(new DemoMatcher()).interceptor(new DemoInterceptor()).handler(new DemoHandler()).end();
					// 把消息传递给路由器进行处理，得到最后一个handler处理的结果
					WxXmlOutMessage xmlOutMsg = router.route(wx);
					if (xmlOutMsg != null) {
						// 将要返回的消息加密，返回
						out.print(WxXmlOutMessage.encryptMsg(WxConfig.getInstance(), xmlOutMsg.toXml(), timestamp, nonce));// 返回给用户。
					}
				//如果是明文模式，执行以下语句
				} else {
					// 微信服务器推送过来的是XML格式。
					WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
					System.out.println("未加密消息：\n "+" Type:"+wx.getMsgType() +"  " + wx.toString());
					// 添加规则；这里的规则是所有消息都交给DemoMatcher处理，交给DemoInterceptor处理，交给DemoHandler处理
					// end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
					router.rule().interceptor(new DemoInterceptor()).handler(new DemoHandler()).next().rule().msgType(WxConsts.XML_MSG_EVENT).interceptor(new EventInterceptor()).handler(new EventHandler(userMapper)).end();
					// 把消息传递给路由器进行处理
					WxXmlOutMessage xmlOutMsg = router.route(wx);
					if (xmlOutMsg != null){
						out.print(xmlOutMsg.toXml());// 因为是明文，所以不用加密，直接返回给用户。
						System.out.println("明文模式回复：\n " + xmlOutMsg.toString());
					}else{
//						System.out.println("回复为null");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		}

	}
	
}
