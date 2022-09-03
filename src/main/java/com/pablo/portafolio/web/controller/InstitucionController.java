package com.pablo.portafolio.web.controller;

import com.pablo.portafolio.domain.entity.Institucion;
import com.pablo.portafolio.domain.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institucion")
public class InstitucionController {

    @Autowired
    private InstitucionService servicio;

    @GetMapping("/all")
    public ResponseEntity<List<Institucion>> getAll()
    {
        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Institucion> getById(@PathVariable("id") int idInstitucion)
    {
       return new ResponseEntity<>(servicio.getInstitucionById(idInstitucion).get(), HttpStatus.OK);
    }



    @PostMapping("/save")
    public ResponseEntity<Institucion> save(@RequestBody Institucion institucion)
    {
       Institucion inst =  servicio.saveInstitucion(institucion);
       if(inst==null)
       {
           return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(inst, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id)
    {
        servicio.deleteInstitucion(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
