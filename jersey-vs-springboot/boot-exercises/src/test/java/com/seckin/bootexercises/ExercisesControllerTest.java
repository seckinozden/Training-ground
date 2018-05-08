package com.seckin.bootexercises;

import com.seckin.bootexercises.controller.ExerciseController;
import com.seckin.bootexercises.model.Exercise;
import com.seckin.bootexercises.repository.ExerciseRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ExercisesControllerTest {

    @InjectMocks
    ExerciseController exerciseController;

    @Mock
    ExerciseRepository exerciseRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getAllExercises() {
        Exercise exercise = new Exercise((long) 1, "Football", "1 ball 22 men");
        List<Exercise> exercises = new ArrayList(Arrays.asList(exercise));

        Mockito.when(exerciseRepository.findAll()).thenReturn(exercises);

        ResponseEntity<?> responseEntity = exerciseController.getAllExercises();

        Mockito.verify(exerciseRepository).findAll();
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertNotNull(responseEntity.getBody());
    }

    @Test
    public void test_getExercise() {
        Exercise exercise = new Exercise((long) 1, "Football", "1 ball 22 men");
        Optional<Exercise> optionalMock = Mockito.mock(Optional.class);

        Mockito.when(optionalMock.get()).thenReturn(exercise);
        Mockito.when(optionalMock.isPresent()).thenReturn(true);
        Mockito.when(exerciseRepository.findById((long) 1)).thenReturn(optionalMock);

        ResponseEntity<?> responseEntity = exerciseController.getExercise((long) 1);

        Mockito.verify(exerciseRepository).findById((long) 1);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertNotNull(responseEntity.getBody());
    }

    @Test
    public void test_createExercise(){
        //TODO: learn how to mock currentRequest
    }

    @Test
    public void test_updateExercise(){
        Exercise existingExercise = new Exercise((long) 1, "Football", "1 ball 22 men");
        Exercise updatedExercise = new Exercise((long) 1, "Football", "A game of death of life");
        Optional<Exercise> exerciseMock = Mockito.mock(Optional.class);

        Mockito.when(exerciseMock.isPresent()).thenReturn(true);
        Mockito.when(exerciseMock.get()).thenReturn(existingExercise);
        Mockito.when(exerciseRepository.findById((long)1)).thenReturn(exerciseMock);
        Mockito.when(exerciseRepository.saveAndFlush(Mockito.any(Exercise.class))).thenReturn(updatedExercise);

        ResponseEntity<?> responseEntity = exerciseController.updateExercise((long)1, updatedExercise);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertNotNull(responseEntity.getBody());
        Exercise result = (Exercise) responseEntity.getBody();
        Assert.assertEquals((long)1,(long)result.getId());
        Assert.assertEquals(updatedExercise.getDescription(), result.getDescription());
        Assert.assertEquals(updatedExercise.getName(), result.getName());
    }

    @Test
    public void test_deleteExercise(){
        Exercise existingExercise = new Exercise((long) 1, "Football", "1 ball 22 men");
        Optional<Exercise> exerciseMock = Mockito.mock(Optional.class);

        Mockito.when(exerciseMock.isPresent()).thenReturn(true);
        Mockito.when(exerciseMock.get()).thenReturn(existingExercise);
        Mockito.when(exerciseRepository.findById((long)1)).thenReturn(exerciseMock);
        Mockito.doNothing().when(exerciseRepository).delete(Mockito.any(Exercise.class));

        ResponseEntity<?> responseEntity = exerciseController.deleteExercise((long)1);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
