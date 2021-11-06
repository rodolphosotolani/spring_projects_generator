package br.com.rts.gerador.controller;

import br.com.rts.gerador.configuration.security.domain.Usuario;
import br.com.rts.gerador.configuration.security.service.UsuarioService;
import br.com.rts.gerador.controller.response.UsuarioResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    @Cacheable(value = "listaDeUsuarios")
    public Page<UsuarioResponse> list(@RequestParam(required = false) String nome,
                                      @PageableDefault(sort = "nome", direction = Sort.Direction.DESC)
                                              Pageable paginacao) {
        Page<Usuario> usuarios = service.findByNome(nome, paginacao);
        return UsuarioResponse.converter(usuarios);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> viewById(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(
                new UsuarioResponse(
                        service.findById(idUsuario)));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UsuarioResponse> viewByUsername(@PathVariable String username) {
        return ResponseEntity.ok(
                new UsuarioResponse(
                        service.findByUsername(username)));
    }


}
