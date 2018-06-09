/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.dao;

import com.puskesmas.server.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface LoginUserDAO extends JpaRepository<LoginUser, String>{
    LoginUser findByUsername(String username);
    LoginUser findByPassword(String password);
    LoginUser findByJabatan(String jabatan);
    
}
