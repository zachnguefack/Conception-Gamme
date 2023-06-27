package org.sid.offregame.dto;

import lombok.Data;

@Data
public class SubOtherTaskDTO {

    private boolean status;
    private int numeroSequence;
    private  String name;
    private double tempsInterOperatoireEnHeure;
    private double tauxHoraireReglage;
    private double tauxHoraireProduction;
    private double indirect;
    private double marge;
    private double calculPrEnCHF;
    private double tempsDePassageEnJour;
    private double calculPVenCHF;
    private double tempsDeReglage;
    private  double tempsDeProduction;

}
