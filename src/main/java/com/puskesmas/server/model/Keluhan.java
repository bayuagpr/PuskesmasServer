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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "keluhan")
//@EntityListeners(AuditingEntityListener.class)
//Properties(value = {"tglInsert", "tglUpdate"}, 
//        allowGetters = true)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keluhan.findAll", query = "SELECT k FROM Keluhan k")
    , @NamedQuery(name = "Keluhan.findByIdKeluhan", query = "SELECT k FROM Keluhan k WHERE k.idKeluhan = :idKeluhan")
    , @NamedQuery(name = "Keluhan.findByKeluhan", query = "SELECT k FROM Keluhan k WHERE k.keluhan = :keluhan")
    , @NamedQuery(name = "Keluhan.findByTglInsert", query = "SELECT k FROM Keluhan k WHERE k.createdAt = :createdAt")
    , @NamedQuery(name = "Keluhan.findByTglUpdate", query = "SELECT k FROM Keluhan k WHERE k.updatedAt = :updatedAt")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idKeluhan", scope = Keluhan.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Keluhan extends AuditModel {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_keluhan")
    private String idKeluhan;
    @Size(max = 200)
    @Column(name = "keluhan")
    private String keluhan;
    @JoinColumn(name = "id_pendaftaran", referencedColumnName = "id_pendaftaran")
    @OneToOne
    private Pendaftaran idPendaftaran;

    public Keluhan() {
    }

    public Keluhan(String idKeluhan) {
        this.idKeluhan = idKeluhan;
    }

    public String getIdKeluhan() {
        return idKeluhan;
    }

    public void setIdKeluhan(String idKeluhan) {
        this.idKeluhan = idKeluhan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
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
        hash += (idKeluhan != null ? idKeluhan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keluhan)) {
            return false;
        }
        Keluhan other = (Keluhan) object;
        if ((this.idKeluhan == null && other.idKeluhan != null) || (this.idKeluhan != null && !this.idKeluhan.equals(other.idKeluhan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }
    
}
