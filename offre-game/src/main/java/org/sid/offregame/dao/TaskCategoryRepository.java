package org.sid.offregame.dao;

import org.sid.offregame.entities.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory,Long> {
    TaskCategory findByCategoryName(String name);
}
