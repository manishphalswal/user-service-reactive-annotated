package org.ipo.rwa.reactive.userservice.dao;

import org.ipo.rwa.reactive.userservice.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IUserRepository extends ReactiveMongoRepository<User, String> {
}
