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
@Table(name = "diagnosa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnosa.findAll", query = "SELECT d FROM Diagnosa d"),
    @NamedQuery(name = "Diagnosa.findByIdDiagnosa", query = "SELECT d FROM Diagnosa d WHERE d.idDiagnosa = :idDiagnosa"),
    @NamedQuery(name = "Diagnosa.findByHasilDiagnosa", query = "SELECT d FROM Diagnosa d WHERE d.hasilDiagnosa = :hasilDiagnosa")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDiagnosa", scope = Diagnosa.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Diagnosa extends AuditModel {

    @Size(max = 100)
    @Column(name = "hasil_diagnosa")
    private String hasilDiagnosa;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_diagnosa")
    private String idDiagnosa;
    @OneToMany(mappedBy = "idDiagnosa")
    @JsonBackReference(value="periksaDiagnosa")
    private List<HasilPemeriksaan> hasilPemeriksaanList;
    @JoinColumn(name = "id_pasien", referencedColumnName = "id_pasien")
    @ManyToOne
    //@JsonManagedReference(value="pasienDiagnosa")
    private Pasien idPasien;

    public Diagnosa() {
    }

    public Diagnosa(String idDiagnosa) {
        this.idDiagnosa = idDiagnosa;
    }

    public Diagnosa(String idDiagnosa, String hasilDiagnosa) {
        this.idDiagnosa = idDiagnosa;
        this.hasilDiagnosa = hasilDiagnosa;
    }

    public String getIdDiagnosa() {
        return idDiagnosa;
    }

    public void setIdDiagnosa(String idDiagnosa) {
        this.idDiagnosa = idDiagnosa;
    }
    
    
    public String getHasilDiagnosa() {
        return hasilDiagnosa;
    }

    public void setHasilDiagnosa(String hasilDiagnosa) {
        this.hasilDiagnosa = hasilDiagnosa;
    }

    @XmlTransient
    public List<HasilPemeriksaan> getHasilPemeriksaanList() {
        return hasilPemeriksaanList;
    }

    public void setHasilPemeriksaanList(List<HasilPemeriksaan> hasilPemeriksaanList) {
        this.hasilPemeriksaanList = hasilPemeriksaanList;
    }

    
    public Pasien getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Pasien idPasien) {
        this.idPasien = idPasien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiagnosa != null ? idDiagnosa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosa)) {
            return false;
        }
        Diagnosa other = (Diagnosa) object;
        if ((this.idDiagnosa == null && other.idDiagnosa != null) || (this.idDiagnosa != null && !this.idDiagnosa.equals(other.idDiagnosa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }


    
}
