package com.example.demo.security;

import com.example.demo.model.AdminModel;
import com.example.demo.model.PermissionModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AdminUserDetails implements UserDetails {

    private AdminModel adminModel;
    private List<PermissionModel> permissionlist;
//    private List<UmsResource> resourceList;
//    public AdminUserDetails(UserModel umsAdmin,List<UmsResource> resourceList) {
//        this.umsAdmin = umsAdmin;
//        this.resourceList = resourceList;
//    }
    public AdminUserDetails(AdminModel adminModel, List<PermissionModel> permissionlist) {
        this.adminModel = adminModel;
        this.permissionlist = permissionlist;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionlist.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
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
