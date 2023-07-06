package org.sid.offregame.dto;

import lombok.Data;


import java.util.List;

@Data
public class ComplexTaskDTO extends TaskDTO{

    private String id;
    private  String TaskName;
    private int numero;
    private boolean status;
    private boolean edit;
    private boolean decolletage;
    private boolean poolA;
    private boolean poolB;
    private boolean poolC;
    private boolean poolD;
    private boolean poolE;
    private boolean poolF;
    private boolean poolH;


    private  double tempsDeProduction;
    private double tempsDeReglageEnHeure;
    private double tempsPourPcsEnHeureParPiece;
    private double tempsInterOperatoireEnHeure;
    private double tauxHoraireReglage;
    private double tauxHoraireProduction;
    private double indirect;
    private double marge;
    private double calculPrEnCHF;
    private double tempsDePassageEnJour;
    private double calculPVenCHF;
    private double tempsDeCycleDeBase;
    private double moyenneProgrammationEnHeure;
    private String poolMachine;
    private double tpsEmbarreurCanon;
    private double tpsPreparationOutils;
    private double tpsMiseAuPoint;
    private double tpsTotalReglage;
    private double nbrePiecesParJour;
    private double tpsPosageOutils;
    private  double coutTotauxOutils;
    private List<SubOtherTaskDTO> subOtherTaskDTOS;
    private List<CategoryParametreDecolletageDTO> categoryParametreDecolletagesDTO;
}
