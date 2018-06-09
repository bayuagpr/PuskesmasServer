/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.LoginUser;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface ILoginUserService {

    LoginUser cariJabatan(String jabatan);

    LoginUser cariPassword(String pass);

    LoginUser cariUserId(String id);

    LoginUser cariUsername(String user);

    void hapusUserId(String id);

    List<LoginUser> semuaUser();
    
    LoginUser simpanUser(LoginUser user);

    boolean terdapatIdUser(String id);

    boolean terdapatUser(String nama);
    
    public List<String> getUsersFromSessionRegistry();
    
}
