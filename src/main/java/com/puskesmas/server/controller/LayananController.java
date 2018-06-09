/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.controller;
import com.puskesmas.server.model.Layanan;
import com.puskesmas.server.service.ILayananService;
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
@RequestMapping("/layanan")
public class LayananController{
    @Autowired
    private ILayananService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Layanan> findOne(@PathVariable(value = "id") String id ){
      Layanan entity = restService.cariLayananId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< Layanan >> findAll(){
      List< Layanan > entities = restService.semuaLayanan();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
  @PreAuthorize("hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody Layanan entity ){
      
      restService.simpanLayanan(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuhasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  Layanan entity ){
      Layanan d =restService.cariLayananId(id); 
      d.setJenisPemeriksaan(entity.getJenisPemeriksaan());
      d.setBiayaPemeriksaan(entity.getBiayaPemeriksaan());
        restService.simpanLayanan(d);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
 
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusLayananId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
