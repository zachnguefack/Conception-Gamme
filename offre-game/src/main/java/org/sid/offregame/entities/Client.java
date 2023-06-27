package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id
    private String id;
    private  String name;
    private  String email;
    @OneToOne(mappedBy = "client")
    private Piece piece;
}
