package org.sid.offregame.dao;

import org.sid.offregame.entities.SubOtherTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubOtherTaskRepository extends JpaRepository<SubOtherTask,Long> {
    List<SubOtherTask> findByTaskId(String taskId);
}
