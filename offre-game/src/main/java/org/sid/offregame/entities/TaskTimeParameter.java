package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public  class TaskTimeParameter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;
    private String name;
    private double nombreHeure;
    private double tempsMinParHeure;
    private double totalTimeEnMin;
    private double proportionTemps;
    @ManyToOne
    private OtherTask otherTask;


}
