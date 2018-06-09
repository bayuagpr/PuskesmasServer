/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.HasilLabDAO;
import com.puskesmas.server.model.HasilLab;
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
public class HasilLabService implements IHasilLabService{
        @Autowired
	HasilLabDAO lab;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<HasilLab> semuaHasilLab() {
		return (List<HasilLab>) lab.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public HasilLab cariHasilLabId(String id) {
		return lab.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdHasilLab(String id) {
		return lab.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatHasilLab(String hasil) {
		return lab.findByHasilLab(hasil) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusHasilLabId(String id) {
		lab.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public HasilLab simpanHasilLab(HasilLab hl) {
		return lab.save(hl);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public HasilLab cariJenisTes(String nama){
            return lab.findByJenisTes(nama);
        }
        
      
}
