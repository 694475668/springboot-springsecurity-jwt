package com.ratta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratta.domain.User;
import com.ratta.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ******Title:<p> 程序的奥秘 </p> ******
 * ******Description:<p> </p>******
 * ******Company: <p> 雷塔智能科技有限公司 </p> ******
 *
 * @version :
 * @author: 刘 明
 * @date:Created in 2020/6/24 12:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements com.ratta.service.UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}
