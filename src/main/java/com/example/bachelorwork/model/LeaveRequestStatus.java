package com.example.bachelorwork.model;

public enum LeaveRequestStatus {
    PENDING, APPROVED, REJECTED
}

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LeaveRequestStatus status;
