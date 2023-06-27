package org.sid.offregame.dao;

import org.sid.offregame.entities.CategoryParametreDecolletage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryParametreDecolletageRepository  extends JpaRepository<CategoryParametreDecolletage,Long> {
    List<CategoryParametreDecolletage> findByComplexTaskId (String id);
}
