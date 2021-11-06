package br.com.rts.gerador.controller.response;

import br.com.rts.gerador.configuration.security.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String username;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.username = usuario.getUsername();
    }

    public static Page<UsuarioResponse> converter(Page<Usuario> usuarioList) {
        return usuarioList.map(UsuarioResponse::new);
    }
}
