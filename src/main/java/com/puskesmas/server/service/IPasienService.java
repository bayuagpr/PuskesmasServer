/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Pasien;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IPasienService {


    Pasien cariNamaPasien(String nama);


    Pasien cariPasienId(String id);


    void hapusPasienId(String id);


    boolean pasienTerdaftar(String id);


    List<Pasien> semuaPasien();


    Pasien simpanPasien(Pasien person);
    
}
