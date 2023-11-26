package com.dronedelivery.apidrone.repositories;
import com.dronedelivery.apidrone.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepo extends JpaRepository<Rota, Long>, CustomQuerydslPredicateExecutor<Rota>{

}
