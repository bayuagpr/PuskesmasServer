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
@Table(name = "layanan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Layanan.findAll", query = "SELECT l FROM Layanan l"),
    @NamedQuery(name = "Layanan.findByIdLayanan", query = "SELECT l FROM Layanan l WHERE l.idLayanan = :idLayanan"),
    @NamedQuery(name = "Layanan.findByJenisPemeriksaan", query = "SELECT l FROM Layanan l WHERE l.jenisPemeriksaan = :jenisPemeriksaan"),
    @NamedQuery(name = "Layanan.findByBiayaPemeriksaan", query = "SELECT l FROM Layanan l WHERE l.biayaPemeriksaan = :biayaPemeriksaan")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idLayanan", scope = Layanan.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Layanan implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "jenis_pemeriksaan")
    private String jenisPemeriksaan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biaya_pemeriksaan")
    private int biayaPemeriksaan;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_layanan")
    private String idLayanan;
    @OneToMany(mappedBy = "idLayanan")
    @JsonBackReference(value="layananPembayaran")
    private List<Pembayaran> pembayaranList;

    public Layanan() {
    }

    public Layanan(String idLayanan) {
        this.idLayanan = idLayanan;
    }

    public Layanan(String idLayanan, String jenisPemeriksaan, int biayaPemeriksaan) {
        this.idLayanan = idLayanan;
        this.jenisPemeriksaan = jenisPemeriksaan;
        this.biayaPemeriksaan = biayaPemeriksaan;
    }

    public String getIdLayanan() {
        return idLayanan;
    }

    public void setIdLayanan(String idLayanan) {
        this.idLayanan = idLayanan;
    }

    public String getJenisPemeriksaan() {
        return jenisPemeriksaan;
    }

    public void setJenisPemeriksaan(String jenisPemeriksaan) {
        this.jenisPemeriksaan = jenisPemeriksaan;
    }

    public int getBiayaPemeriksaan() {
        return biayaPemeriksaan;
    }

    public void setBiayaPemeriksaan(int biayaPemeriksaan) {
        this.biayaPemeriksaan = biayaPemeriksaan;
    }

    @XmlTransient
    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLayanan != null ? idLayanan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Layanan)) {
            return false;
        }
        Layanan other = (Layanan) object;
        if ((this.idLayanan == null && other.idLayanan != null) || (this.idLayanan != null && !this.idLayanan.equals(other.idLayanan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }


    
}
