package com.gamu.Viagem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "voo")
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "destino")
    private String destino;

    @Column (name = "localIda")
    private String localIda;

    @Column( name = "diaIda")
    private String diaIda;

    @Column( name = "horaIda")
    private String horaIda;

    @Column( name = "localVolta")
    private String localVolta;


    @Column (name = "diaVolta")
    private String diaVolta;

    @Column (name = "horaVolta")
    private String horaVolta;

}
