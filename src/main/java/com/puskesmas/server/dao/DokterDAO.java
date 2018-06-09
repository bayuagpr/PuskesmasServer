/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.dao;

import com.puskesmas.server.model.Dokter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface DokterDAO extends JpaRepository<Dokter, String>{
    Dokter findByNamaDokter(String namaDokter);
    Dokter findBySpesialis(String spesialis);
    
}
