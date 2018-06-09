/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.DaftarPoliDAO;
import com.puskesmas.server.model.DaftarPoli;
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
public class DaftarPoliService implements IDaftarPoliService{
        @Autowired
	DaftarPoliDAO poli;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<DaftarPoli> semuaPoli() {
		return (List<DaftarPoli>) poli.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public DaftarPoli cariPoliId(String idPoli) {
		return poli.getOne(idPoli);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdPoli(String idPoli) {
		return poli.existsById(idPoli);
	}
        
        @Override
        @Transactional(propagation = Propagation.REQUIRED)
        public boolean terdapatPoli(String nama) {
		return poli.findByNamaPoli(nama) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusPoliId(String idPoli) {
		poli.deleteById(idPoli);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public DaftarPoli simpanPoli(DaftarPoli pl) {
		return poli.save(pl);
	}


        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public DaftarPoli cariNamaPoli(String nama){
            return poli.findByNamaPoli(nama);
        }
        
}
