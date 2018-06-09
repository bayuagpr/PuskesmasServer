/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.HasilPemeriksaanDAO;
import com.puskesmas.server.model.HasilPemeriksaan;
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
public class HasilPemeriksaanService implements IHasilPemeriksaanService{
        @Autowired
	HasilPemeriksaanDAO periksa;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<HasilPemeriksaan> semuaHasilPeriksa() {
		return (List<HasilPemeriksaan>) periksa.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public HasilPemeriksaan cariPeriksaId(String name) {
		return periksa.getOne(name);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdPeriksa(String id) {
		return periksa.existsById(id);
	}
        
	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusPeriksaId(String id) {
		periksa.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public HasilPemeriksaan simpanHasilPeriksa(HasilPemeriksaan hp) {
		return periksa.save(hp);
	}

	
        
        
}
