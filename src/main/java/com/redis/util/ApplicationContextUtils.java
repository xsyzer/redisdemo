package com.redis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author xsyz
 * @created 2020-12-09   21:06
 */

/**
 * 用来获取springboot创建好的工厂
 */
@Configuration
public class ApplicationContextUtils implements ApplicationContextAware {
    /**
     * 保留下来工厂
     */
    private static ApplicationContext applicationContext;

    /**
     * 将创建好的工厂以参数形式传递给这个类
     */
    @Override
    public  void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    /**
     * 提供在工厂中获取对象的方法
     */
    public static Object getBean(String beanname) {
        return applicationContext.getBean(beanname);
    }
}
