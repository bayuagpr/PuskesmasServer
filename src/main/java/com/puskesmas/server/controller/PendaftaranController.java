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
import com.puskesmas.server.model.Pendaftaran;

import com.puskesmas.server.service.IPendaftaranService;

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
@RequestMapping("/pendaftaran")
public class PendaftaranController{
    @Autowired
    private IPendaftaranService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Laboran Lab') or hasAuthority('Apoteker Farmasi') or hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Pendaftaran> findOne(@PathVariable(value = "id") Integer id ){
      Pendaftaran entity = restService.cariKunjunganId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
//    @GetMapping("/tampilkan")
//   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Laboran Lab') or hasAuthority('Pengelola Puskesmas')")
//   public ResponseEntity<List< Pendaftaran >> findAll(){
//      List< Pendaftaran > entities = restService.findByNowDate();
//       
//      return ResponseEntity.ok().body(entities);
//   }
 
   @PostMapping
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Laboran Lab') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody Pendaftaran entity ){
      
      restService.simpanPendaftaran(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Laboran Lab') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> updateOne(@PathVariable("id") Integer id,@Valid @RequestBody  Pendaftaran entity ){
      Pendaftaran p =restService.cariKunjunganId(id); 
      p.setTanggalKunjungan(entity.getTanggalKunjungan());
        restService.simpanPendaftaran(p);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
 
  @DeleteMapping("/hapus/{id}")
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Laboran Lab') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        restService.hapusKunjunganId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
