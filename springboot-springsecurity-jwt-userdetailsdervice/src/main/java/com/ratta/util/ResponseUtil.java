package com.ratta.util;

import com.alibaba.fastjson.JSON;
import com.ratta.vo.BaseVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ******Title:<p> 程序的奥秘 </p> ******
 * ******Description:<p> </p>******
 * ******Company: <p> 雷塔智能科技有限公司 </p> ******
 * 响应处理工具类
 *
 * @version :
 * @author: 刘 明
 * @date:Created in 2020/6/24 17:32
 */
public class ResponseUtil {
    public static <T> void ResponseMeg(HttpServletResponse response, T t) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            response.getWriter().write(JSON.toJSONString(t));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
