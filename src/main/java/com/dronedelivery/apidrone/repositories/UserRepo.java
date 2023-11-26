package com.dronedelivery.apidrone.repositories;

import com.dronedelivery.apidrone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>, CustomQuerydslPredicateExecutor<User> {

}
