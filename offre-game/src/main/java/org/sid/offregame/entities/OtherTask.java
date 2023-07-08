package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("OTHER")
@Data @AllArgsConstructor @NoArgsConstructor
public class OtherTask extends Task implements Serializable {

    private double tempsCycleDeBaseSecond;
    private double tempsDeReglageHeur;
    private double nbrePosageParPiece;
    private double tempsDeCycleCalculerSecond;
    private double proportionTotalTemps;
    @OneToMany(mappedBy = "otherTask")
    private List<TaskTimeParameter> taskTimeParameters;
    @OneToMany(mappedBy = "otherTask")
    private List<TaskPrecisionParameter> taskPrecisionParameters;




}
