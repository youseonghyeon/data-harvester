package com.settlement.dataharvester.domain.session;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@RedisHash(value = "UserSession")
public class UserSession implements Serializable {

    private static final long serialVersionUID = 5792934234L;

    @Id
    private UUID sessionId;

    private UUID id;

    private String fullname;

    private LocalDateTime loginAt;


}
