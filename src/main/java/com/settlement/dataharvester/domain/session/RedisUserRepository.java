package com.settlement.dataharvester.domain.session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RedisUserRepository extends CrudRepository<UserSession, UUID> {
}
