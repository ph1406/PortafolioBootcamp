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


    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<Usuario>> getByciudadContains(@PathVariable("ciudad") String ciudad)
    {
        return new ResponseEntity<>(servicio.getByciudadContains(ciudad), HttpStatus.OK);
    }

    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<Usuario>> getBypaisContains(@PathVariable("pais")  String pais)
    {
        return new ResponseEntity<>(servicio.getBypaisContains(pais), HttpStatus.OK);
    }
    @GetMapping("/disponibleExtranjero/{activo}")
    public ResponseEntity<List<Usuario>> getBydisponibleExtranjero(@PathVariable("activo")  int activo)
    {
        Boolean buscaDisponibles = (activo==1);
        return new ResponseEntity<>(servicio.getBydisponibleExtranjero(buscaDisponibles), HttpStatus.OK);
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
