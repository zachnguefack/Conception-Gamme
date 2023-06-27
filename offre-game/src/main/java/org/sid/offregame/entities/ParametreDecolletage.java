package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametreDecolletage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean status;
    private double tempsDeMontage;
    private double coutMoyenOutils;
    @ManyToOne
    private CategoryParametreDecolletage categoryParametreDecolletage;
}
