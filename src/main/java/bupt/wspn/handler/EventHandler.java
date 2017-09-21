package bupt.wspn.handler;

import java.nio.BufferUnderflowException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.ResourceBundle;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import bupt.wspn.bean.User;
import bupt.wspn.mapper.UserMapper;

public class EventHandler implements WxMessageHandler{
	
	UserMapper userMapper;

	public EventHandler(UserMapper userMapper) {
		// TODO Auto-generated constructor stub
		super();
		this.userMapper = userMapper;
		
	}
//	private static final String BUNDLE_NAME = "messages";
//	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	@Override
	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {
		// TODO Auto-generated method stub
		System.out.println("经过EventHandler");
		String event_type = wxMessage.getEvent();
		String response = null;
		switch (event_type.toLowerCase()) {
		case WxConsts.EVT_SUBSCRIBE:
//			response = RESOURCE_BUNDLE.getString(WxConsts.EVT_SUBSCRIBE);
			response = "欢迎关注";
			try{
				User user = new User();
				user.setOpenid(wxMessage.getFromUserName());
				user.setCreateTime(new Timestamp(System.currentTimeMillis()));
				int result = userMapper.newUser(user);
				System.out.println("发起注册新用户请求，返回结果"+Integer.toString(result) +"来自用户"+wxMessage.getFromUserName());
			} catch(DuplicateKeyException e){
				System.out.println("用户已经注册，无需重复申请");
			}
			break;
		case WxConsts.BUTTON_CLICK:
			if(wxMessage.getEventKey().equalsIgnoreCase("registry")){
				//response = "rhoybeen.ngrok.cc/wechat/user?openid="+wxMessage.getFromUserName();
				response = "www.bjseeyoung.com";
			}
			System.out.println("收到用户点击事件");
			break;
		default:
//			response = RESOURCE_BUNDLE.getString("default");
			System.out.println("收到事件，但什么都没做");
			break;
		}
		WxXmlOutMessage xmlOutMsg = WxXmlOutMessage.TEXT().content(response).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
		return xmlOutMsg;
	}
}
