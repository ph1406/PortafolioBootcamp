package com.pablo.portafolio.web.controller;


import com.pablo.portafolio.domain.entity.Proyecto;
import com.pablo.portafolio.domain.services.ProyectoService;
import com.pablo.portafolio.persistence.models.ProyectoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService servicio;


    @GetMapping("/all")
    public ResponseEntity<List<Proyecto>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }
    @GetMapping("/tecnologia/{tecnologia}")
    public ResponseEntity<List<Proyecto>> getProyectoTecnologia(@PathVariable("tecnologia") String tecnologia)
    {
        return new ResponseEntity<>(servicio.getBytecnologiaContains(tecnologia), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(servicio.getProyectoById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Proyecto> save(@RequestBody Proyecto proyecto)
    {
       Proyecto pro =  servicio.saveProyecto(proyecto);

       if(pro==null)
       {
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }

       return new ResponseEntity<>(pro, HttpStatus.CREATED);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id)
    {
        servicio.deleteProyecto(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
