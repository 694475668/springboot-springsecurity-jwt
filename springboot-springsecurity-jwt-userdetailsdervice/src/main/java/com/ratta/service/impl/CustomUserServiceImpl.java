package com.ratta.service.impl;

import com.ratta.domain.Permission;
import com.ratta.domain.Role;
import com.ratta.domain.User;
import com.ratta.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ******Title:<p> 程序的奥秘 </p> ******
 * ******Description:<p> </p>******
 * ******Company: <p> 雷塔智能科技有限公司 </p> ******
 *
 * @version :
 * @author: 刘 明
 * @date:Created in 2020/6/24 18:43
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        //获取用户信息
        User user = userMapper.findByUserName(username);
        //创建GrantedAuthority集合
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (null == user) {
            //仍需要细化处理
            throw new UsernameNotFoundException("该用户不存在");
        }
        //获取用户的角色
        List<Role> roleList = user.getRoleList();
        roleList.forEach(role -> {
            /*
             构建所有权限集合==ROLE_角色+权限
             hasRole([role])	用户拥有指定的角色时返回true(hasRole()默认会将配置中的 role 带有 ROLE_ 前缀再和用户的角色权限 进行对比)
             hasAnyRole([role1,role2])	用户拥有任意一个指定中的角色时返回true
             hasAuthority([auth])	同hasRole()但不添加前缀 ROLE_
             hasAnyAuthority([auth1,auth2])	同hasAnyRole([auth1,auth2])，但不添加前缀 ROLE_
             */
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            //获取权限
            List<Permission> permissionList = role.getPermissionList();
            //添加角色到grantedAuthorities集合中
            permissionList.forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionValue())));
        });
        /*如果需要带当前user对象过去，那必须在user的实体类加上 Set<GrantedAuthority> grantedAuthorities
          而且还要实现UserDetails
          然后把权限设置过去，如果不需要当前对象可以使用security里面的user对象
          new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities)
         */
        user.setGrantedAuthorities(grantedAuthorities);
        return user;
    }
}
