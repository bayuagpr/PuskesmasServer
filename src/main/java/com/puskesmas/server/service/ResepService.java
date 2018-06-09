/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.ResepDAO;
import com.puskesmas.server.model.Resep;
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
public class ResepService implements IResepService{
        @Autowired
	ResepDAO resep;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Resep> semuaResep() {
		return (List<Resep>) resep.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Resep cariResepId(String id) {
		return resep.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatResepId(String id) {
		return resep.existsById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusResepId(String id) {
		resep.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Resep simpanResep(Resep rsp) {
		return resep.save(rsp);
	}

	
        
        
}
