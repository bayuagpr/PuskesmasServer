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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "medical_record")
//@EntityListeners(AuditingEntityListener.class)
//Properties(value = {"tglInsert", "tglUpdate"}, 
//        allowGetters = true)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicalRecord.findAll", query = "SELECT m FROM MedicalRecord m"),
    @NamedQuery(name = "MedicalRecord.findByIdMedrec", query = "SELECT m FROM MedicalRecord m WHERE m.idMedrec = :idMedrec")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMedrec", scope = MedicalRecord.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalRecord extends AuditModel {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_medrec")
    private String idMedrec;
    @JoinColumn(name = "id_pasien", referencedColumnName = "id_pasien")
    @ManyToOne
    //@JsonManagedReference(value="pasienRec")
    private Pasien idPasien;
    @JoinColumn(name = "id_hasil", referencedColumnName = "id_hasil")
    @ManyToOne
    //@JsonManagedReference(value="periksaRec")
    private HasilPemeriksaan idHasil;
    @JoinColumn(name = "id_pendaftaran", referencedColumnName = "id_pendaftaran")
    @OneToOne(optional = false)
    private Pendaftaran idPendaftaran;

    public MedicalRecord() {
    }

    public MedicalRecord(String idMedrec) {
        this.idMedrec = idMedrec;
    }

    public String getIdMedrec() {
        return idMedrec;
    }

    public void setIdMedrec(String idMedrec) {
        this.idMedrec = idMedrec;
    }
    
    
    public Pasien getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Pasien idPasien) {
        this.idPasien = idPasien;
    }
    
    
    public HasilPemeriksaan getIdHasil() {
        return idHasil;
    }

    public void setIdHasil(HasilPemeriksaan idHasil) {
        this.idHasil = idHasil;
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
        hash += (idMedrec != null ? idMedrec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalRecord)) {
            return false;
        }
        MedicalRecord other = (MedicalRecord) object;
        if ((this.idMedrec == null && other.idMedrec != null) || (this.idMedrec != null && !this.idMedrec.equals(other.idMedrec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }

    
}
