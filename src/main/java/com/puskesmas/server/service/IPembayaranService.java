/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Pembayaran;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IPembayaranService {


    Pembayaran cariNotaTanggal(Date tanggal);


    Pembayaran cariPembayaranId(String id);


    void hapusPembayaranId(String id);


    List<Pembayaran> semuaPembayaran();


    Pembayaran simpanPembayaran(Pembayaran bayar);


    boolean terdapatIdPembayaran(String id);


    boolean terdapatPembayaran(Date tanggal);
    
//    List<Pembayaran> findByMonthDate(String month, String year);
//    
//    List<Pembayaran> findByYearDate(String year);
    
}
