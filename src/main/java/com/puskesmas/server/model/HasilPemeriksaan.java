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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "hasil_pemeriksaan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HasilPemeriksaan.findAll", query = "SELECT h FROM HasilPemeriksaan h"),
    @NamedQuery(name = "HasilPemeriksaan.findByIdHasil", query = "SELECT h FROM HasilPemeriksaan h WHERE h.idHasil = :idHasil")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idHasil", scope = HasilPemeriksaan.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HasilPemeriksaan extends AuditModel {

    @Size(max = 5)
    @Column(name = "id_keluhan")
    private String idKeluhan;


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_hasil")
    private String idHasil;
    @OneToMany(mappedBy = "idHasil")
    @JsonBackReference(value="periksaRec")
    private List<MedicalRecord> medicalRecordList;
    @JoinColumn(name = "id_pasien", referencedColumnName = "id_pasien")
    @ManyToOne
    //@JsonManagedReference(value="pasienPeriksa")
    private Pasien idPasien;
    @JoinColumn(name = "id_dokter", referencedColumnName = "id_dokter")
    @ManyToOne
    //@JsonManagedReference(value="periksaDokter")
    private Dokter idDokter;
    @JoinColumn(name = "id_diagnosa", referencedColumnName = "id_diagnosa")
    @ManyToOne
    //@JsonManagedReference(value="periksaDiagnosa")
    private Diagnosa idDiagnosa;
    @JoinColumn(name = "id_pendaftaran", referencedColumnName = "id_pendaftaran")
    @OneToOne(optional = false)
    private Pendaftaran idPendaftaran;

    public HasilPemeriksaan() {
    }

    public HasilPemeriksaan(String idHasil) {
        this.idHasil = idHasil;
    }

    public String getIdHasil() {
        return idHasil;
    }

    public void setIdHasil(String idHasil) {
        this.idHasil = idHasil;
    }

    @XmlTransient
    public List<MedicalRecord> getMedicalRecordList() {
        return medicalRecordList;
    }

    public void setMedicalRecordList(List<MedicalRecord> medicalRecordList) {
        this.medicalRecordList = medicalRecordList;
    }
    
    
    public Pasien getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Pasien idPasien) {
        this.idPasien = idPasien;
    }
     
   
    public Dokter getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Dokter idDokter) {
        this.idDokter = idDokter;
    }
    
    
    public Diagnosa getIdDiagnosa() {
        return idDiagnosa;
    }

    public void setIdDiagnosa(Diagnosa idDiagnosa) {
        this.idDiagnosa = idDiagnosa;
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
        hash += (idHasil != null ? idHasil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasilPemeriksaan)) {
            return false;
        }
        HasilPemeriksaan other = (HasilPemeriksaan) object;
        if ((this.idHasil == null && other.idHasil != null) || (this.idHasil != null && !this.idHasil.equals(other.idHasil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }

    public String getIdKeluhan() {
        return idKeluhan;
    }

    public void setIdKeluhan(String idKeluhan) {
        this.idKeluhan = idKeluhan;
    }


    
}
