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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "TBL_Tipo_Documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tdoc_tipoDocumentoId")
    private Integer tdoctipoDocumentoId;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "uSUTipoDocumento")
    private Collection<Usuario> usuarioCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer tdoctipoDocumentoId) {
        this.tdoctipoDocumentoId = tdoctipoDocumentoId;
    }

    public Integer getTdoctipoDocumentoId() {
        return tdoctipoDocumentoId;
    }

    public void setTdoctipoDocumentoId(Integer tdoctipoDocumentoId) {
        this.tdoctipoDocumentoId = tdoctipoDocumentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdoctipoDocumentoId != null ? tdoctipoDocumentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tdoctipoDocumentoId == null && other.tdoctipoDocumentoId != null) || (this.tdoctipoDocumentoId != null && !this.tdoctipoDocumentoId.equals(other.tdoctipoDocumentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobase.entidades.TipoDocumento[ tdoctipoDocumentoId=" + tdoctipoDocumentoId + " ]";
    }
    
}
