package com.dronedelivery.apidrone.repositories;

import com.dronedelivery.apidrone.model.Entrega;
import com.dronedelivery.apidrone.model.Trajeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetoRepo extends JpaRepository<Trajeto, Long>, CustomQuerydslPredicateExecutor<Trajeto>{

}