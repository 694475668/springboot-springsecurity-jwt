package com.ratta.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * ******Title:<p> 程序的奥秘 </p> ******
 * ******Description:<p> </p>******
 * ******Company: <p> 雷塔智能科技有限公司 </p> ******
 *    注册时生成密码工具类
 * @version :
 * @author: 刘 明
 * @date:Created in 2020/6/25 8:48
 */
public class BcryptPasswordUtil {
    public static String createBCryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
