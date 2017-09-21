package bupt.wspn.handler;

import java.util.Map;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;



/**
 * 示例：DemoHandler
 * 目的：返回用户 “恭喜你中奖了”
 * @author antgan
 * @date 2016/12/15
 *
 */
public class DemoHandler implements WxMessageHandler{

	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {
        //必须以build()作为结尾，否则不生效。
		System.out.println("经过DemoHandler");
		String msgType = wxMessage.getMsgType();
		System.out.println(msgType);
		WxXmlOutMessage xmlOutMsg = null;
		switch (msgType) {
		case "event":
			xmlOutMsg = WxXmlOutMessage.TEXT().content("http://www.rhoy.pub").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
			break;

		default:
			xmlOutMsg = WxXmlOutMessage.TEXT().content("http://rhoybeen.ngrok.cc/wechat/user").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
			break;
		}
		
		return xmlOutMsg;
	}
	
}
