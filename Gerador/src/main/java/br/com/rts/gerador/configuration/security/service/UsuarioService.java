package br.com.rts.gerador.configuration.security.service;

import br.com.rts.gerador.configuration.security.domain.Usuario;
import br.com.rts.gerador.configuration.security.repository.UsuarioRepository;
import br.com.rts.gerador.exception.UsuarioNotFoundException;
import br.com.rts.gerador.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class UsuarioService implements Serializable {

    @Autowired
    private UsuarioRepository repository;

    public Page<Usuario> findByNome(String nome, Pageable pageable) {
        return this.repository.findByNome(SQLUtils.formatterString(nome), pageable);
    }

    public Optional<Usuario> findOptionalByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    public Usuario findByUsername(String username) {
        return findOptionalByUsername(username).orElseThrow(UsuarioNotFoundException::new);
    }

    public Usuario findById(Long idUsuario) {
        return this.findOptionalById(idUsuario).orElseThrow(UsuarioNotFoundException::new);
    }

    private Optional<Usuario> findOptionalById(Long idUsuario) {
        return this.repository.findById(idUsuario);
    }

}
