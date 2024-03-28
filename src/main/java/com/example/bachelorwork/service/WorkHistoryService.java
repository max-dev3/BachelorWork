package com.example.bachelorwork.service;

import com.example.bachelorwork.model.WorkHistory;
import com.example.bachelorwork.repository.WorkHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkHistoryService {

    private final WorkHistoryRepository workHistoryRepository;

    @Autowired
    public WorkHistoryService(WorkHistoryRepository workHistoryRepository) {
        this.workHistoryRepository = workHistoryRepository;
    }

    public List<WorkHistory> getAllWorkHistories() {
        return workHistoryRepository.findAll();
    }

    public Optional<WorkHistory> getWorkHistoryById(Long id) {
        return workHistoryRepository.findById(id);
    }

    public WorkHistory createWorkHistory(WorkHistory workHistory) {
        return workHistoryRepository.save(workHistory);
    }

    public WorkHistory updateWorkHistory(Long id, WorkHistory workHistoryDetails) {
        WorkHistory workHistory = workHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkHistory not found with id " + id));

        workHistory.setCompanyName(workHistoryDetails.getCompanyName());
        workHistory.setPosition(workHistoryDetails.getPosition());
        workHistory.setStartDate(workHistoryDetails.getStartDate());
        workHistory.setEndDate(workHistoryDetails.getEndDate());
        // Додайте будь-які інші поля, які потрібно оновити

        return workHistoryRepository.save(workHistory);
    }

    public void deleteWorkHistory(Long id) {
        workHistoryRepository.deleteById(id);
    }
}
