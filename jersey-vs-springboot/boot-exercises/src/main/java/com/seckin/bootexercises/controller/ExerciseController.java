package com.seckin.bootexercises.controller;

import com.seckin.bootexercises.model.Exercise;
import com.seckin.bootexercises.repository.ExerciseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @RequestMapping(value = "exercises", method = RequestMethod.GET)
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @RequestMapping(value = "exercises/{id}", method = RequestMethod.GET)
    public Exercise getExercise(@PathVariable Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isPresent())
            return exercise.get();

        return null;
    }

    @RequestMapping(value = "exercises/new/{id}", method = RequestMethod.POST)
    public Exercise createExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        exercise.setId(id);
        return exerciseRepository.saveAndFlush(exercise);
    }

    @RequestMapping(value = "exercises/update/{id}", method = RequestMethod.PUT)
    public Exercise updateExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        Optional<Exercise> searchResult = exerciseRepository.findById(id);
        if (searchResult.isPresent()) {
            Exercise existingExercise = searchResult.get();
            BeanUtils.copyProperties(exercise, existingExercise);
            return exerciseRepository.saveAndFlush(existingExercise);
        }

        return null;
    }

    @RequestMapping(value = "exercises/delete/{id}", method = RequestMethod.DELETE)
    public String deleteExercise(@PathVariable Long id) {

        Optional<Exercise> searchResult = exerciseRepository.findById(id);
        if (searchResult.isPresent()) {
            exerciseRepository.deleteById(id);
            return "Exercise deleted. ID=" + id;
        }
        return "Exercise with given ID not found! ID=" + id;
    }
}