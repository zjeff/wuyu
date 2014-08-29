package com.wuyu.mina.server;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.wuyu.util.WuConstants;

public class MainProtocolHandler extends IoHandlerAdapter {

	private final static Log logger = LogFactory
			.getLog(MainProtocolHandler.class);

	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.warn("Server exception.", cause);
		// Close connection when unexpected exception is caught.
		session.close(true);
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> map = (Map<String, String>) message;
			logger.info("the message is:"+map);
			if (!map.isEmpty() && map.containsKey(WuConstants.CLIENT_INVOKE_CLASS)
					&& map.containsKey(WuConstants.CLIENT_INVOKE_METHOD)) {
				
				 if (map.get(WuConstants.CLIENT_INVOKE_CLASS).equals(
						"mailService")) {
					if (!map.containsKey(WuConstants.CLIENT_RETURN_METHOD)) {
//						Method method = mailService.getClass().getMethod(
//								map.get(WuConstants.CLIENT_INVOKE_METHOD),
//								new Class[] { Map.class });
//						method.invoke(mailService, new Object[] { map });
						session.write("finished");
					} else {
//						Method method = mailService.getClass().getMethod(
//								map.get(WuConstants.CLIENT_INVOKE_METHOD),
//								new Class[] { Map.class });
//						session.write(method.invoke(mailService,
//								new Object[] { map }));
					}
					
				}else if(map.get(WuConstants.CLIENT_INVOKE_CLASS).equals(
						"riskRuleService")){
					if (!map.containsKey(WuConstants.CLIENT_RETURN_METHOD)) {
//						Method method = riskRuleService.getClass().getMethod(
//								map.get(WuConstants.CLIENT_INVOKE_METHOD),
//								new Class[] { Map.class });
//						method.invoke(riskRuleService, new Object[] { map });
						session.write("finished");
					} else {
//						Method method = riskRuleService.getClass().getMethod(
//								map.get(WuConstants.CLIENT_INVOKE_METHOD),
//								new Class[] { Map.class });
//						session.write(method.invoke(riskRuleService,
//								new Object[] { map }));
					}
				}else if(map.get(WuConstants.CLIENT_INVOKE_CLASS).equals(
						"doubiMerchantInfoService")){
					if (!map.containsKey(WuConstants.CLIENT_RETURN_METHOD)) {
//						Method method = doubiMerchantInfoService.getClass().getMethod(
//								map.get(WuConstants.CLIENT_INVOKE_METHOD),
//								new Class[] { Map.class });
//						method.invoke(doubiMerchantInfoService, new Object[] { map });
						session.write("finished");
					} else {
//						Method method = doubiMerchantInfoService.getClass().getMethod(
//								map.get(WuConstants.CLIENT_INVOKE_METHOD),
//								new Class[] { Map.class });
//						session.write(method.invoke(doubiMerchantInfoService,
//								new Object[] { map }));
					}
				}
			} else {
				session.write("parameter error");
			}
			session.close(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		finally{
			if(session!=null){
				session.close(true);
			}
		}
		// 
		return;
	}

	@Override
	public void sessionOpened(IoSession session) {
		// set idle time to 3 seconds
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 3);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		// disconnect an idle client
		session.close(true);
	}

}
