package com.apress.prospring2.ch06.proxies;

import com.apress.prospring2.ch06.services.DefaultStockService;
import com.apress.prospring2.ch06.services.StockService;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author janm
 */
public class ProxyDemo4 {

    public static void main(String[] args) {
        DefaultStockService target = new DefaultStockService();
        AspectJProxyFactory pf = new AspectJProxyFactory(target);
        pf.addInterface(StockService.class);
        pf.setExposeProxy(true);
        pf.addAspect(BeforeAspect.class);
        
        StockService stockService = (StockService) pf.getProxy();
        stockService.getStockLevel("A");
    }

}