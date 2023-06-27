package org.sid.offregame.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@DiscriminatorValue("DECOL")
@Data @AllArgsConstructor @NoArgsConstructor
public class ComplexTask extends Task {
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
    @OneToMany(mappedBy = "complexTask",fetch = FetchType.EAGER)
    private List<CategoryParametreDecolletage> categoryParametreDecolletages;
}
