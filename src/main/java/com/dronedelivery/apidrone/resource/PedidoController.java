import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Pedido;
import com.dronedelivery.apidrone.resource.PedidoDTO;
import com.dronedelivery.apidrone.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.AbstractController;

import java.net.URI;

// NEW PEDIDO CONTROLLER
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController extends AbstractController {

    @Autowired
    private PedidoService service;


    @PostMapping
    public ResponseEntity<PedidoDTO> create(@RequestBody @Validated Pedido entity) {
        Pedido savedPedido = service.salvar(entity);
        PedidoDTO pedidoDTO = PedidoDTO.fromEntity(savedPedido);
        URI location = URI.create("/api/pedidos/" + savedPedido.getIdPedido());
        return ResponseEntity.created(location).body(pedidoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<PedidoDTO>> findAll(@RequestParam(required = false) String filter,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Page<Pedido> pedidos = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<PedidoDTO> pedidoDTOS = PedidoDTO.fromEntity(pedidos);
        return ResponseEntity.ok(pedidoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable("id") Long id) {
        Pedido pedido = service.buscaPorId(id);
        PedidoDTO pedidoDTO = PedidoDTO.fromEntity(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> update(@PathVariable("id") Long id, @RequestBody Pedido entity) {
        try {
            Pedido pedidoAlterado = service.alterar(id, entity);
            PedidoDTO pedidoDTO = PedidoDTO.fromEntity(pedidoAlterado);
            return ResponseEntity.ok(pedidoDTO);
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }
}