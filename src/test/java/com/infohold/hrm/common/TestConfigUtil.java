package com.infohold.hrm.common;

import com.infohold.hrm.common.ConfigUtil;

import junit.framework.TestCase;

public class TestConfigUtil extends TestCase {
	System.out.println("test");
	public void testInstance(){
		ConfigUtil instance = ConfigUtil.instance();
		assertNotNull(instance);
	}
	
	public void testGetProperty1(){
		String property = ConfigUtil.instance().getProperty("junit.test");
		assertEquals(property, "true");
	}
	
	public void testGetProperty2(){
		String property = ConfigUtil.instance().getProperty("junit.test1","true");
		assertEquals(property, "true");
	}
	
	public void testGetBooleanProperty1(){
		boolean property = ConfigUtil.instance().getBooleanProperty("junit.test");
		assertEquals(property, true);
	}
	
	public void testGetBooleanProperty2(){
		boolean property = ConfigUtil.instance().getBooleanProperty("junit.test1",true);
		assertEquals(property, true);
	}
	
	public void testGetLongProperty1(){
		long property = ConfigUtil.instance().getLongProperty("junit.lang");
		assertEquals(property, 123);
	}
	
	public void testGetLongProperty2(){
		long property = ConfigUtil.instance().getLongProperty("junit.lang1",321);
		assertEquals(property, 321);
	}
}
