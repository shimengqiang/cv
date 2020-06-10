package com.vector.dubbo.common;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 * @author smq
 */

public class SpringContextHolder {

	private static ApplicationContext context;

	public static <T> T getBean(Class<T> clazz) {
		try {
			return getApplicationContext().getBean(clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T getBean(String name) {
		return (T) getApplicationContext().getBean(name);
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		Assert.notNull(context, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
		return context;
	}
}
