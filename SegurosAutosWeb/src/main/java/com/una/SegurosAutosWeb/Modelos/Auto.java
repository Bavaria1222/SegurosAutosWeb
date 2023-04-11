package com.una.SegurosAutosWeb.Modelos;/*Modelando  Entidad Usuario*/

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity  //Anotacion para identificar que es una entidad
@Data   //Anotacion Deloomback. Generara a la hora de copilar los getters/setters/toString/equals etc....
@Table  //Javapersiste
@AllArgsConstructor // Generacion del constructor con argumentos
@NoArgsConstructor // Generador del constructor sin argumentos

public class Auto {
    @Id   //Asignacion de PK
    @Column(nullable = false, unique=true)// Al momento de generar un registro en el usuario incremente la PK
    private String placa;
    @Column(nullable = false) //La propiedad del atributo "nombre" no puede ser Null
    private String marca;
    @Column(nullable = false) //La propiedad del atributo "apellido" no puede ser Null
    private String modelo;
    @Column(nullable = false)
    private  int anio;


}
