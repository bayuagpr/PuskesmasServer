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
import com.puskesmas.server.model.Pembayaran;

import com.puskesmas.server.service.IPembayaranService;

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
@RequestMapping("/pembayaran")
public class PembayaranController{
    @Autowired
    private IPembayaranService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Pembayaran> findOne(@PathVariable(value = "id") String id ){
      Pembayaran entity = restService.cariPembayaranId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan") 
   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< Pembayaran >> findAll(){
      List< Pembayaran > entities = restService.semuaPembayaran();
       
      return ResponseEntity.ok().body(entities);
   }
   
//   @GetMapping("/tampilkan/{month}/{year}") 
//   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
//   public ResponseEntity<List< Pembayaran >> findAllYear(@PathVariable(value = "year") String year ){
//      List< Pembayaran > entities = restService.findByYearDate(year);
//       
//      return ResponseEntity.ok().body(entities);
//   }
//   
//   @GetMapping("/tampilkan/{year}") 
//   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
//   public ResponseEntity<List< Pembayaran >> findAllMonth(@PathVariable(value = "month") String month , @PathVariable(value = "year") String year ){
//      List< Pembayaran > entities = restService.findByMonthDate(month, year);
//       
//      return ResponseEntity.ok().body(entities);
//   }
 
   @PostMapping
  @PreAuthorize("hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody Pembayaran entity ){
      
      restService.simpanPembayaran(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  Pembayaran entity ){
      Pembayaran p =restService.cariPembayaranId(id); 
      p.setTanggalNota(entity.getTanggalNota());
      p.setBiayaDokter(entity.getBiayaDokter());
      p.setBiayaLab(entity.getBiayaLab());
      p.setBiayaObat(entity.getBiayaObat());
      p.setTotalBiaya(entity.getTotalBiaya());
        restService.simpanPembayaran(p);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
 
  @DeleteMapping("/hapus/{id}")
  @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusPembayaranId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
   
}
