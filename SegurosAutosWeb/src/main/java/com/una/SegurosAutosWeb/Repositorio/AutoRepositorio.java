package com.una.SegurosAutosWeb.Repositorio;

import com.una.SegurosAutosWeb.Modelos.Auto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AutoRepositorio extends CrudRepository<Auto, String> {
}
