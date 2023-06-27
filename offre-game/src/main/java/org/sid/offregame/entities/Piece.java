package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Piece {
    @Id
    private String id;
    private  String pieceName;
    private String planName;
    private String image;
    @OneToMany(mappedBy = "piece")
    private List<Task> tasks;
    @OneToOne
    private Client client;
    @OneToOne(mappedBy = "piece")
    private Synthesis synthesis;


}
