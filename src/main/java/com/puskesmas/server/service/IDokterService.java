/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Dokter;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IDokterService {

    Dokter cariDokterId(String id);

    Dokter cariNamaDokter(String nama);

    Dokter cariSpealis(String sp);

    void hapusDokterId(String personId);

    List<Dokter> semuaDokter();

    Dokter simpanDokter(Dokter d);

    boolean terdapatDokter(String nama);

    boolean terdapatIdDokter(String id);
    
}
