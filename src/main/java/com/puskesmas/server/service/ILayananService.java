/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Layanan;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface ILayananService {

    Layanan cariJenisPemeriksaan(String jenis);

    Layanan cariLayananId(String name);

    void hapusLayananId(String id);

    List<Layanan> semuaLayanan();

    Layanan simpanLayanan(Layanan l);

    boolean terdapatIDLayanan(String id);

    boolean terdapatLayanan(String jenis);
    
}
