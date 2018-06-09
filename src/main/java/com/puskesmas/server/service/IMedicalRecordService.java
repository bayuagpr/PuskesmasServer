/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.MedicalRecord;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IMedicalRecordService {

    MedicalRecord cariRekamId(String id);

    void hapusRekamId(String id);

    List<MedicalRecord> semuaRekamMedis();

    MedicalRecord simpanRekam(MedicalRecord person);

    boolean terdapatIdRekam(String id);
    
}
