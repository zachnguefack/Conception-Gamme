package org.sid.offregame.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryParametreDecolletageDTO {

    private Long id;
    private String name;
    private List<ParametreDecolletageDTO> parametreDecolletagesDTO;
}
