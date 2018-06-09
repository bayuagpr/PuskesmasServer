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
import com.puskesmas.server.model.Dokter;

import com.puskesmas.server.service.IDokterService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
/**
 *
 * @author PC-11
 */
@RestController
@RequestMapping("/dokter")
public class DokterController{
    @Autowired
    private IDokterService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Dokter> findOne(@PathVariable(value = "id") String id ){
      Dokter entity = restService.cariDokterId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< Dokter >> semuaDokter(){
      List< Dokter > entities = restService.semuaDokter();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
  @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody Dokter entity ){
      
      restService.simpanDokter(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  Dokter entity ){
      Dokter d =restService.cariDokterId(id); 
     d.setNamaDokter(entity.getNamaDokter());
      d.setSpesialis(entity.getSpesialis());
        restService.simpanDokter(d);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
  
 
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusDokterId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
