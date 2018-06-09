/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.LoginUser;
import com.puskesmas.server.dao.LoginUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService{
    @Autowired
    private LoginUserDAO userRepository;
    
     @Override
     @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginUser user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), user.getEnabled(), user.getAccNonExpired(), user.getCredNonExpired(), user.getAccNonLocked(), getAuthorities(user));

        return userDetails;
    }
    
    public List<GrantedAuthority> getAuthorities(LoginUser user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(user.getJabatan()));

         System.out.print("authorities :"+authorities);
        return authorities;
    }


}
