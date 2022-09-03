package com.pablo.portafolio.web.controller;

import com.pablo.portafolio.domain.entity.Usuario;
import com.pablo.portafolio.domain.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") long id)
    {
        return new ResponseEntity<>(servicio.getUsuarioByRut(id).get(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario)
    {
        Usuario usr = servicio.saveUsuario(usuario);
        return new ResponseEntity<>(usr, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id)
    {
        servicio.deleteUsuario(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
