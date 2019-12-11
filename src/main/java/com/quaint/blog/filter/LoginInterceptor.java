package com.quaint.blog.filter;

import com.quaint.blog.annotation.CheckLogin;
import com.quaint.blog.helper.MUOContext;
import com.quaint.blog.service.MemberInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 *  登录校验拦截器
 * @author: quaint
 * @Date: Created in 2019/10/19 15:26
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    MemberInfoService memberInfoService;

    public String getPathPattern() {
        return "/**";
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 清除 ThreadLocal 的上下文信息
        MUOContext.clean();
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            CheckLogin check = method.getBean().getClass().getAnnotation(CheckLogin.class);
            if (check != null && check.value()) {
                // 获取请求头的 token
                String accessToken = request.getHeader("accessToken");
                if(StringUtils.isNotEmpty(accessToken)){
                    // 1. 把 token 反解析为 用户信息
                    Integer memberId = memberInfoService.getMemberIdByToken(accessToken);
                    // 对查询的结果进行逻辑判断
                    if (memberId == null){
                        logger.info("token 无效");
                        return false;
                    } else{
                        // 2. 部分用户信息设置到上下问环境中
                        MUOContext.setMemberId(memberId);
                    }
                } else {
                    // 写错误信息
                    logger.info("用户没有登录！");
                    return false;
                }
            }
        }
        return true;
    }

}
