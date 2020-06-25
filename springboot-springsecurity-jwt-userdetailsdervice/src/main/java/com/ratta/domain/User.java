package com.ratta.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Description: User
 * @Author: LiuRunYong
 * @Date: 2020/4/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String account;

    private String userName;

    private String password;

    private String phone;

    private String email;

    private Integer sex;

    private Integer idCard;

    private Integer state;

    private String createTime;

    private String updateTime;

    private List<Role> roleList;

    Set<GrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    /**
     * 不然会总提示User account is locked  记得设置为true
     * 账号是否过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否锁定
     * 不然会总提示User account is locked  记得设置为true
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 账号凭证是否未过期
     * 不然会总提示User account is locked  记得设置为true
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 不然会总提示User account is locked  记得设置为true
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
