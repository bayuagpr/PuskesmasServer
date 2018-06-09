/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.dao;

import com.puskesmas.server.model.Pasien;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface PasienDAO extends JpaRepository<Pasien, String>{
    Pasien findByNamaPasien(String namaPasien);
    Pasien findByTglLahir(String tglLahir);
    Pasien findByPekerjaan(String pekerjaan);
    Pasien findByJenisKelamin(String jenisKelamin);
    Pasien findByAlamat(String alamat);
    Pasien findByNoTelp(String noTelp);
    
}
