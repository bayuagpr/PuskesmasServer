/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Pendaftaran;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IPendaftaranService {


    Pendaftaran cariKunjunganId(Integer id);


    Pendaftaran cariTanggalKunjungan(Date tgl);


    void hapusKunjunganId(Integer id);

 
    List<Pendaftaran> semuaKunjungan();

 
    Pendaftaran simpanPendaftaran(Pendaftaran pendaftaran);


    boolean terdapatKunjungan(Date tgl);


    boolean terdapatKunjunganId(Integer id);
    
//    List<Pendaftaran> findByNowDate();
    
}
