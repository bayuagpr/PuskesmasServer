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
import com.puskesmas.server.model.LoginUser;

import com.puskesmas.server.service.LoginUserService;
import com.puskesmas.server.service.ILoginUserService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/users")
public class LoggedController {
     @Autowired
    private ILoginUserService restService;
    
    @GetMapping("/active")
   @PreAuthorize("hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< String >> findAll(){
      List< String > entities = restService.getUsersFromSessionRegistry();
       
      return ResponseEntity.ok().body(entities);
   }
}
