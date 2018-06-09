/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.service;

import com.puskesmas.server.model.Obat;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IObatService {


    Obat cariNamaObat(String nama);

    Obat cariObatId(String id);

    void hapusObatId(String id);

    List<Obat> semuaObat();

    Obat simpanObat(Obat obt);

    Obat stokObat(Integer stok);

    boolean terdapatIdObat(String id);

    boolean terdapatObat(String o);
    
}
