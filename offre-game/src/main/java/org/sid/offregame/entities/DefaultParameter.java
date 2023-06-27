package org.sid.offregame.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class DefaultParameter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rang;
    private String OutilDecolletage;
    private double tempsDeMontage;
    private double coutMoyenOutil;
    private String atelier;
    private String operation;
    private double tempsDeCycle;
    private boolean box1;
    private boolean box2;
    private boolean box3;
    private boolean box4;
    private boolean box5;
    private double valeur1;
    private double valeur2;
    private double valeur3;
    private double valeur4;
    private double valeur5;
    private double tauxHoraireReglage;
    private double tauxHoraireProduction;
    private double indirectPur;
    private double marge;


}
