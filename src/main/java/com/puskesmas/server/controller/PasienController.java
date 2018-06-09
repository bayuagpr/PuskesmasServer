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
import com.puskesmas.server.model.Pasien;

import com.puskesmas.server.service.IPasienService;

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
@RequestMapping("/pasien")
public class PasienController{
   @Autowired
    private IPasienService restService;
    
   @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Admin Pendaftaran') or hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Pasien> findOne(@PathVariable(value = "id") String id ){
      Pasien entity = restService.cariPasienId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
    
    @GetMapping("/cari/{nama}")
     @PreAuthorize("hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Pasien> findName(@PathVariable(value = "nama") String nama ){
      Pasien entity = restService.cariNamaPasien(nama);
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan")
  @PreAuthorize("hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< Pasien >> findAll(){
      List< Pasien > entities = restService.semuaPasien();
       
      return ResponseEntity.ok().body(entities);
   }
 
   @PostMapping
   @PreAuthorize("hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody Pasien entity ){
      
      restService.simpanPasien(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Admin Pendaftaran') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  Pasien entity ){
      Pasien p =restService.cariPasienId(id); 
      p.setNamaPasien(entity.getNamaPasien());
      p.setTglLahir(entity.getTglLahir());
      p.setJenisKelamin(entity.getJenisKelamin());
      p.setAlamat(entity.getAlamat());
      p.setPekerjaan(entity.getPekerjaan());
      p.setNoTelp(entity.getNoTelp());
        restService.simpanPasien(p);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
  
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusPasienId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
