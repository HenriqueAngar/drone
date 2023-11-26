package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long idUsuario;
    private String nome;
    private String senha;
    private String role;

    public static UsuarioDTO fromEntity(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNome(usuario.getNome());
        dto.setSenha(usuario.getSenha());
        dto.setRole(usuario.getRole());
        return dto;
    }

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setRole(role);
        return usuario;
    }

    public static List<UsuarioDTO> fromEntity(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDTO::fromEntity).collect(Collectors.toList());
    }

    public static Page<UsuarioDTO> fromEntity(Page<Usuario> usuarios) {
        List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(usuariosDTO, usuarios.getPageable(), usuarios.getTotalElements());
    }
}
