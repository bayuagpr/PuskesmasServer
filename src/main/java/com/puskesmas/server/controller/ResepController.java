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
import com.puskesmas.server.model.Resep;
import com.puskesmas.server.service.IResepService;
import com.puskesmas.server.service.ResepService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/resep")
public class ResepController{
    
    @Autowired
    private IResepService restService;
    
    @GetMapping("/tampilkan/{id}")
    @PreAuthorize("hasAuthority('Pengelola Puskesmas') or hasAuthority('Apoteker Farmasi') or hasAuthority('Pengelola Puskesmas')")
    public ResponseEntity<Resep> findOne(@PathVariable(value = "id") String id ){
      Resep entity = restService.cariResepId(id);
      System.out.println(entity.toString());
      return ResponseEntity.ok().body(entity);
   }
   
   @GetMapping("/tampilkan")
   @PreAuthorize("hasAuthority('Pengelola Puskesmas') or hasAuthority('Apoteker Farmasi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<List< Resep >> findAll(){
      List< Resep > entities = restService.semuaResep();
       
      return ResponseEntity.ok().body(entities);
   }
 
   @PostMapping
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> create(@RequestBody Resep entity ){
      
      restService.simpanResep(entity);
      return ResponseEntity.ok().body("Data tersimpan.");
   }
  
  @PutMapping("/renewal/{id}")
  @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
  public ResponseEntity<?> updateOne(@PathVariable("id") String id,@Valid @RequestBody  Resep entity ){
      Resep r =restService.cariResepId(id); 
      r.setDosis(entity.getDosis());
      r.setPemakaian(entity.getPemakaian());
        restService.simpanResep(r);
      return ResponseEntity.ok().body("Data terbaru pada id "+ id);
   }
  
//   @RequestMapping(value = "/refresh", method = RequestMethod.PUT)
//   public ResponseEntity<?> updateAll(){
//      restService.semuaResep();
//      return ResponseEntity.ok().body("Data terbaru.");
//   }
 
   @DeleteMapping("/hapus/{id}")
   @PreAuthorize("hasAuthority('Dokter Umum') or hasAuthority('Dokter Gigi') or hasAuthority('Pengelola Puskesmas')")
   public ResponseEntity<?> delete(@PathVariable("id") String id){
        restService.hapusResepId(id);
        return ResponseEntity.ok().body("Sukses terhapus.");
   }
}
