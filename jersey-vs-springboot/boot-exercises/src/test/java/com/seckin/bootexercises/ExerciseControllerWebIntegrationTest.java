package com.seckin.bootexercises;

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
}
