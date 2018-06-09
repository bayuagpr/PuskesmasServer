/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.KeluhanDAO;
import com.puskesmas.server.model.Keluhan;
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
public class KeluhanService implements IKeluhanService{
        @Autowired
	KeluhanDAO keluhan;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
        @Override
	public List<Keluhan> semuaKeluhan() {
		return (List<Keluhan>) keluhan.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Keluhan cariKeluhanId(String id) {
		return keluhan.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdKeluhan(String id) {
		return keluhan.existsById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusKeluhanId(String id) {
		keluhan.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Keluhan simpanKeluhan(Keluhan kl) {
		return keluhan.save(kl);
	}


        
        
}
