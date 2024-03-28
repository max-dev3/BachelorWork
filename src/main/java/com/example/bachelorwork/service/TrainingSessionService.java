package com.example.bachelorwork.service;

import com.example.bachelorwork.model.TrainingSession;
import com.example.bachelorwork.repository.TrainingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    @Autowired
    public TrainingSessionService(TrainingSessionRepository trainingSessionRepository) {
        this.trainingSessionRepository = trainingSessionRepository;
    }

    public List<TrainingSession> getAllTrainingSessions() {
        return trainingSessionRepository.findAll();
    }

    public Optional<TrainingSession> getTrainingSessionById(Long id) {
        return trainingSessionRepository.findById(id);
    }

    public TrainingSession createTrainingSession(TrainingSession trainingSession) {
        return trainingSessionRepository.save(trainingSession);
    }

    public TrainingSession updateTrainingSession(Long id, TrainingSession trainingSessionDetails) {
        TrainingSession trainingSession = trainingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training session not found with id " + id));

        trainingSession.setTitle(trainingSessionDetails.getTitle());
        trainingSession.setStartDate(trainingSessionDetails.getStartDate());
        trainingSession.setEndDate(trainingSessionDetails.getEndDate());
        trainingSession.setDescription(trainingSessionDetails.getDescription());

        return trainingSessionRepository.save(trainingSession);
    }

    public void deleteTrainingSession(Long id) {
        TrainingSession trainingSession = trainingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training session not found with id " + id));

        trainingSessionRepository.delete(trainingSession);
    }
}
