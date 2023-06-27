package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 20)
public abstract class Task {
    @Id
    private String id;
    private  String TaskName;
    private int numero;
    private boolean status;
    private boolean edit;

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

    @ManyToOne
    private Piece piece;
    @ManyToOne
    private TaskCategory taskCategory;
    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private List<SubOtherTask> subOtherTasks;

}
