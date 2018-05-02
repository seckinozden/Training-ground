package com.seckin.bootexercises.controller;

import com.seckin.bootexercises.model.Exercise;
import com.seckin.bootexercises.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Exercise getExercise(@PathVariable Long id) {
        return exerciseRepository.getOne(id);
    }

    @RequestMapping(value = "/new/{id}", method = RequestMethod.POST)
    public Exercise createExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        exercise.setId(id);
        return exerciseRepository.saveAndFlush(exercise);
    }

}