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
import com.puskesmas.server.model.DaftarPoli;

import com.puskesmas.server.service.DaftarPoliService;
import com.puskesmas.server.service.IDaftarPoliService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PC-11
 */
@RestController
@RequestMapping("/daftarPoli")
public class DaftarPoliController{
    @Autowired
    private IDaftarPoliService restService;
    
    
    @GetMapping("/tampilkan/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Admin Pendaftaran')or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<DaftarPoli> findOne(@PathVariable("id") String id ){
      DaftarPoli entity = restService.cariPoliId(id);
      System.out.println(entity.toString());
        return ResponseEntity.ok().body(entity);
    
      
   }
   
   @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Admin Pendaftaran')or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< DaftarPoli >> findAll(){
      List< DaftarPoli > entities = restService.semuaPoli();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
  @ResponseBody
  public ResponseEntity<DaftarPoli> create(@RequestBody DaftarPoli entity ){
      
      restService.simpanPoli(entity);
      return ResponseEntity.ok().body(entity);
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  DaftarPoli entity ){
      DaftarPoli r =restService.cariPoliId(id); 
      r.setNamaPoli(entity.getNamaPoli());
        restService.simpanPoli(r);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
 
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusPoliId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
