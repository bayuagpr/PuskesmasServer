/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.DiagnosaDAO;
import com.puskesmas.server.model.Diagnosa;
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
public class DiagnosaService implements IDiagnosaService{
        @Autowired
	DiagnosaDAO diagnosa;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Diagnosa> semuaDiagnosa() {
		return (List<Diagnosa>) diagnosa.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Diagnosa cariDiagnosaId(String id) {
		return diagnosa.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdDiagnosa(String id) {
		return diagnosa.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
        public boolean terdapatDiagnosa(String hasil) {
		return diagnosa.findByHasilDiagnosa(hasil) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusDiagnosaId(String id) {
		diagnosa.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Diagnosa simpanDiagnosa(Diagnosa d) {
		return diagnosa.save(d);
	}

	
        
        
}
