/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "obat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obat.findAll", query = "SELECT o FROM Obat o"),
    @NamedQuery(name = "Obat.findByIdObat", query = "SELECT o FROM Obat o WHERE o.idObat = :idObat"),
    @NamedQuery(name = "Obat.findByNamaObat", query = "SELECT o FROM Obat o WHERE o.namaObat = :namaObat"),
    @NamedQuery(name = "Obat.findByStok", query = "SELECT o FROM Obat o WHERE o.stok = :stok"),
    @NamedQuery(name = "Obat.findByHargaObat", query = "SELECT o FROM Obat o WHERE o.hargaObat = :hargaObat")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idObat", scope = Obat.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Obat implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_obat")
    private String namaObat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stok")
    private int stok;
    @Basic(optional = false)
    @NotNull
    @Column(name = "harga_obat")
    private int hargaObat;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_obat")
    private String idObat;
    @OneToMany(mappedBy = "idObat")
    @JsonBackReference(value="obatResep")
    private List<Resep> resepList;

    public Obat() {
    }

    public Obat(String idObat) {
        this.idObat = idObat;
    }

    public Obat(String idObat, String namaObat, int stok, int hargaObat) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.stok = stok;
        this.hargaObat = hargaObat;
    }

    public String getIdObat() {
        return idObat;
    }

    public void setIdObat(String idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }


    public int getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(int hargaObat) {
        this.hargaObat = hargaObat;
    }

    @XmlTransient
    public List<Resep> getResepList() {
        return resepList;
    }

    public void setResepList(List<Resep> resepList) {
        this.resepList = resepList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObat != null ? idObat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obat)) {
            return false;
        }
        Obat other = (Obat) object;
        if ((this.idObat == null && other.idObat != null) || (this.idObat != null && !this.idObat.equals(other.idObat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }


    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    
}
