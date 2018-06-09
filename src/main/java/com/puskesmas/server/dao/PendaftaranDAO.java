/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.dao;

import com.puskesmas.server.model.Pendaftaran;
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
public interface PendaftaranDAO extends JpaRepository<Pendaftaran, Integer>{
    Pendaftaran findByTanggalKunjungan(Date tanggalKunjungan);
    
//    @Query("SELECT p FROM pendaftaran p WHERE DATE(p.tanggalKunjungan) = DATE(NOW())")
//    List<Pendaftaran> findByNowDate();
    
}
