package com.seckin.bootexercises.repository;

import com.seckin.bootexercises.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
