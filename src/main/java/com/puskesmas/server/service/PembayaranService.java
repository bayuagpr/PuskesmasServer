/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.PembayaranDAO;
import com.puskesmas.server.model.Pembayaran;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC-11
 */
@Service
public class PembayaranService implements IPembayaranService{
        @Autowired
	PembayaranDAO pembayaran;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Pembayaran> semuaPembayaran() {
		return (List<Pembayaran>) pembayaran.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Pembayaran cariPembayaranId(String id) {
		return pembayaran.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdPembayaran(String id) {
		return pembayaran.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatPembayaran(Date tanggal) {
		return pembayaran.findByTanggalNota(tanggal) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusPembayaranId(String id) {
		pembayaran.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Pembayaran simpanPembayaran(Pembayaran bayar) {
		return pembayaran.save(bayar);
	}

        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Pembayaran cariNotaTanggal(Date tanggal){
            return pembayaran.findByTanggalNota(tanggal);
        }
        
//         @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
//    @Override
//        public List<Pembayaran> findByMonthDate(String month, String year){
//            return pembayaran.findByMonthDate(month, year);
//        }
//        
//         @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
//    @Override
//        public List<Pembayaran> findByYearDate(String year){
//            return pembayaran.findByYearDate(year);
//        }
        
        
}
