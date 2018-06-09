/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Resep;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IResepService {


    Resep cariResepId(String id);


    void hapusResepId(String id);


    List<Resep> semuaResep();


    Resep simpanResep(Resep rsp);


    boolean terdapatResepId(String id);
    
}
