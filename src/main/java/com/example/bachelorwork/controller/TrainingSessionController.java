package com.example.bachelorwork.controller;

import com.example.bachelorwork.model.TrainingSession;
import com.example.bachelorwork.service.TrainingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainingSessions")
public class TrainingSessionController {

    private final TrainingSessionService trainingSessionService;

    @Autowired
    public TrainingSessionController(TrainingSessionService trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }

    @GetMapping
    public List<TrainingSession> getAllTrainingSessions() {
        return trainingSessionService.getAllTrainingSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingSession> getTrainingSessionById(@PathVariable Long id) {
        return trainingSessionService.getTrainingSessionById(id)
                .map(session -> new ResponseEntity<>(session, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public TrainingSession createTrainingSession(@RequestBody TrainingSession trainingSession) {
        return trainingSessionService.createTrainingSession(trainingSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingSession> updateTrainingSession(@PathVariable Long id, @RequestBody TrainingSession trainingSessionDetails) {
        try {
            TrainingSession updatedSession = trainingSessionService.updateTrainingSession(id, trainingSessionDetails);
            return new ResponseEntity<>(updatedSession, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTrainingSession(@PathVariable Long id) {
        try {
            trainingSessionService.deleteTrainingSession(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}