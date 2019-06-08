/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobase.facade;

import com.sun.mail.util.QDecoderStream;
import edu.proyectobase.entidades.UsuarioRol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
public class UsuarioRolFacade extends AbstractFacade<UsuarioRol> implements UsuarioRolFacadeLocal {

    @PersistenceContext(unitName = "ProyectoBasePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRolFacade() {
        super(UsuarioRol.class);
    }

    @Override
    public boolean removerPermisos(int idUsuario) {

        try {

            Query removerUSu = em.createNativeQuery("DELETE from TBL_Usuario_Rol where USU_PK_Usuario = ?");
            removerUSu.setParameter(1, idUsuario);
            removerUSu.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }
}
