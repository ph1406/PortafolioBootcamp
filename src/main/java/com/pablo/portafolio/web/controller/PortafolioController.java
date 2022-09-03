package com.pablo.portafolio.web.controller;

import com.pablo.portafolio.domain.entity.Portafolio;
import com.pablo.portafolio.domain.services.PortafolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;

@RestController
@RequestMapping("/portafolio")
public class PortafolioController {

    @Autowired
    private PortafolioService servicio;

    @GetMapping("/all")
    public ResponseEntity<List<Portafolio>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Portafolio> getById(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(servicio.getPortafolioById(id).get() , HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<Portafolio> save(@RequestBody Portafolio portafolio)
    {
        Portafolio po = servicio.savePortafolio(portafolio);

        if(po==null)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(po, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id)
    {
        servicio.deletePortafolio(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }



}
