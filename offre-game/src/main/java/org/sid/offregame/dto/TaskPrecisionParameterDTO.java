package org.sid.offregame.dto;


import lombok.Data;

@Data
public class TaskPrecisionParameterDTO {

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
}
