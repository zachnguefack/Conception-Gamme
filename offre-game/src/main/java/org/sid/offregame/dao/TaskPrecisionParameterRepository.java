package org.sid.offregame.dao;

import org.sid.offregame.entities.OtherTask;
import org.sid.offregame.entities.TaskPrecisionParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskPrecisionParameterRepository extends JpaRepository<TaskPrecisionParameter,Long> {
    List<TaskPrecisionParameter> findByOtherTaskId (String id);

}
