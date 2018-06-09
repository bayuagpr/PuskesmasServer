/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;


/**
 *
 * @author ASUS
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(Include.NON_NULL)
public abstract class AuditModel implements Serializable {
    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_insert", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_update")
    @LastModifiedDate
    private Date updatedAt;
    
    @Size(min = 1, max = 20)
    @Column(name = "pembuat", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;
    
    @Size(min = 1, max = 20)
    @Column(name = "pengubah")
    @LastModifiedBy  
    private String updatedBy;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
