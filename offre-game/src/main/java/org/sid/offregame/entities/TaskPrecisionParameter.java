package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class TaskPrecisionParameter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;
    private double tempsOuvertureMin;
    private double nombrePieceParHeure;
    private double nombrePieceParHeureApresDeduction;
    private double tempsDeCycleGammeEnSeconde;
    private double pourMilParPcsEnHeure;
    private double TauxDeRendment;
    private double efficiencePoste;
    private double calculInversePiecesParJour;
    private double PiecesParJour;
    @ManyToOne
    private OtherTask otherTask;

}
