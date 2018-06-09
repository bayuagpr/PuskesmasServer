/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.dao;

import com.puskesmas.server.model.Pembayaran;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface PembayaranDAO extends JpaRepository<Pembayaran, String>{

    Pembayaran findByTanggalNota(Date tanggalNota);
    
//    @Query("SELECT p FROM pembayaran p WHERE MONTH(p.tanggalNota)=:month AND YEAR(p.tanggalNota)=:year")
//    List<Pembayaran> findByMonthDate(String month, String year);
//    
//    @Query("SELECT p FROM pembayaran p WHERE YEAR(p.tanggalNota)=:year")
//    List<Pembayaran> findByYearDate(String year);
    
}
