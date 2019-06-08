/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobase.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "TBL_Usuario_Rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USR_PK_Usuario_Rol")
    private Integer uSRPKUsuarioRol;
    @JoinColumn(name = "ROL_PK_Rol", referencedColumnName = "ROL_PK_Rol")
    @ManyToOne
    private Rol rOLPKRol;
    @JoinColumn(name = "USU_PK_Usuario", referencedColumnName = "USU_PK_Usuario")
    @ManyToOne
    private Usuario uSUPKUsuario;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer uSRPKUsuarioRol) {
        this.uSRPKUsuarioRol = uSRPKUsuarioRol;
    }

    public Integer getUSRPKUsuarioRol() {
        return uSRPKUsuarioRol;
    }

    public void setUSRPKUsuarioRol(Integer uSRPKUsuarioRol) {
        this.uSRPKUsuarioRol = uSRPKUsuarioRol;
    }

    public Rol getROLPKRol() {
        return rOLPKRol;
    }

    public void setROLPKRol(Rol rOLPKRol) {
        this.rOLPKRol = rOLPKRol;
    }

    public Usuario getUSUPKUsuario() {
        return uSUPKUsuario;
    }

    public void setUSUPKUsuario(Usuario uSUPKUsuario) {
        this.uSUPKUsuario = uSUPKUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uSRPKUsuarioRol != null ? uSRPKUsuarioRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.uSRPKUsuarioRol == null && other.uSRPKUsuarioRol != null) || (this.uSRPKUsuarioRol != null && !this.uSRPKUsuarioRol.equals(other.uSRPKUsuarioRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobase.entidades.UsuarioRol[ uSRPKUsuarioRol=" + uSRPKUsuarioRol + " ]";
    }
    
}
