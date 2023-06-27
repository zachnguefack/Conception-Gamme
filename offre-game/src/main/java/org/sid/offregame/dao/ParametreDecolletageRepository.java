package org.sid.offregame.dao;

import org.sid.offregame.entities.CategoryParametreDecolletage;
import org.sid.offregame.entities.ParametreDecolletage;
import org.sid.offregame.entities.TaskPrecisionParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParametreDecolletageRepository extends JpaRepository<ParametreDecolletage,Long> {

    List<ParametreDecolletage> findByCategoryParametreDecolletageId (Long id);
}
