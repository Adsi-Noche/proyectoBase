/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobase.facade;

import edu.proyectobase.entidades.Usuario;
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
    public  boolean ingresarNuevoUsuario(Usuario usuIn){
        try {
            Query q = em.createNativeQuery("INSERT INTO  TBL_Usuario(USU_Tipo_Documento, USU_Documento, USU_Nombres, USU_Apellidos, USU_Correo_Electronico, USU_Clave) VALUES (?,?,?,?,?,?)");
            q.setParameter(1, usuIn.getUSUTipoDocumento());
            q.setParameter(2, usuIn.getUSUDocumento());
            q.setParameter(3, usuIn.getUSUNombres());
            q.setParameter(4, usuIn.getUSUApellidos());
            q.setParameter(5, usuIn.getUSUCorreoElectronico());
            q.setParameter(6, usuIn.getUSUClave());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return  false;
        }
 
   }
    
}
