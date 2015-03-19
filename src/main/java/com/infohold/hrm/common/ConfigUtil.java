package com.infohold.hrm.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取属性文件属性值工具类
 * 
 * @author lindi
 *
 */
public class ConfigUtil {
	private static Logger		logger	= LoggerFactory.getLogger(ConfigUtil.class);	// 日志对象
	private static ConfigUtil	configUtil;											// 单例模式实例
	private Properties			property;												// 属性

	/**
	 * 无参数构造方法 默认加载config.properties属性文件
	 */
	private ConfigUtil() {
		if (property == null) {
			property = new Properties();
		}

		InputStream inputStream = this.getClass().getResourceAsStream("/config.properties");
		try {
			load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			logger.error("load file \"config.properties\" error!", e);
		}

	}

	/**
	 * 带参数构造方法，加载文件流中的属性文件
	 * 
	 * @param inputStream
	 *            输入流
	 */
	private ConfigUtil(InputStream inputStream) {
		if (property == null) {
			property = new Properties();
		}

		try {
			load(inputStream);
		} catch (IOException e) {
			logger.error("load file error!", e);
		}
	}

	/**
	 * 获取本类实例
	 * 
	 * @return 类实例
	 */
	public static ConfigUtil instance() {
		if (configUtil == null) {
			configUtil = new ConfigUtil();
		}

		return configUtil;
	}

	/**
	 * 获取本类实例
	 * 
	 * @param inputStream
	 *            输入流
	 * @return 类实例
	 */
	public static ConfigUtil instance(InputStream inputStream) {
		if (configUtil == null) {
			configUtil = new ConfigUtil(inputStream);
		}

		return configUtil;
	}

	/**
	 * 获取本类实例
	 * 
	 * @param path
	 *            属性文件地址
	 * @return 类实例
	 */
	public static ConfigUtil instance(String path) {
		try {
			InputStream inputStream = new FileInputStream(new File(path));
			ConfigUtil instance = instance(inputStream);
			inputStream.close();
			return instance;
		} catch (IOException e) {
			logger.error("load file \"" + path + "\" is error! ", path);
		}

		return null;
	}

	/**
	 * 获取属性值
	 * 
	 * @param key
	 *            key
	 * @return 属性值
	 */
	public String getProperty(String key) {
		return property.getProperty(key);
	}

	/**
	 * 获取属性值（带默认值）
	 * 
	 * @param key
	 *            key
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public String getProperty(String key, String defaultValue) {
		return property.getProperty(key, defaultValue);
	}

	public boolean getBooleanProperty(String key) {
		return BooleanUtils.toBoolean(getProperty(key));
	}

	/**
	 * 获取属性值（带默认值）
	 * 
	 * @param key
	 *            key
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public boolean getBooleanProperty(String key, boolean defaultValue) {
		if (property.containsKey(key)) {
			String propertyValue = getProperty(key);
			return BooleanUtils.toBoolean(propertyValue);
		}

		return defaultValue;
	}

	/**
	 * 获取属性值
	 * 
	 * @param key
	 *            key
	 * @return 属性值
	 */
	public long getLongProperty(String key) {
		return NumberUtils.toLong(getProperty(key));
	}

	/**
	 * 获取属性值（带默认值）
	 * 
	 * @param key
	 *            key
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public long getLongProperty(String key, long defaultValue) {
		if (property.containsKey(key)) {
			String propertyValue = getProperty(key);
			return NumberUtils.toLong(propertyValue);
		}
		return defaultValue;
	}

	/**
	 * 加载属性文件
	 * 
	 * @param reader
	 *            输入流
	 * @throws IOException
	 */
	public void load(Reader reader) throws IOException {
		property.load(reader);
	}

	/**
	 * 加载属性文件
	 * 
	 * @param inStream
	 *            输入流
	 * @throws IOException
	 */
	public void load(InputStream inStream) throws IOException {
		property.load(inStream);
	}

	/**
	 * 加载属性文件
	 * 
	 * @param in
	 *            输入流
	 * @throws IOException
	 * @throws InvalidPropertiesFormatException
	 */
	public void loadFromXML(InputStream in) throws IOException, InvalidPropertiesFormatException {
		property.loadFromXML(in);
	}
}
