/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.PasienDAO;
import com.puskesmas.server.model.Pasien;
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
public class PasienService implements IPasienService{
        @Autowired
	PasienDAO pasien;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Pasien> semuaPasien() {
		return (List<Pasien>) pasien.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Pasien cariPasienId(String id) {
		return pasien.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean pasienTerdaftar(String id) {
		return pasien.existsById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusPasienId(String id) {
		pasien.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Pasien  simpanPasien(Pasien person) {
		return pasien.save(person);
	}

        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Pasien cariNamaPasien(String nama){
            return pasien.findByNamaPasien(nama);
        }
        
        
        
        
}
