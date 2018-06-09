/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.HasilPemeriksaan;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IHasilPemeriksaanService {

    HasilPemeriksaan cariPeriksaId(String name);

    void hapusPeriksaId(String id);

    List<HasilPemeriksaan> semuaHasilPeriksa();

    HasilPemeriksaan simpanHasilPeriksa(HasilPemeriksaan hp);

    boolean terdapatIdPeriksa(String id);
    
}
