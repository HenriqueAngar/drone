package com.dronedelivery.apidrone.repositories;


import com.dronedelivery.apidrone.model.ZonaVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaVooRepo extends JpaRepository<ZonaVoo, Long>, CustomQuerydslPredicateExecutor<ZonaVoo>{

}
