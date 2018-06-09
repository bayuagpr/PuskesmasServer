/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Keluhan;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
public interface IKeluhanService {


    Keluhan cariKeluhanId(String id);

    void hapusKeluhanId(String id);

    List<Keluhan> semuaKeluhan();

    Keluhan simpanKeluhan(Keluhan kl);

    boolean terdapatIdKeluhan(String id);
    
}
