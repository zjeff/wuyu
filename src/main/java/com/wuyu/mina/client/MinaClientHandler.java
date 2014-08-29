package com.wuyu.mina.client;

import java.net.InetSocketAddress;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClientHandler extends IoHandlerAdapter {
	private final static Log logger = LogFactory
			.getLog(MinaClientHandler.class);
	private Map<String, Object> map;
	private String hostName;
	private static final int PORT = 1239;
	private static final int CONNECT_TIMEOUT = 1000;
	private NioSocketConnector connector;
	private ConnectFuture future;

	private IoSession session;

	public MinaClientHandler(Map<String, Object> map) {
		this.map = map;
		this.hostName = "10.209.94.35";

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.warn("Client exception.", cause);
		// Close connection when unexpected exception is caught.
		session.close(true);
		if (connector != null) {
			connector.dispose();
		}
	}

	@Override
	public void sessionOpened(IoSession session) {
		System.out.println("-------------MinaClientHandler.sessionOpened-------------");
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 3);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		// disconnect an idle client
		System.out.println("-------------MinaClientHandler.sessionIdle-------------");
		session.close(true);
		if (connector != null) {
			connector.dispose();
		}
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		System.out.println("-------------MinaClientHandler.messageReceived-------------");
		try {
			if (!map.isEmpty()
					&& map.containsKey("key")) {
				System.out.println(map);
				session.close(true);
			}
		} catch (Exception ex) {
			logger.error("exception: " + ex.getMessage());
			return;
		}
	}

	/**
	 * 
	 * 
	 * @param waitingFlag
	 * @return
	 */
	public void connect() {
		if (hostName == null) {
			return;
		}
		if (session != null && session.isConnected()) {
			throw new IllegalStateException(
					"Already connected. Disconnect first.");
		}
		try {
			connector = new NioSocketConnector();
			connector.setConnectTimeoutMillis(CONNECT_TIMEOUT);
			connector.getFilterChain().addLast(
					"codec",
					new ProtocolCodecFilter(
							new ObjectSerializationCodecFactory()));
			connector.getFilterChain().addLast("logger", new LoggingFilter());
			connector.setHandler(this);
			future = connector.connect(new InetSocketAddress(hostName, PORT));
			future.awaitUninterruptibly();
			if (!future.isConnected()) {
				return;
			}
			session = future.getSession();
			session.write(map);
			session.close(true);
			if (connector != null) {
				connector.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if (session != null) {
				try {
					session.close(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (connector != null) {
				try {
					connector.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @param waitingFlag
	 * @return
	 */
	public boolean connectWithClosure(boolean waitingFlag) {
		/**
		 * YouxiClientMonitorService youxiClientMonitorService =
		 * (YouxiClientMonitorService) WebContext
		 * .getBean("youxiClientMonitorService"); List<String> availHost =
		 * youxiClientMonitorService.getAvailHost(); if(availHost!=null &&
		 * availHost.size()>0){
		 * System.out.println("availHost : "+availHost.get(0)); }
		 **/
		if (hostName == null) {
			return false;
		}
		if (session != null && session.isConnected()) {
			throw new IllegalStateException(
					"Already connected. Disconnect first.");
		}
		try {
			connector = new NioSocketConnector();
			connector.setConnectTimeoutMillis(CONNECT_TIMEOUT);
			connector.getFilterChain().addLast(
					"codec",
					new ProtocolCodecFilter(
							new ObjectSerializationCodecFactory()));
			connector.getFilterChain().addLast("logger", new LoggingFilter());
			connector.setHandler(this);
			future = connector.connect(new InetSocketAddress(hostName, PORT));
			future.awaitUninterruptibly();
			if (!future.isConnected()) {
				return false;
			}
			session = future.getSession();
			session.write(map);
			if (waitingFlag) {
				session.getCloseFuture().awaitUninterruptibly();
			} else {
				session.close(true);
			}
			if (connector != null) {
				connector.dispose();
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			// throw new
			// IllegalStateException("connectWaitingClose ex: session is already closed");
		} finally {
			if (session != null) {
				try {
					session.close(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (connector != null) {
				try {
					connector.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return false;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
}

