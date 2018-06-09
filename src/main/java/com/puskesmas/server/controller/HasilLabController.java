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
import com.puskesmas.server.model.HasilLab;

import com.puskesmas.server.service.HasilLabService;
import com.puskesmas.server.service.IHasilLabService;

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
@RequestMapping("/HasilLab")
public class HasilLabController{
   @Autowired
    private IHasilLabService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Umum') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<HasilLab> findOne(@PathVariable(value = "id") String id ){
      HasilLab entity = restService.cariHasilLabId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
  @GetMapping("/tampilkan")
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< HasilLab >> findAll(){
      List< HasilLab > entities = restService.semuaHasilLab();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
  @PreAuthorize("hasAuthority('Pengelola Puskesmas') or hasAuthority('Laboran Lab')")
  public ResponseEntity<?> create(@RequestBody HasilLab entity ){
      
      restService.simpanHasilLab(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Pengelola Puskesmas') or hasAuthority('Laboran Lab')")
   public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  HasilLab entity ){
      HasilLab hl =restService.cariHasilLabId(id); 
     hl.setJenisTes(entity.getJenisTes());
      hl.setHasilLab(entity.getHasilLab());
        restService.simpanHasilLab(hl);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
  
 
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Pengelola Puskesmas') or hasAuthority('Laboran Lab')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusHasilLabId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
