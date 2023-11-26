package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Pedido;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PedidoDTO {

    private Long idPedido;
    private long usuario;
    private long entrega;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public static PedidoDTO fromEntity(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setIdPedido(pedido.getIdPedido());
        dto.setUsuario(pedido.getUsuario());
        dto.setEntrega(pedido.getEntrega());
        dto.setInicio(pedido.getInicio());
        dto.setFim(pedido.getFim());
        return dto;
    }

    public Pedido toEntity() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(idPedido);
        pedido.setUsuario(usuario);
        pedido.setEntrega(entrega);
        pedido.setInicio(inicio);
        pedido.setFim(fim);
        return pedido;
    }

    public static List<PedidoDTO> fromEntity(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDTO::fromEntity).collect(Collectors.toList());
    }

    public static Page<PedidoDTO> fromEntity(Page<Pedido> pedidos) {
        List<PedidoDTO> pedidosDTO = pedidos.stream().map(PedidoDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(pedidosDTO, pedidos.getPageable(), pedidos.getTotalElements());
    }
}
