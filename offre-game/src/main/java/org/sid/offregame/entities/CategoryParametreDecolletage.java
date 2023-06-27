package org.sid.offregame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryParametreDecolletage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private ComplexTask complexTask;
    @OneToMany(mappedBy = "categoryParametreDecolletage",fetch = FetchType.EAGER)
    private List<ParametreDecolletage> parametreDecolletages;


}
