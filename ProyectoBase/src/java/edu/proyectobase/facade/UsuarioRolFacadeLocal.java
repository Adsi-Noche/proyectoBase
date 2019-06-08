/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobase.facade;

import edu.proyectobase.entidades.UsuarioRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daniel
 */
@Local
public interface UsuarioRolFacadeLocal {

    void create(UsuarioRol usuarioRol);

    void edit(UsuarioRol usuarioRol);

    void remove(UsuarioRol usuarioRol);

    UsuarioRol find(Object id);

    List<UsuarioRol> findAll();

    List<UsuarioRol> findRange(int[] range);

    int count();

    public boolean removerPermisos(int idUsuario);
    
}
