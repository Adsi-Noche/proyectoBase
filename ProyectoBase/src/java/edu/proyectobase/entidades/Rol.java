/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobase.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "TBL_Rol")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByROLPKRol", query = "SELECT r FROM Rol r WHERE r.rOLPKRol = :rOLPKRol")
    , @NamedQuery(name = "Rol.findByROLNombre", query = "SELECT r FROM Rol r WHERE r.rOLNombre = :rOLNombre")
    , @NamedQuery(name = "Rol.findByROLDescripcion", query = "SELECT r FROM Rol r WHERE r.rOLDescripcion = :rOLDescripcion")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_PK_Rol")
    private Integer rOLPKRol;
    @Size(max = 50)
    @Column(name = "ROL_Nombre")
    private String rOLNombre;
    @Size(max = 50)
    @Column(name = "ROLDescripcion")
    private String rOLDescripcion;
    @OneToMany(mappedBy = "rOLPKRol")
    private Collection<UsuarioRol> usuarioRolCollection;

    public Rol() {
    }

    public Rol(Integer rOLPKRol) {
        this.rOLPKRol = rOLPKRol;
    }

    public Integer getROLPKRol() {
        return rOLPKRol;
    }

    public void setROLPKRol(Integer rOLPKRol) {
        this.rOLPKRol = rOLPKRol;
    }

    public String getROLNombre() {
        return rOLNombre;
    }

    public void setROLNombre(String rOLNombre) {
        this.rOLNombre = rOLNombre;
    }

    public String getROLDescripcion() {
        return rOLDescripcion;
    }

    public void setROLDescripcion(String rOLDescripcion) {
        this.rOLDescripcion = rOLDescripcion;
    }

    public Collection<UsuarioRol> getUsuarioRolCollection() {
        return usuarioRolCollection;
    }

    public void setUsuarioRolCollection(Collection<UsuarioRol> usuarioRolCollection) {
        this.usuarioRolCollection = usuarioRolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rOLPKRol != null ? rOLPKRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rOLPKRol == null && other.rOLPKRol != null) || (this.rOLPKRol != null && !this.rOLPKRol.equals(other.rOLPKRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobase.entidades.Rol[ rOLPKRol=" + rOLPKRol + " ]";
    }
    
}
