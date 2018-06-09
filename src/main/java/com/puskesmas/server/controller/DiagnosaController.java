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
import com.puskesmas.server.model.Diagnosa;

import com.puskesmas.server.service.DiagnosaService;
import com.puskesmas.server.service.IDiagnosaService;

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
@RequestMapping("/diagnosa")
public class DiagnosaController{
    @Autowired
    private IDiagnosaService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Diagnosa> findOne(@PathVariable(value = "id") String id ){
      Diagnosa entity = restService.cariDiagnosaId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< Diagnosa >> findAll(){
      List< Diagnosa > entities = restService.semuaDiagnosa();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody Diagnosa entity ){
      
      restService.simpanDiagnosa(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  Diagnosa entity ){
      Diagnosa d =restService.cariDiagnosaId(id); 
      d.setHasilDiagnosa(entity.getHasilDiagnosa());
        restService.simpanDiagnosa(d);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
 
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusDiagnosaId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
