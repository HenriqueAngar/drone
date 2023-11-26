package com.dronedelivery.apidrone.repositories;

import com.dronedelivery.apidrone.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepo extends JpaRepository<Drone, Long>, CustomQuerydslPredicateExecutor<Drone>{

}