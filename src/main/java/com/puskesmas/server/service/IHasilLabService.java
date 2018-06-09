/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.HasilLab;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IHasilLabService {

    HasilLab cariHasilLabId(String id);

    HasilLab cariJenisTes(String nama);

    void hapusHasilLabId(String id);

    List<HasilLab> semuaHasilLab();

    HasilLab simpanHasilLab(HasilLab hl);

    boolean terdapatHasilLab(String hasil);

    boolean terdapatIdHasilLab(String id);
    
}
