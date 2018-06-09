/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;


import com.puskesmas.server.dao.ObatDAO;
import com.puskesmas.server.model.Obat;
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
public class ObatService implements IObatService{
        @Autowired
	ObatDAO obat;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public List<Obat> semuaObat() {
		return (List<Obat>) obat.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
	public Obat cariObatId(String id) {
		return obat.getOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatIdObat(String id) {
		return obat.existsById(id);
	}
        
        @Transactional(propagation = Propagation.REQUIRED)
    @Override
	public boolean terdapatObat(String o) {
		return obat.findByNamaObat(o) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public void hapusObatId(String id) {
		obat.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    @Override
	public Obat simpanObat(Obat obt) {
		return obat.save(obt);
	}
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Obat cariNamaObat(String nama){
            return obat.findByNamaObat(nama);
        }
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
        public Obat stokObat(Integer stok){
            return obat.findByStok(stok);
        }
        
}
