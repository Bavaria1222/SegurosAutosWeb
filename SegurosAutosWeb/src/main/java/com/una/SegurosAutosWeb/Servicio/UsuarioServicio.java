package com.una.SegurosAutosWeb.Servicio;

import com.una.SegurosAutosWeb.Modelos.Usuario;
import com.una.SegurosAutosWeb.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio repoUser;
    //Metodos

    public List<Usuario> findAllUser(){
        return (List<Usuario>) repoUser.findAll();
    }

    public Usuario findUserById(Long id){
        Optional<Usuario> result= repoUser.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Usuario(); //Si no lo encuentra retorna un usuario vacio
    }

    public Usuario addUser(Usuario user){
        return repoUser.save(user);
    }

    public Usuario updateUser(Usuario user){
        /*En este metodo solo se puede cambiar Contrasena / telefono /  direccion */
        Optional<Usuario> result=  repoUser.findById(user.getId());//
        Usuario existente = result.get();
        existente.setEmail(user.getEmail());
        existente.setPassword(user.getPassword());
        existente.setTelefono(user.getTelefono());
        return repoUser.save(existente);

    }

    public void deleteById(Long id){
        repoUser.deleteById(id);
    }


}

