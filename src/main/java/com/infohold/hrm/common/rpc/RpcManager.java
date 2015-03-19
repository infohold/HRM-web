package com.infohold.hrm.common.rpc;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * JsonRPC工具类，负责获取JsonRPC连接
 * 
 * @author lindi
 *
 */
public final class RpcManager {
	/**
	 * 服务名常量
	 */
	public static String						portalService	= "portal.serviceIp";				// portal服务名
	private static Map<String, RpcClient>		clients			= new HashMap<String, RpcClient>();
	private final static ReentrantReadWriteLock	LOCK			= new ReentrantReadWriteLock(true);

	private RpcManager() {}

	/**
	 * 获取rpc连接客户端
	 * 
	 * @param serverName
	 *            服务名
	 * @param session
	 *            session
	 * @return
	 */
	public static RpcClient getClient(String serverName) {
		RpcClient client = clients.get(serverName);

		if (client == null) {
			LOCK.writeLock().lock();
			try {
				client = new RpcClient(serverName);
				clients.put(serverName, client);

				return client;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} finally {
				LOCK.writeLock().unlock();
			}
		}

		return client;
	}
}
