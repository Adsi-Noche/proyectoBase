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
@Table(name = "TBL_Usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUSUPKUsuario", query = "SELECT u FROM Usuario u WHERE u.uSUPKUsuario = :uSUPKUsuario")
    , @NamedQuery(name = "Usuario.findByUSUTipoDocumento", query = "SELECT u FROM Usuario u WHERE u.uSUTipoDocumento = :uSUTipoDocumento")
    , @NamedQuery(name = "Usuario.findByUSUDocumento", query = "SELECT u FROM Usuario u WHERE u.uSUDocumento = :uSUDocumento")
    , @NamedQuery(name = "Usuario.findByUSUNombres", query = "SELECT u FROM Usuario u WHERE u.uSUNombres = :uSUNombres")
    , @NamedQuery(name = "Usuario.findByUSUApellidos", query = "SELECT u FROM Usuario u WHERE u.uSUApellidos = :uSUApellidos")
    , @NamedQuery(name = "Usuario.findByUSUCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.uSUCorreoElectronico = :uSUCorreoElectronico")
    , @NamedQuery(name = "Usuario.findByUSUClave", query = "SELECT u FROM Usuario u WHERE u.uSUClave = :uSUClave")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_PK_Usuario")
    private Integer uSUPKUsuario;
    @Column(name = "USU_Tipo_Documento")
    private Integer uSUTipoDocumento;
    @Size(max = 50)
    @Column(name = "USU_Documento")
    private String uSUDocumento;
    @Size(max = 50)
    @Column(name = "USU_Nombres")
    private String uSUNombres;
    @Size(max = 50)
    @Column(name = "USU_Apellidos")
    private String uSUApellidos;
    @Size(max = 50)
    @Column(name = "USU_Correo_Electronico")
    private String uSUCorreoElectronico;
    @Size(max = 50)
    @Column(name = "USU_Clave")
    private String uSUClave;
    @OneToMany(mappedBy = "uSUPKUsuario")
    private Collection<UsuarioRol> usuarioRolCollection;

    public Usuario() {
    }

    public Usuario(Integer uSUPKUsuario) {
        this.uSUPKUsuario = uSUPKUsuario;
    }

    public Integer getUSUPKUsuario() {
        return uSUPKUsuario;
    }

    public void setUSUPKUsuario(Integer uSUPKUsuario) {
        this.uSUPKUsuario = uSUPKUsuario;
    }

    public Integer getUSUTipoDocumento() {
        return uSUTipoDocumento;
    }

    public void setUSUTipoDocumento(Integer uSUTipoDocumento) {
        this.uSUTipoDocumento = uSUTipoDocumento;
    }

    public String getUSUDocumento() {
        return uSUDocumento;
    }

    public void setUSUDocumento(String uSUDocumento) {
        this.uSUDocumento = uSUDocumento;
    }

    public String getUSUNombres() {
        return uSUNombres;
    }

    public void setUSUNombres(String uSUNombres) {
        this.uSUNombres = uSUNombres;
    }

    public String getUSUApellidos() {
        return uSUApellidos;
    }

    public void setUSUApellidos(String uSUApellidos) {
        this.uSUApellidos = uSUApellidos;
    }

    public String getUSUCorreoElectronico() {
        return uSUCorreoElectronico;
    }

    public void setUSUCorreoElectronico(String uSUCorreoElectronico) {
        this.uSUCorreoElectronico = uSUCorreoElectronico;
    }

    public String getUSUClave() {
        return uSUClave;
    }

    public void setUSUClave(String uSUClave) {
        this.uSUClave = uSUClave;
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
        hash += (uSUPKUsuario != null ? uSUPKUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.uSUPKUsuario == null && other.uSUPKUsuario != null) || (this.uSUPKUsuario != null && !this.uSUPKUsuario.equals(other.uSUPKUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobase.entidades.Usuario[ uSUPKUsuario=" + uSUPKUsuario + " ]";
    }
    
}
