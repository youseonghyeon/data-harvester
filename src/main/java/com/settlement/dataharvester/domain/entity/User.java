package com.settlement.dataharvester.domain.entity;

import com.settlement.dataharvester.domain.dto.user.SignUpForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private UUID id;

    private String username;

    private String password;

    private String email;

    private String fullname;

    private LocalDateTime createAt;

    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User(String username, String password, String email, String fullname) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.createAt = LocalDateTime.now();
        this.updatedAt = this.createAt;
        this.status = UserStatus.getDefaultStatus();
    }

}
