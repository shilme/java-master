package com.example.demo.service.Impl;


import com.example.demo.model.AdminModel;
import com.example.demo.dao.AdminMapper;
import com.example.demo.dao.AdminRoleRelationMapper;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.model.PermissionModel;
import com.example.demo.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * UmsAdminService实现类
 */
@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;

    @Override
    public AdminModel register(AdminModel adminModel) {
        AdminModel admin = new AdminModel();
        BeanUtils.copyProperties(adminModel, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        List<AdminModel> adminModelList = adminMapper.selectByExample(admin);
        if (adminModelList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        adminMapper.insert(admin);
        return admin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public AdminModel getAdminByUsername(String username) {
        List<AdminModel> adminlist = adminMapper.getAdminByUsername(username);
//        UmsAdminExample example = new UmsAdminExample();
//        example.createCriteria().andUsernameEqualTo(username);
//        List<AdminModel> adminList = adminMapper.selectByExample(example);
        if (adminlist != null && adminlist.size() > 0) {
            return adminlist.get(0);
        }
        return null;
    }

    @Override
    public List<PermissionModel> getPermissionList(Long adminId) {
        return adminRoleRelationMapper.getPermissionList(adminId);
    }
}
