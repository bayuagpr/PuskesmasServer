/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "daftar_poli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaftarPoli.findAll", query = "SELECT d FROM DaftarPoli d"),
    @NamedQuery(name = "DaftarPoli.findByIdPoli", query = "SELECT d FROM DaftarPoli d WHERE d.idPoli = :idPoli"),
    @NamedQuery(name = "DaftarPoli.findByNamaPoli", query = "SELECT d FROM DaftarPoli d WHERE d.namaPoli = :namaPoli")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPoli", scope = DaftarPoli.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DaftarPoli implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nama_poli")
    private String namaPoli;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_poli")
    private String idPoli;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPoli")
    @JsonIgnoreProperties("idPoli")
    private Pendaftaran pendaftaran;
    @OneToMany(mappedBy = "idPoli")
    @JsonBackReference(value="poliDokter")
    private List<Dokter> dokterList;

    public DaftarPoli() {
    }

    public DaftarPoli(String idPoli) {
        this.idPoli = idPoli;
    }

    public DaftarPoli(String idPoli, String namaPoli) {
        this.idPoli = idPoli;
        this.namaPoli = namaPoli;
    }

    public String getIdPoli() {
        return idPoli;
    }

    public void setIdPoli(String idPoli) {
        this.idPoli = idPoli;
    }

    public String getNamaPoli() {
        return namaPoli;
    }

    public void setNamaPoli(String namaPoli) {
        this.namaPoli = namaPoli;
    }

    public Pendaftaran getPendaftaran() {
        return pendaftaran;
    }

    public void setPendaftaran(Pendaftaran pendaftaran) {
        this.pendaftaran = pendaftaran;
    }

    @XmlTransient
    public List<Dokter> getDokterList() {
        return dokterList;
    }

    public void setDokterList(List<Dokter> dokterList) {
        this.dokterList = dokterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoli != null ? idPoli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaftarPoli)) {
            return false;
        }
        DaftarPoli other = (DaftarPoli) object;
        if ((this.idPoli == null && other.idPoli != null) || (this.idPoli != null && !this.idPoli.equals(other.idPoli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "return not null";
    }

}
