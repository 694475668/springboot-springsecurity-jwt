package com.ratta.hander;

import com.ratta.enumeration.ErrorCodeEnum;
import com.ratta.util.ResponseUtil;
import com.ratta.vo.BaseVO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 暂无权限处理类
 * @Author: 刘明
 * @Date: 2020/4/28
 **/
@Component
public class UserNotPermissionHandler implements AccessDeniedHandler {
    /**
     * 暂无权限返回结果
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) {
        ResponseUtil.ResponseMeg(response, new BaseVO(false, ErrorCodeEnum.E0706.getKey(), ErrorCodeEnum.E0706.getValue()));
    }
}