package bupt.wspn.interceptor;

import java.util.Map;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageInterceptor;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.exception.WxErrorException;

/**
 * 示例：拦截器
 * 目的：拦截非TEXT类型的所有消息
 * @author antgan
 * @date 2016/12/15
 *
 */
public class DemoInterceptor implements WxMessageInterceptor{

	public boolean intercept(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {
		//拦截所有非TEXT类型的消息,true通行；false拦截
		if(wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)){
			return false;
		}else if(wxMessage.getMsgType().equals(WxConsts.XML_MSG_TEXT)){
			return true;
		}
		return false;
	}
}