/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.MedicalRecordDAO;
import com.puskesmas.server.model.MedicalRecord;
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
public class MedicalRecordService implements IMedicalRecordService{
        @Autowired
	MedicalRecordDAO medRec;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<MedicalRecord> semuaRekamMedis() {
		return (List<MedicalRecord>) medRec.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public MedicalRecord cariRekamId(String id) {
		return medRec.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdRekam(String id) {
		return medRec.existsById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusRekamId(String id) {
		medRec.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public MedicalRecord simpanRekam(MedicalRecord person) {
		return medRec.save(person);
	}

	
        
       
}
