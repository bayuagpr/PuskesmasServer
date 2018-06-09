/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "pendaftaran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendaftaran.findAll", query = "SELECT p FROM Pendaftaran p"),
    @NamedQuery(name = "Pendaftaran.findByIdPendaftaran", query = "SELECT p FROM Pendaftaran p WHERE p.idPendaftaran = :idPendaftaran"),
    @NamedQuery(name = "Pendaftaran.findByTanggalKunjungan", query = "SELECT p FROM Pendaftaran p WHERE p.tanggalKunjungan = :tanggalKunjungan")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPendaftaran", scope = Pendaftaran.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pendaftaran implements Serializable {

    @Column(name = "tanggal_kunjungan")
    @Temporal(TemporalType.DATE)
    private Date tanggalKunjungan;
    @OneToOne(mappedBy = "idPendaftaran")
    private Keluhan keluhan;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_pendaftaran")
    private Integer idPendaftaran;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPendaftaran")
    private Pembayaran pembayaran;
    @JoinColumn(name = "id_pasien", referencedColumnName = "id_pasien")
    @OneToOne(optional = false)
    @JsonIgnoreProperties("pendaftaran")
    private Pasien idPasien;
    @JoinColumn(name = "id_poli", referencedColumnName = "id_poli")
    @OneToOne(optional = false)
    @JsonIgnoreProperties("pendaftaran")
    private DaftarPoli idPoli;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPendaftaran")
    private MedicalRecord medicalRecord;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPendaftaran")
    private HasilPemeriksaan hasilPemeriksaan;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPendaftaran")
    private HasilLab hasilLab;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPendaftaran")
    private Resep resep;

    public Pendaftaran() {
    }

    public Pendaftaran(Integer idPendaftaran) {
        this.idPendaftaran = idPendaftaran;
    }

    public Pendaftaran(Integer idPendaftaran, Date tanggalKunjungan) {
        this.idPendaftaran = idPendaftaran;
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public Integer getIdPendaftaran() {
        return idPendaftaran;
    }

    public void setIdPendaftaran(Integer idPendaftaran) {
        this.idPendaftaran = idPendaftaran;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    
    public Pasien getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Pasien idPasien) {
        this.idPasien = idPasien;
    }

    public DaftarPoli getIdPoli() {
        return idPoli;
    }

    public void setIdPoli(DaftarPoli idPoli) {
        this.idPoli = idPoli;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public HasilPemeriksaan getHasilPemeriksaan() {
        return hasilPemeriksaan;
    }

    public void setHasilPemeriksaan(HasilPemeriksaan hasilPemeriksaan) {
        this.hasilPemeriksaan = hasilPemeriksaan;
    }

    public HasilLab getHasilLab() {
        return hasilLab;
    }

    public void setHasilLab(HasilLab hasilLab) {
        this.hasilLab = hasilLab;
    }

    public Resep getResep() {
        return resep;
    }

    public void setResep(Resep resep) {
        this.resep = resep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPendaftaran != null ? idPendaftaran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendaftaran)) {
            return false;
        }
        Pendaftaran other = (Pendaftaran) object;
        if ((this.idPendaftaran == null && other.idPendaftaran != null) || (this.idPendaftaran != null && !this.idPendaftaran.equals(other.idPendaftaran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }

    public Date getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    public void setTanggalKunjungan(Date tanggalKunjungan) {
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public Keluhan getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(Keluhan keluhan) {
        this.keluhan = keluhan;
    }
    
}
