/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.PendaftaranDAO;
import com.puskesmas.server.model.Pendaftaran;
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
public class PendaftaranService implements IPendaftaranService{
        @Autowired
	PendaftaranDAO daftar;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Pendaftaran> semuaKunjungan() {
		return (List<Pendaftaran>) daftar.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Pendaftaran cariKunjunganId(Integer id) {
		return daftar.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
        
    @Override
	public boolean terdapatKunjunganId(Integer id) {
		return daftar.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatKunjungan(Date tgl) {
		return daftar.findByTanggalKunjungan(tgl) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusKunjunganId(Integer id) {
		daftar.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Pendaftaran simpanPendaftaran(Pendaftaran pendaftaran) {
		return daftar.save(pendaftaran);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Pendaftaran cariTanggalKunjungan(Date tgl){
            return daftar.findByTanggalKunjungan(tgl);
        }
        
//         @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
//    @Override
//        public List<Pendaftaran> findByNowDate(){
//            return daftar.findByNowDate();
//        }

}
