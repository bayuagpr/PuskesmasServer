/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.DaftarPoli;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IDaftarPoliService {


    DaftarPoli cariNamaPoli(String nama);


    DaftarPoli cariPoliId(String idPoli);

    void hapusPoliId(String idPoli);

    List<DaftarPoli> semuaPoli();

    DaftarPoli simpanPoli(DaftarPoli pl);

    boolean terdapatIdPoli(String idPoli);

    boolean terdapatPoli(String nama);
    
}
