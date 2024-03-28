package com.example.bachelorwork.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // Унікальне ім'я користувача
    private String password; // Захешований пароль
    private String email;    // Електронна пошта користувача

    @Enumerated(EnumType.STRING)
    private Role role; // Використовуємо enum для зберігання ролі

    private boolean isActive; // Статус активності користувача

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}