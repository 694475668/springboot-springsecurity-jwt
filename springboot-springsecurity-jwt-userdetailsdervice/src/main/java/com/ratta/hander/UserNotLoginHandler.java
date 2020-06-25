package com.ratta.hander;

import com.ratta.enumeration.ErrorCodeEnum;
import com.ratta.util.ResponseUtil;
import com.ratta.vo.BaseVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 用户未登录处理类
 * @Author: 刘明
 * @Date: 2020/4/28
 **/
@Component
public class UserNotLoginHandler implements AuthenticationEntryPoint {
    /**
     * 用户未登录返回结果
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {

        ResponseUtil.ResponseMeg(response, new BaseVO(false, ErrorCodeEnum.E0705.getKey(), ErrorCodeEnum.E0705.getValue()));
    }
}