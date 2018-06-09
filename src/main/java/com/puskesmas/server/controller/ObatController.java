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
import com.puskesmas.server.model.Obat;

import com.puskesmas.server.service.IObatService;

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
@RequestMapping("/obat")
public class ObatController{
    @Autowired
    private IObatService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Apoteker Farmasi') or hasAuthority('Admin Keuangan') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Obat> findOne(@PathVariable(value = "id") String id ){
      Obat entity = restService.cariObatId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
    @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Apoteker Farmasi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< Obat >> findAll(){
      List< Obat > entities = restService.semuaObat();
       
      return ResponseEntity.ok().body(entities);
   }
 
  @PostMapping
   @PreAuthorize("hasAuthority('Apoteker Farmasi') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> create(@RequestBody Obat entity ){
      
      restService.simpanObat(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Apoteker Farmasi') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  Obat entity ){
      Obat o =restService.cariObatId(id); 
      o.setNamaObat(entity.getNamaObat());
      o.setHargaObat(entity.getHargaObat());
      o.setStok(entity.getStok());
        restService.simpanObat(o);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
 
   @DeleteMapping("/hapus/{id}")
  @PreAuthorize("hasAuthority('Apoteker Farmasi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusObatId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
   
   
   @GetMapping("/cari/{nama}")
   @PreAuthorize("hasAuthority('Apoteker Farmasi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<Obat> findName(@PathVariable("nama") String nama ){
      Obat entity = restService.cariNamaObat(nama);
      return ResponseEntity.ok().body(entity);
   }
}
