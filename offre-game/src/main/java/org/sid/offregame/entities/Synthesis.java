package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Synthesis {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int CategoriePiece;
    private double quantitePieceClient;
    private double lotDeFabrication;
    private double lotFinance;
    private double tempsDePassage;
    private double prixDeRevient;
    @OneToOne
    private Piece piece;


}
