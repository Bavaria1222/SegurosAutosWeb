package com.una.SegurosAutosWeb.Modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity  //Anotacion para identificar que es una entidad
@Data   //Anotacion Deloomback. Generara a la hora de copilar los getters/setters/toString/equals etc....
@Table  //Javapersiste
@AllArgsConstructor // Generacion del constructor con argumentos
@NoArgsConstructor // Generador del constructor sin argumentos
public class Pago {
    @Id   //Asignacion de PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Al momento de generar un registro en el usuario incremente la PK
    private Long id;
    @Column(nullable = false) //La propiedad del atributo "nombre" no puede ser Null
    private Double monto;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String plazo;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String medioPago;

}
