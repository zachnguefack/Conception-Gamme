package org.sid.offregame.dto;

import lombok.Data;

@Data
public class TaskTimeParameterDTO {

    private Long id;
    private String taskId;
    private boolean status;
    private String name;
    private double nombreHeure;
    private double tempsMinParHeure;
    private double totalTimeEnMin;
    private double proportionTemps;

}
