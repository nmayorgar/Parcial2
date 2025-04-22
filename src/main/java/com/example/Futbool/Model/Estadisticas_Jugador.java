package com.example.Futbool.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Estadisticas_Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_estadistica_Jugador;

    private int id_jugador;
    private int id_partido;
    private int minutos_juador;
    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;


}
