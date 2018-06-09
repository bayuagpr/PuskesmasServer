/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Diagnosa;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IDiagnosaService {

    Diagnosa cariDiagnosaId(String id);

    void hapusDiagnosaId(String id);

    List<Diagnosa> semuaDiagnosa();

    Diagnosa simpanDiagnosa(Diagnosa d);

    boolean terdapatDiagnosa(String hasil);

    boolean terdapatIdDiagnosa(String id);
    
}
