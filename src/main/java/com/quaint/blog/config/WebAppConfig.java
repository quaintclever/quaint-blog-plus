package com.quaint.blog.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.quaint.blog.filter.PathPatternInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Description:
 *  webapp 全局配置
 * @author: quaint
 * @Date: Created in 2019/10/19 15:26
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired(required = false)
    List<PathPatternInterceptor> interceptorList;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(CollectionUtils.isNotEmpty(interceptorList)){
            //注册基于path pattern的拦截器
            interceptorList.forEach(interceptor -> registry.addInterceptor(interceptor).addPathPatterns(interceptor.getPathPattern()));
        }
    }


    // 如果只有一个 interceptor , 可以少一层封装. LoginInterceptor 直接实现 HandlerInterceptor
    
//    @Autowired
//    LoginInterceptor loginInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        if (Objects.nonNull(loginInterceptor))
//            registry.addInterceptor(loginInterceptor).addPathPatterns(loginInterceptor.getPathPattern());
//    }


}