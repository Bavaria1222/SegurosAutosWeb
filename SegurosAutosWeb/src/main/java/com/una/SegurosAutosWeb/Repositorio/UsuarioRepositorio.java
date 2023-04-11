package com.una.SegurosAutosWeb.Repositorio;

import com.una.SegurosAutosWeb.Modelos.Usuario;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
}
