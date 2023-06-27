package org.sid.offregame.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class DefaultParameter2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rang;
    private String StatutConcept;
    private String typeUsinage;
    private String machine;
    private String matiere;
    private String avanceCoupe;
    private String engrenage;
    private double burinEbavurage;
    private double CategoriePiece;
}
