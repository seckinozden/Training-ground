package com.seckin.bootexercises;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.seckin.bootexercises.model.Exercise;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ExerciseControllerWebIntegrationTest {

    @Test
    public void test_getAllExercises() {
        RestTemplate template = new RestTemplate();

        ParameterizedTypeReference<List<Exercise>> typeRef = new ParameterizedTypeReference<List<Exercise>>() {
        };
        ResponseEntity<List<Exercise>> response = template.exchange("http://localhost:8080/api/v1/exercises", HttpMethod.GET, null, typeRef);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void test_getExerciseById() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Exercise> response = template.getForEntity("http://localhost:8080/api/v1/exercises/1", Exercise.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals((long) 1, (long) response.getBody().getId());
    }

    @Test
    public void test_createExercise() {
        RestTemplate template = new RestTemplate();
        Exercise exercise = new Exercise((long) 99, "Curling", "Indian stuff");
        ResponseEntity<Exercise> response = template.postForEntity("http://localhost:8080/api/v1/exercises/new", exercise, Exercise.class);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        ResponseEntity<Exercise> controlResponse = template.getForEntity("http://localhost:8080/api/v1/exercises/" + exercise.getId(), Exercise.class);
        Assert.assertEquals(HttpStatus.OK, controlResponse.getStatusCode());
        Assert.assertNotNull(controlResponse.getBody());
        Assert.assertEquals(exercise.getId(), controlResponse.getBody().getId());
        Assert.assertEquals(exercise.getName(), controlResponse.getBody().getName());
        Assert.assertEquals(exercise.getDescription(), controlResponse.getBody().getDescription());
    }

    @Test
    public void test_updateExercise() {
        RestTemplate template = new RestTemplate();
        Long exerciseId = (long) 99;
        ResponseEntity<Exercise> existingResponse = template.getForEntity("http://localhost:8080/api/v1/exercises/" + exerciseId, Exercise.class);

        Assert.assertEquals(HttpStatus.OK, existingResponse.getStatusCode());
        Assert.assertNotNull(existingResponse.getBody());

        Exercise updatedExercise = new Exercise(exerciseId, "Curling", "Indian's national sport.");
        template.put("http://localhost:8080/api/v1/exercises/update/" + exerciseId, updatedExercise);

        ResponseEntity<Exercise> updateResponse = template.getForEntity("http://localhost:8080/api/v1/exercises/" + exerciseId, Exercise.class);

        Assert.assertEquals(HttpStatus.OK, updateResponse.getStatusCode());
        Assert.assertNotNull(updateResponse.getBody());
        Assert.assertEquals(updatedExercise.getId(), updateResponse.getBody().getId());
        Assert.assertEquals(updatedExercise.getDescription(), updateResponse.getBody().getDescription());
        Assert.assertEquals(updatedExercise.getName(), updateResponse.getBody().getName());
    }

    @Test
    public void test_deleteExercise() {
        RestTemplate template = new RestTemplate();
        Long exerciseId = (long) 99;
        template.delete("http://localhost:8080/api/v1/exercises/delete/" + exerciseId);

        ResponseEntity<Exercise> getResponse = template.getForEntity("http://localhost:8080/api/v1/exercises/"+exerciseId, Exercise.class);

        Assert.assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
    }
}
