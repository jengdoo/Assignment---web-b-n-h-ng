package com.fpoly.assignmentjava6.service;

import com.fpoly.assignmentjava6.model.RoleUser;
import com.fpoly.assignmentjava6.model.User;
import com.fpoly.assignmentjava6.security.CustomerUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("not null");
        }
        Collection<GrantedAuthority> graCollectiont =new HashSet<>();
        Set<RoleUser> roles = user.getUserRoles();
        for (RoleUser roleUser : roles){
            graCollectiont.add(new SimpleGrantedAuthority(roleUser.getRole().getRoleName()));
        }
        return new CustomerUserDetail(user,graCollectiont);
    }
}
