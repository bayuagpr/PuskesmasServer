/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "login_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginUser.findAll", query = "SELECT l FROM LoginUser l"),
    @NamedQuery(name = "LoginUser.findByIdLogin", query = "SELECT l FROM LoginUser l WHERE l.idLogin = :idLogin"),
    @NamedQuery(name = "LoginUser.findByUsername", query = "SELECT l FROM LoginUser l WHERE l.username = :username"),
    @NamedQuery(name = "LoginUser.findByPassword", query = "SELECT l FROM LoginUser l WHERE l.password = :password"),
    @NamedQuery(name = "LoginUser.findByJabatan", query = "SELECT l FROM LoginUser l WHERE l.jabatan = :jabatan")})
public class LoginUser implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "jabatan")
    private String jabatan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acc_non_expired")
    private boolean accNonExpired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cred_non_expired")
    private boolean credNonExpired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acc_non_locked")
    private boolean accNonLocked;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idLogin")
    private Dokter dokter;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_login")
    private String idLogin;
    @Column
    @ElementCollection(targetClass=LoginUser.class)
    private List<LoginUser> users;

    public LoginUser() {
    }

    public LoginUser(String idLogin) {
        this.idLogin = idLogin;
    }
    
    public LoginUser(String idLogin, String username, String password) {
        this.idLogin = idLogin;
        this.username=username;
        this.password=password;
    }

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    
     public List<LoginUser> getUsers() {
        return users;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginUser)) {
            return false;
        }
        LoginUser other = (LoginUser) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puskesmas.server.model.LoginUser[ idLogin=" + idLogin + " ]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getAccNonExpired() {
        return accNonExpired;
    }

    public void setAccNonExpired(boolean accNonExpired) {
        this.accNonExpired = accNonExpired;
    }

    public boolean getCredNonExpired() {
        return credNonExpired;
    }

    public void setCredNonExpired(boolean credNonExpired) {
        this.credNonExpired = credNonExpired;
    }

    public boolean getAccNonLocked() {
        return accNonLocked;
    }

    public void setAccNonLocked(boolean accNonLocked) {
        this.accNonLocked = accNonLocked;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }
    
}
