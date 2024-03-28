package com.example.bachelorwork.controller;

import com.example.bachelorwork.model.WorkHistory;
import com.example.bachelorwork.service.WorkHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/workHistories")
public class WorkHistoryController {

    private final WorkHistoryService workHistoryService;

    @Autowired
    public WorkHistoryController(WorkHistoryService workHistoryService) {
        this.workHistoryService = workHistoryService;
    }

    @GetMapping
    public List<WorkHistory> getAllWorkHistories() {
        return workHistoryService.getAllWorkHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkHistory> getWorkHistoryById(@PathVariable Long id) {
        return workHistoryService.getWorkHistoryById(id)
                .map(workHistory -> ResponseEntity.ok().body(workHistory))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public WorkHistory createWorkHistory(@RequestBody WorkHistory workHistory) {
        return workHistoryService.createWorkHistory(workHistory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkHistory> updateWorkHistory(@PathVariable Long id, @RequestBody WorkHistory workHistoryDetails) {
        try {
            WorkHistory updatedWorkHistory = workHistoryService.updateWorkHistory(id, workHistoryDetails);
            return ResponseEntity.ok(updatedWorkHistory);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorkHistory(@PathVariable Long id) {
        try {
            workHistoryService.deleteWorkHistory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
