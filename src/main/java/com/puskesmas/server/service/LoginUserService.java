/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.LoginUserDAO;
import com.puskesmas.server.model.LoginUser;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC-11
 */
@Service
public class LoginUserService implements ILoginUserService{
        @Autowired
	LoginUserDAO login;
        
        @Autowired
        private SessionRegistry sessionRegistry;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<LoginUser> semuaUser() {
		return (List<LoginUser>) login.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public LoginUser cariUserId(String id) {
		return login.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdUser(String id) {
		return login.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatUser(String nama) {
		return login.findByUsername(nama) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusUserId(String id) {
		login.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public LoginUser simpanUser(LoginUser user) {
		return login.save(user);
	}

        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public LoginUser cariUsername(String user){
            return login.findByUsername(user);
        }
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public LoginUser cariPassword(String pass){
            return login.findByPassword(pass);
        }
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public LoginUser cariJabatan(String jabatan){
            return login.findByJabatan(jabatan);
        }
        
         @Override
         public List<String> getUsersFromSessionRegistry() {
        return sessionRegistry.getAllPrincipals().stream()
                .filter((u) -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                .map(Object::toString)
                .collect(Collectors.toList());
    }
        
        
}
