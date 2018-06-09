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
import com.puskesmas.server.model.MedicalRecord;

import com.puskesmas.server.service.IMedicalRecordService;

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
@RequestMapping("/medicalRecord")
public class MedicalRecordController{
    @Autowired
    private IMedicalRecordService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<MedicalRecord> findOne(@PathVariable(value = "id") String id ){
      MedicalRecord entity = restService.cariRekamId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< MedicalRecord >> findAll(){
      List< MedicalRecord > entities = restService.semuaRekamMedis();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
  @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody MedicalRecord entity ){
      
      restService.simpanRekam(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
//  @RequestMapping(value = "/refresh/{id}", method = RequestMethod.PUT)
//   public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  MedicalRecord entity ){
//      MedicalRecord m =restService.cariRekamId(id); 
//      
//        restService.simpanRekam(m);
//      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
//   }
  
 
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusRekamId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
