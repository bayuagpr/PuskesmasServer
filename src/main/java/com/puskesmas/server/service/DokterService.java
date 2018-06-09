/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.DokterDAO;
import com.puskesmas.server.model.Dokter;
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
public class DokterService implements IDokterService{
        @Autowired
	DokterDAO dokter;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Dokter> semuaDokter() {
		return (List<Dokter>) dokter.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Dokter cariDokterId(String id) {
		return dokter.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdDokter(String id) {
		return dokter.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
        public boolean terdapatDokter(String nama) {
		return dokter.findByNamaDokter(nama) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusDokterId(String personId) {
		dokter.deleteById(personId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Dokter simpanDokter(Dokter d) {
		return dokter.save(d);
	}

        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Dokter cariNamaDokter(String nama){
            return dokter.findByNamaDokter(nama);
        }
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Dokter cariSpealis(String sp){
            return dokter.findBySpesialis(sp);
        }
        
}
