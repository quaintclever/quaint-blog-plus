package com.quaint.blog.filter;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description:
 *  登录校验拦截器接口定义
 * @author: quaint
 * @Date: Created in 2019/10/19 15:26
 */
public interface PathPatternInterceptor extends HandlerInterceptor {

    /**
     * 获取拦截的url
     * @return
     */
    String getPathPattern();

}

