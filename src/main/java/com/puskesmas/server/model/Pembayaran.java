/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "pembayaran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pembayaran.findAll", query = "SELECT p FROM Pembayaran p"),
    @NamedQuery(name = "Pembayaran.findByIdPembayaran", query = "SELECT p FROM Pembayaran p WHERE p.idPembayaran = :idPembayaran"),
    @NamedQuery(name = "Pembayaran.findByBiayaObat", query = "SELECT p FROM Pembayaran p WHERE p.biayaObat = :biayaObat"),
    @NamedQuery(name = "Pembayaran.findByBiayaLab", query = "SELECT p FROM Pembayaran p WHERE p.biayaLab = :biayaLab"),
    @NamedQuery(name = "Pembayaran.findByBiayaDokter", query = "SELECT p FROM Pembayaran p WHERE p.biayaDokter = :biayaDokter"),
    @NamedQuery(name = "Pembayaran.findByTanggalNota", query = "SELECT p FROM Pembayaran p WHERE p.tanggalNota = :tanggalNota"),
    @NamedQuery(name = "Pembayaran.findByTotalBiaya", query = "SELECT p FROM Pembayaran p WHERE p.totalBiaya = :totalBiaya")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPembayaran", scope = Pembayaran.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pembayaran implements Serializable {

    @Column(name = "tanggal_nota")
    @Temporal(TemporalType.DATE)
    private Date tanggalNota;
    @Column(name = "total_biaya")
    private Integer totalBiaya;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_pembayaran")
    private String idPembayaran;
    @Column(name = "biaya_obat")
    private Integer biayaObat;
    @Column(name = "biaya_lab")
    private Integer biayaLab;
    @Column(name = "biaya_dokter")
    private Integer biayaDokter;
    @JoinColumn(name = "id_pasien", referencedColumnName = "id_pasien")
    @ManyToOne
    //@JsonManagedReference(value="pasienPembayaran")
    private Pasien idPasien;
    @JoinColumn(name = "id_resep", referencedColumnName = "id_resep")
    @ManyToOne
    //@JsonManagedReference(value="pembayaranResep")
    private Resep idResep;
    @JoinColumn(name = "id_layanan", referencedColumnName = "id_layanan")
    @ManyToOne
    //@JsonManagedReference(value="layananPembayaran")
    private Layanan idLayanan;
    @JoinColumn(name = "id_pendaftaran", referencedColumnName = "id_pendaftaran")
    @OneToOne(optional = false)
    private Pendaftaran idPendaftaran;

    public Pembayaran() {
    }

    public Pembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public Pembayaran(String idPembayaran, Date tanggalNota, int totalBiaya) {
        this.idPembayaran = idPembayaran;
        this.tanggalNota = tanggalNota;
        this.totalBiaya = totalBiaya;
    }

    public String getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public Integer getBiayaObat() {
        return biayaObat;
    }

    public void setBiayaObat(Integer biayaObat) {
        this.biayaObat = biayaObat;
    }

    public Integer getBiayaLab() {
        return biayaLab;
    }

    public void setBiayaLab(Integer biayaLab) {
        this.biayaLab = biayaLab;
    }

    public Integer getBiayaDokter() {
        return biayaDokter;
    }

    public void setBiayaDokter(Integer biayaDokter) {
        this.biayaDokter = biayaDokter;
    }

    public Date getTanggalNota() {
        return tanggalNota;
    }

    public void setTanggalNota(Date tanggalNota) {
        this.tanggalNota = tanggalNota;
    }

    public int getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(int totalBiaya) {
        this.totalBiaya = totalBiaya;
    }
    
    
    public Pasien getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Pasien idPasien) {
        this.idPasien = idPasien;
    }
    
    
    public Resep getIdResep() {
        return idResep;
    }

    public void setIdResep(Resep idResep) {
        this.idResep = idResep;
    }
    
    
    public Layanan getIdLayanan() {
        return idLayanan;
    }

    public void setIdLayanan(Layanan idLayanan) {
        this.idLayanan = idLayanan;
    }

    public Pendaftaran getIdPendaftaran() {
        return idPendaftaran;
    }

    public void setIdPendaftaran(Pendaftaran idPendaftaran) {
        this.idPendaftaran = idPendaftaran;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPembayaran != null ? idPembayaran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pembayaran)) {
            return false;
        }
        Pembayaran other = (Pembayaran) object;
        if ((this.idPembayaran == null && other.idPembayaran != null) || (this.idPembayaran != null && !this.idPembayaran.equals(other.idPembayaran))) {
            return false;
        }
        return true;
    }

   @Override
    public String toString() {
        return "return not null";
    }


    public void setTotalBiaya(Integer totalBiaya) {
        this.totalBiaya = totalBiaya;
    }
    
}
