package com.ratta.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ratta.domain.User;

/**
 * ******Title:<p> 程序的奥秘 </p> ******
 * ******Description:<p> </p>******
 * ******Company: <p> 雷塔智能科技有限公司 </p> ******
 *
 * @version :
 * @author: 刘 明
 * @date:Created in 2020/6/24 12:36
 */
public interface UserService extends IService<User> {
    /**
     * 据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User findByUserName(String username);
}
