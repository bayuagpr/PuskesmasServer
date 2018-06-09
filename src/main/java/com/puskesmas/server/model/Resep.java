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
@Table(name = "resep")
//@EntityListeners(AuditingEntityListener.class)
//Properties(value = {"tglInsert", "tglUpdate"}, 
//        allowGetters = true)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resep.findAll", query = "SELECT r FROM Resep r"),
    @NamedQuery(name = "Resep.findByIdResep", query = "SELECT r FROM Resep r WHERE r.idResep = :idResep"),
    @NamedQuery(name = "Resep.findByPemakaian", query = "SELECT r FROM Resep r WHERE r.pemakaian = :pemakaian"),
    @NamedQuery(name = "Resep.findByDosis", query = "SELECT r FROM Resep r WHERE r.dosis = :dosis")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResep", scope = Resep.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resep extends AuditModel {

    @Size(max = 20)
    @Column(name = "pemakaian")
    private String pemakaian;
    @Size(max = 20)
    @Column(name = "dosis")
    private String dosis;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_resep")
    private String idResep;
    @OneToMany(mappedBy = "idResep")
    @JsonBackReference(value="pembayaranResep")
    private List<Pembayaran> pembayaranList;
    @JoinColumn(name = "id_obat", referencedColumnName = "id_obat")
    @ManyToOne
    //@JsonManagedReference(value="obatResep")
    private Obat idObat;
    @JoinColumn(name = "id_pendaftaran", referencedColumnName = "id_pendaftaran")
    @OneToOne(optional = false)
    private Pendaftaran idPendaftaran;

    public Resep() {
    }

    public Resep(String idResep) {
        this.idResep = idResep;
    }

    public Resep(String idResep, String pemakaian, String dosis) {
        this.idResep = idResep;
        this.pemakaian = pemakaian;
        this.dosis = dosis;
    }

    public String getIdResep() {
        return idResep;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }


    @XmlTransient
    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }
    
    
    public Obat getIdObat() {
        return idObat;
    }

    public void setIdObat(Obat idObat) {
        this.idObat = idObat;
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
        hash += (idResep != null ? idResep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resep)) {
            return false;
        }
        Resep other = (Resep) object;
        if ((this.idResep == null && other.idResep != null) || (this.idResep != null && !this.idResep.equals(other.idResep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }

    public String getPemakaian() {
        return pemakaian;
    }

    public void setPemakaian(String pemakaian) {
        this.pemakaian = pemakaian;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    
}
