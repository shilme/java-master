package com.example.demo.security;

import com.example.demo.model.AdminModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AdminUserDetails implements UserDetails {

    private AdminModel adminModel;
//    private List<UmsResource> resourceList;
//    public AdminUserDetails(UserModel umsAdmin,List<UmsResource> resourceList) {
//        this.umsAdmin = umsAdmin;
//        this.resourceList = resourceList;
//    }
    public AdminUserDetails(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return adminModel.getPassword();
    }

    @Override
    public String getUsername() {
        return adminModel.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
