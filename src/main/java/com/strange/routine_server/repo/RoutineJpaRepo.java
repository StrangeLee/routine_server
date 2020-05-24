package com.strange.routine_server.repo;


import com.strange.routine_server.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineJpaRepo extends JpaRepository<Routine, Long> {
}
