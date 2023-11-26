package com.dronedelivery.apidrone.repositories;

import com.dronedelivery.apidrone.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PedidoRepo extends JpaRepository<Pedido, Long>, CustomQuerydslPredicateExecutor<Pedido>{

}
