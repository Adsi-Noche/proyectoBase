/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobase.facade;

import edu.proyectobase.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProyectoBasePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public boolean ingresarUsuario(Usuario usuarioIn) {

        try {
            Query cUsuario = em.createNativeQuery("insert into TBL_Usuario (USU_Tipo_Documento, USU_Documento, USU_Nombres, USU_Apellidos, USU_Correo_Electronico, USU_Clave, USU_Estado ) values (?,?, ?, ?,?, ?, ?)");

            cUsuario.setParameter(1, usuarioIn.getUSUTipoDocumento().getTdoctipoDocumentoId());
            cUsuario.setParameter(2, usuarioIn.getUSUDocumento());
            cUsuario.setParameter(3, usuarioIn.getUSUNombres());
            cUsuario.setParameter(4, usuarioIn.getUSUApellidos());
            cUsuario.setParameter(5, usuarioIn.getUSUCorreoElectronico());
            cUsuario.setParameter(6, usuarioIn.getUSUClave());
            cUsuario.setParameter(7, "Activo");

            cUsuario.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int consultaId(String numeroDoc) {
        try {
            Query cUsuario = em.createNativeQuery("select USU_PK_Usuario from TBL_Usuario where USU_Documento  = ?");
            cUsuario.setParameter(1, numeroDoc);
            int posicion = (int) cUsuario.getSingleResult();
            return posicion;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean asignarRol(int usuarioId, int rolId) {
        try {
            Query cUsuario = em.createNativeQuery("insert into TBL_Usuario_Rol (USU_PK_Usuario, ROL_PK_Rol)  values (?, ?)");
            cUsuario.setParameter(1, usuarioId);
            cUsuario.setParameter(2, rolId);
            cUsuario.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuario iniciarSesion(String clave, String email) {

        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query inicioUsu = em.createQuery("SELECT f FROM Usuario f WHERE f.uSUClave = :uSuclave AND f.uSUCorreoElectronico = :uSUCorreoElectronico AND f.uSUEstado= 'Activo'");
            inicioUsu.setParameter("uSuclave", clave);
            inicioUsu.setParameter("uSUCorreoElectronico", email);
            List<Usuario> listaResultados = inicioUsu.getResultList();
            if (listaResultados.isEmpty()) {
                return null;
            } else {
                return listaResultados.get(0);
            }

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public boolean removerUsuario(int idUsuario) {

        try {

            Query removerUSu = em.createNativeQuery("DELETE from TBL_Usuario where USU_PK_Usuario = ?");
            removerUSu.setParameter(1, idUsuario);
            removerUSu.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean cambiarEstadoUsu(int idUsuario, String estado) {

        try {

            Query removerUSu = em.createNativeQuery("UPDATE TBL_Usuario SET USU_Estado = ? where USU_PK_Usuario = ?");
            removerUSu.setParameter(1, idUsuario);
            removerUSu.setParameter(2, estado);
            removerUSu.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Usuario> filtrarUsuarios(String documento, String nombre ) {
        try {
              em.getEntityManagerFactory().getCache().evictAll();
            String consultar = "";
            if (documento.trim().equals("") && nombre.trim().equals("")) {
                consultar = "select * from TBL_Usuario";
            } else {
                consultar = "select * from TBL_Usuario where USU_Documento like '" + documento + "%' and USU_Nombres like '"+nombre+"%' order by USU_Documento desc";
            }
            Query filtrarU = em.createNativeQuery(consultar, Usuario.class);
            List<Usuario> listu = filtrarU.getResultList();
            return listu;
        } catch (Exception e) {
            return null;
        }
    }

}
