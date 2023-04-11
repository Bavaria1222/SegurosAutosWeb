package com.una.SegurosAutosWeb.Servicio;

import com.una.SegurosAutosWeb.Modelos.Auto;
import com.una.SegurosAutosWeb.Repositorio.AutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoServicio {
    @Autowired
    AutoRepositorio repoAuto;
    //Metodos

    public List<Auto> findAllAuto(){
        return (List<Auto>) repoAuto.findAll();
    }

    public Auto findAutoByPlaca(String placa){
        Optional<Auto> result= repoAuto.findById(placa);
        if(result.isPresent()){
            return result.get();
        }
        return new Auto(); //Si no lo encuentra retorna un auto vacio
    }

    public Auto addAuto(Auto auto){
        return repoAuto.save(auto);
    }

    public Auto updateAuto(Auto auto){
        /*En este metodo solo se puede cambiar Marca / Modelo / Año*/
        Optional<Auto> result=  repoAuto.findById(auto.getPlaca());//
        Auto existente = result.get();
        existente.setMarca(auto.getMarca());
        existente.setModelo(auto.getModelo());
        existente.setAnio(auto.getAnio());
        return repoAuto.save(existente);

    }

    public void deleteByPlaca(String placa){
        repoAuto.deleteById(placa);
    }
}
