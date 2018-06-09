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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "dokter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokter.findAll", query = "SELECT d FROM Dokter d"),
    @NamedQuery(name = "Dokter.findByIdDokter", query = "SELECT d FROM Dokter d WHERE d.idDokter = :idDokter"),
    @NamedQuery(name = "Dokter.findByNamaDokter", query = "SELECT d FROM Dokter d WHERE d.namaDokter = :namaDokter"),
    @NamedQuery(name = "Dokter.findBySpesialis", query = "SELECT d FROM Dokter d WHERE d.spesialis = :spesialis")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDokter", scope = Dokter.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dokter implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nama_dokter")
    private String namaDokter;
    @Size(max = 15)
    @Column(name = "spesialis")
    private String spesialis;
    @JoinColumn(name = "id_login", referencedColumnName = "id_login")
    @OneToOne(optional = false)
    private LoginUser idLogin;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_dokter")
    private String idDokter;
    @OneToMany(mappedBy = "idDokter")
    @JsonBackReference(value="periksaDokter")
    private List<HasilPemeriksaan> hasilPemeriksaanList;
    @JoinColumn(name = "id_poli", referencedColumnName = "id_poli")
    @ManyToOne
    //@JsonManagedReference(value="poliDokter")
    private DaftarPoli idPoli;

    public Dokter() {
    }

    public Dokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public Dokter(String idDokter, String namaDokter) {
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }


    @XmlTransient
    public List<HasilPemeriksaan> getHasilPemeriksaanList() {
        return hasilPemeriksaanList;
    }

    public void setHasilPemeriksaanList(List<HasilPemeriksaan> hasilPemeriksaanList) {
        this.hasilPemeriksaanList = hasilPemeriksaanList;
    }
    
    
    public DaftarPoli getIdPoli() {
        return idPoli;
    }

    public void setIdPoli(DaftarPoli idPoli) {
        this.idPoli = idPoli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDokter != null ? idDokter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dokter)) {
            return false;
        }
        Dokter other = (Dokter) object;
        if ((this.idDokter == null && other.idDokter != null) || (this.idDokter != null && !this.idDokter.equals(other.idDokter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }


    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public LoginUser getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(LoginUser idLogin) {
        this.idLogin = idLogin;
    }
    
}
