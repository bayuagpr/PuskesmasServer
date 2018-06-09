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
import com.puskesmas.server.model.HasilPemeriksaan;

import com.puskesmas.server.service.IHasilPemeriksaanService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author PC-11
 */
@RestController
@RequestMapping("/hasilPemeriksaan")
public class HasilPemeriksaanController{
   @Autowired
    private IHasilPemeriksaanService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<HasilPemeriksaan> findOne(@PathVariable(value = "id") String id ){
      HasilPemeriksaan entity = restService.cariPeriksaId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< HasilPemeriksaan >> findAll(){
      List< HasilPemeriksaan > entities = restService.semuaHasilPeriksa();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody HasilPemeriksaan entity ){
      
      restService.simpanHasilPeriksa(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
//  @RequestMapping(value = "/refresh/{id}", method = RequestMethod.PUT)
//   public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  HasilPemeriksaan entity ){
//      HasilPemeriksaan hp =restService.cariPeriksaId(id); 
//      hp.setJenisTes(entity.);
//      hp.setHasilLab(entity.getHasilLab());
//        restService.simpanHasilPeriksa(hp);
//      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
//   }
  
 
  @DeleteMapping("/hapus/{id}")
  @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusPeriksaId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
