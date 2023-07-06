package org.sid.offregame.dao;

import org.sid.offregame.entities.Task;
import org.sid.offregame.entities.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,String> {
    List<Task> findByStatusTrue();
    Task findFirstByOrderByNumeroDesc();
    List<Task> findByStatusTrueOrderByNumeroAsc();
    List<Task> findByTaskCategory(TaskCategory taskCategory);
    @Modifying
    @Query("update Task t set t.status = :status where t.id = :id")
    void updateTaskStatus(@Param("id") String id, @Param("status") boolean status);
    @Query("select t from Task t where t.numero >= (select MAX(t2.numero) from Task t2)")
    //@Query("SELECT t FROM Task t WHERE t.numero = (SELECT MAX(t2.numero) FROM Task t2)")
    Task findTaskWithHighestNumber();
    @Modifying
    @Query("update Task t set t.numero = t.numero - 10 where t.numero > :numero and t.status = true")
    void decrementTaskNumbers(@Param("numero") int numero);
    @Modifying
    @Query("update Task t set t.numero = :nouveauNumero where t.id = :id")
    void updateTaskNumber(@Param("id") String id, @Param("nouveauNumero") Integer nouveauNumero);
    @Modifying
    @Query("update Task t set t.status = false, t.numero = 0, t.edit = false")
    void updateTasksStatusAndNumber();
}
