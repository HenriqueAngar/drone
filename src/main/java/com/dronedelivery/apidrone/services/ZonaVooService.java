ppackage com.dronedelivery.apidrone.services;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.ZonaVoo;
import com.dronedelivery.apidrone.repositories.ZonaVooRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaVooService {
    @Autowired
    private ZonaVooRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public ZonaVoo salvar(ZonaVoo entity) {



        return repo.save(entity);
    }

    public List<ZonaVoo> buscaTodos(String filter) {
        return repo.findAll(filter, ZonaVoo.class);
    }

    public Page<ZonaVoo> buscaTodos(String filter, Pageable pageable) {
        return repo.findAll(filter, ZonaVoo.class, pageable);
    }

    public ZonaVoo buscaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public ZonaVoo alterar(Long id, ZonaVoo entity) {
        Optional<ZonaVoo> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("ZonaVoo não encontrado");
        }

        ZonaVoo existingZonaVoo = byId.get();
        modelMapper.map(entity, existingZonaVoo);

        return repo.save(existingZonaVoo);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
