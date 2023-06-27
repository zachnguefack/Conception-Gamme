package org.sid.offregame.mappers;

import org.sid.offregame.dto.*;
import org.sid.offregame.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OffreGammeMapperImpl {

    public TaskTimeParameterDTO toTaskTimeParameterDTO (TaskTimeParameter taskTimeParameter){

        TaskTimeParameterDTO taskTimeParameterDTO = new TaskTimeParameterDTO();
        BeanUtils.copyProperties(taskTimeParameter, taskTimeParameterDTO);
        return taskTimeParameterDTO;
    }

    public TaskPrecisionParameterDTO toTaskPrecisionParameterDTO(TaskPrecisionParameter taskPrecisionParameter){
        TaskPrecisionParameterDTO taskPrecisionParameterDTO = new TaskPrecisionParameterDTO();
        BeanUtils.copyProperties(taskPrecisionParameter, taskPrecisionParameterDTO);
        return taskPrecisionParameterDTO;
    }

    public SubOtherTaskDTO toSubOtherTaskDTO (SubOtherTask subOtherTask){

        SubOtherTaskDTO subOtherTaskDTO = new SubOtherTaskDTO();
        BeanUtils.copyProperties(subOtherTask, subOtherTaskDTO);

        return subOtherTaskDTO;
    }

    public OtherTaskDTO toOtherTaskDTO(OtherTask otherTask){
        OtherTaskDTO otherTaskDTO = new OtherTaskDTO();
        BeanUtils.copyProperties(otherTask, otherTaskDTO);
        return otherTaskDTO;
    }

    public ComplexTaskDTO toComplexTaskDTO(ComplexTask complexTask){
        ComplexTaskDTO complexTaskDTO = new ComplexTaskDTO();
        BeanUtils.copyProperties(complexTask, complexTaskDTO);

        return complexTaskDTO;
    }

    public CategoryParametreDecolletageDTO toCategoryParametreDecolletageDTO(CategoryParametreDecolletage categoryParametreDecolletage){
        CategoryParametreDecolletageDTO categoryParametreDecolletageDTO = new CategoryParametreDecolletageDTO();
        BeanUtils.copyProperties(categoryParametreDecolletage, categoryParametreDecolletageDTO);

        return categoryParametreDecolletageDTO;
    }

    public ParametreDecolletageDTO toParametreDecolletageDTO(ParametreDecolletage parametreDecolletage){
        ParametreDecolletageDTO parametreDecolletageDTO = new ParametreDecolletageDTO();
        BeanUtils.copyProperties(parametreDecolletage, parametreDecolletageDTO);

        return parametreDecolletageDTO;

    }

}
