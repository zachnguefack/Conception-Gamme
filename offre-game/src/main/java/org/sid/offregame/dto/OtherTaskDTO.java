package org.sid.offregame.dto;


import lombok.Data;
import java.util.List;

@Data
public class OtherTaskDTO  extends TaskDTO{

    String id;
    private  String TaskName;
    private int numero;
    private boolean status;

    private boolean decolletage;

    private boolean edit;
    private double tempsDeReglageEnHeure;
    private  double tempsDeProduction;
    private double tempsPourPcsEnHeureParPiece;
    private double tempsInterOperatoireEnHeure;
    private double tauxHoraireReglage;
    private double tauxHoraireProduction;
    private double indirect;
    private double marge;
    private double calculPrEnCHF;
    private double tempsDePassageEnJour;
    private double calculPVenCHF;

    private double tempsCycleDeBaseSecond;
    private double tempsDeReglageHeur;
    private double tempsDeCycleCalculerSecond;
    private double proportionTotalTemps;
    private List<SubOtherTaskDTO> subOtherTaskDTOS;
    private List<TaskTimeParameterDTO> taskTimeParametersDTO;

    private List<TaskPrecisionParameterDTO> taskPrecisionParametersDTO;
}
