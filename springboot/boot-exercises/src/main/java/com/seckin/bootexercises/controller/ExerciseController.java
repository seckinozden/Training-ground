package com.seckin.bootexercises.controller;

import com.seckin.bootexercises.model.Exercise;
import com.seckin.bootexercises.repository.ExerciseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @RequestMapping(value = "exercises", method = RequestMethod.GET)
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseRepository.findAll());
    }

    @RequestMapping(value = "exercises/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getExercise(@PathVariable Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isPresent())
            return ResponseEntity.ok(exercise.get());

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "exercises/new", method = RequestMethod.POST)
    public ResponseEntity<?> createExercise(@RequestBody Exercise exercise) {

        Exercise result = exerciseRepository.saveAndFlush(exercise);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + result.getId()).buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "exercises/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        Optional<Exercise> searchResult = exerciseRepository.findById(id);
        if (searchResult.isPresent()) {
            Exercise existingExercise = searchResult.get();
            BeanUtils.copyProperties(exercise, existingExercise);
            return ResponseEntity.ok(exerciseRepository.saveAndFlush(existingExercise));
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "exercises/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteExercise(@PathVariable Long id) {

        Optional<Exercise> searchResult = exerciseRepository.findById(id);
        if (searchResult.isPresent()) {
            exerciseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}