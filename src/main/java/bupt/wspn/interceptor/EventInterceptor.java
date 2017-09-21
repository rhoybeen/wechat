package bupt.wspn.interceptor;

import java.util.Map;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageInterceptor;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.exception.WxErrorException;

public class EventInterceptor implements WxMessageInterceptor{
	@Override
	public boolean intercept(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {
		// TODO Auto-generated method stub
		String event_type = wxMessage.getEvent();
		if(event_type.equalsIgnoreCase(WxConsts.EVT_LOCATION)){
			System.out.println("被EventInterceptor拦截");
			return false;
		}
		return true;
	}
}
