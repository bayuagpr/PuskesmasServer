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
 * @author Administrator
 */
@Entity
@Table(name = "hasil_lab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HasilLab.findAll", query = "SELECT h FROM HasilLab h"),
    @NamedQuery(name = "HasilLab.findByIdHasilLab", query = "SELECT h FROM HasilLab h WHERE h.idHasilLab = :idHasilLab"),
    @NamedQuery(name = "HasilLab.findByJenisTes", query = "SELECT h FROM HasilLab h WHERE h.jenisTes = :jenisTes"),
    @NamedQuery(name = "HasilLab.findByHasilLab", query = "SELECT h FROM HasilLab h WHERE h.hasilLab = :hasilLab")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idHasilLab", scope = HasilLab.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HasilLab extends AuditModel {

    @Size(max = 25)
    @Column(name = "jenis_tes")
    private String jenisTes;
    @Size(max = 100)
    @Column(name = "hasil_lab")
    private String hasilLab;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_hasil_lab")
    private String idHasilLab;
    @JoinColumn(name = "id_pasien", referencedColumnName = "id_pasien")
    @OneToOne
    private Pasien idPasien;
    @JoinColumn(name = "id_pendaftaran", referencedColumnName = "id_pendaftaran")
    @OneToOne(optional = false)
    private Pendaftaran idPendaftaran;

    public HasilLab() {
    }

    public HasilLab(String idHasilLab) {
        this.idHasilLab = idHasilLab;
    }

    public HasilLab(String idHasilLab, String jenisTes, String hasilLab) {
        this.idHasilLab = idHasilLab;
        this.jenisTes = jenisTes;
        this.hasilLab = hasilLab;
    }

    public String getIdHasilLab() {
        return idHasilLab;
    }

    public void setIdHasilLab(String idHasilLab) {
        this.idHasilLab = idHasilLab;
    }

    public String getJenisTes() {
        return jenisTes;
    }

    public void setJenisTes(String jenisTes) {
        this.jenisTes = jenisTes;
    }

    public String getHasilLab() {
        return hasilLab;
    }

    public void setHasilLab(String hasilLab) {
        this.hasilLab = hasilLab;
    }

    public Pasien getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Pasien idPasien) {
        this.idPasien = idPasien;
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
        hash += (idHasilLab != null ? idHasilLab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasilLab)) {
            return false;
        }
        HasilLab other = (HasilLab) object;
        if ((this.idHasilLab == null && other.idHasilLab != null) || (this.idHasilLab != null && !this.idHasilLab.equals(other.idHasilLab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }

    
}
