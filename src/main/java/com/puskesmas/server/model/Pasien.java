/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "pasien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasien.findAll", query = "SELECT p FROM Pasien p"),
    @NamedQuery(name = "Pasien.findByIdPasien", query = "SELECT p FROM Pasien p WHERE p.idPasien = :idPasien"),
    @NamedQuery(name = "Pasien.findByNamaPasien", query = "SELECT p FROM Pasien p WHERE p.namaPasien = :namaPasien"),
    @NamedQuery(name = "Pasien.findByTglLahir", query = "SELECT p FROM Pasien p WHERE p.tglLahir = :tglLahir"),
    @NamedQuery(name = "Pasien.findByPekerjaan", query = "SELECT p FROM Pasien p WHERE p.pekerjaan = :pekerjaan"),
    @NamedQuery(name = "Pasien.findByJenisKelamin", query = "SELECT p FROM Pasien p WHERE p.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Pasien.findByAlamat", query = "SELECT p FROM Pasien p WHERE p.alamat = :alamat"),
    @NamedQuery(name = "Pasien.findByNoTelp", query = "SELECT p FROM Pasien p WHERE p.noTelp = :noTelp")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPasien", scope = Pasien.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pasien extends AuditModel {

    @Size(max = 100)
    @Column(name = "nama_pasien")
    private String namaPasien;
    @Column(name = "tgl_lahir")
    @Temporal(TemporalType.DATE)
    private Date tglLahir;
    @Size(max = 30)
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Size(max = 2)
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
    @Size(max = 50)
    @Column(name = "alamat")
    private String alamat;
    @Size(max = 20)
    @Column(name = "no_telp")
    private String noTelp;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_pasien")
    private String idPasien;
    @OneToMany(mappedBy = "idPasien")
    @JsonBackReference(value="pasienPembayaran")
    private List<Pembayaran> pembayaranList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPasien")
    @JsonIgnoreProperties("idPasien")
    private Pendaftaran pendaftaran;
    @OneToMany(mappedBy = "idPasien")
    @JsonBackReference(value="periksaRec")
    private List<MedicalRecord> medicalRecordList;
    @OneToMany(mappedBy = "idPasien")
    @JsonBackReference(value="pasienPeriksa")
    private List<HasilPemeriksaan> hasilPemeriksaanList;
    @OneToMany(mappedBy = "idPasien")
    @JsonBackReference(value="pasienDiagnosa")
    private List<Diagnosa> diagnosaList;
    @OneToOne(mappedBy = "idPasien")
    private HasilLab hasilLab;

    public Pasien() {
    }

    public Pasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public Pasien(String idPasien, String namaPasien, Date tglLahir, String pekerjaan, String jenisKelamin, String alamat, String noTelp) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.tglLahir = tglLahir;
        this.pekerjaan = pekerjaan;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }


    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }


    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    @XmlTransient
    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }
    

    public Pendaftaran getPendaftaran() {
        return pendaftaran;
    }

    public void setPendaftaran(Pendaftaran pendaftaran) {
        this.pendaftaran = pendaftaran;
    }

    @XmlTransient
    public List<MedicalRecord> getMedicalRecordList() {
        return medicalRecordList;
    }

    public void setMedicalRecordList(List<MedicalRecord> medicalRecordList) {
        this.medicalRecordList = medicalRecordList;
    }

    @XmlTransient
    public List<HasilPemeriksaan> getHasilPemeriksaanList() {
        return hasilPemeriksaanList;
    }

    public void setHasilPemeriksaanList(List<HasilPemeriksaan> hasilPemeriksaanList) {
        this.hasilPemeriksaanList = hasilPemeriksaanList;
    }

    @XmlTransient
    public List<Diagnosa> getDiagnosaList() {
        return diagnosaList;
    }

    public void setDiagnosaList(List<Diagnosa> diagnosaList) {
        this.diagnosaList = diagnosaList;
    }

    public HasilLab getHasilLab() {
        return hasilLab;
    }

    public void setHasilLab(HasilLab hasilLab) {
        this.hasilLab = hasilLab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasien != null ? idPasien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasien)) {
            return false;
        }
        Pasien other = (Pasien) object;
        if ((this.idPasien == null && other.idPasien != null) || (this.idPasien != null && !this.idPasien.equals(other.idPasien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }



    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }



    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
}
