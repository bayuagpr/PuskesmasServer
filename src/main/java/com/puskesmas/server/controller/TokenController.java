/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PC-11
 */
@RestController
@RequestMapping("/tokens")
public class TokenController{
    
@Resource(name="tokenServices")
ConsumerTokenServices tokenServices;

 @Resource(name = "tokenStore")
 TokenStore tokenStore;
     
@PostMapping("/revoke/{tokenId:.*}")
@ResponseBody
public String revokeToken(@PathVariable String tokenId) {
    tokenServices.revokeToken(tokenId);
    return tokenId;
}


}
