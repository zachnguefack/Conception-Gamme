package org.sid.offregame.dao;

import org.sid.offregame.entities.OtherTask;
import org.sid.offregame.entities.TaskTimeParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskTimeParameterRepository extends JpaRepository<TaskTimeParameter,Long> {

    List<TaskTimeParameter> findByOtherTaskId (String id);
}
