/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.LayananDAO;
import com.puskesmas.server.model.Layanan;
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
public class LayananService implements ILayananService{
        @Autowired
	LayananDAO layanan;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Layanan> semuaLayanan() {
		return (List<Layanan>) layanan.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Layanan cariLayananId(String name) {
		return layanan.getOne(name);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIDLayanan(String id) {
		return layanan.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatLayanan(String jenis) {
		return layanan.findByJenisPemeriksaan(jenis) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusLayananId(String id) {
		layanan.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Layanan simpanLayanan(Layanan l) {
		return layanan.save(l);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Layanan cariJenisPemeriksaan(String jenis){
            return layanan.findByJenisPemeriksaan(jenis);
        }
        
       
}
