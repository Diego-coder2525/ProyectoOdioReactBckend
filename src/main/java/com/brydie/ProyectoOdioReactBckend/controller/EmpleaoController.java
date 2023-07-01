package com.brydie.ProyectoOdioReactBckend.controller;

import com.brydie.ProyectoOdioReactBckend.entity.Empleao;
import com.brydie.ProyectoOdioReactBckend.service.EmpleaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpleaoController {

    @Autowired
    private EmpleaoService empleaoService;

    // peticion get
    @GetMapping("/listarEmpleao")
    public ArrayList<Empleao> listarEmpleao(){
        return empleaoService.listarEmpleao();
    }
    // peticion post(guardar registro) <- requiere objeto json
    @PostMapping("/guardarEmpleao")
    public Empleao guardarEmpleao(@RequestBody Empleao empleao){
        return empleaoService.guardarEmpleao(empleao);
    }
    // peticion delete <- post pero para eliminar :v
    @DeleteMapping("/del/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean r = empleaoService.eliminarEmpleao(id);
        if (r) {
            return "Se elimino el empleao con id: " + id;
        } else {
            return "No se pudo elimianr el empleao con id: " + id;
        }
    }
    // peticion put <- post pero para actualizar :v <- id por la ruta y objeto json
    @PutMapping("/put/{id}")
    public ResponseEntity<Empleao> actualizarEmpleao(@RequestBody Empleao empleao, @PathVariable Long id) {
        try {
            // Buscamos empleao por id
            Empleao empleaoActual = empleaoService.obtenerPorId(id).get();


            empleaoActual.setNombre(empleao.getNombre());
            empleaoActual.setEmail(empleao.getEmail());
            empleaoActual.setApellido(empleao.getApellido());

            empleaoService.guardarEmpleao(empleaoActual);

            // Envia la respuesta al RESTclient de estado http OK 200
            return new ResponseEntity<Empleao>(HttpStatus.OK);

        } catch (Exception e) {

            // Envia la respuesta al RESTclient de estado http not_found 404
            return new ResponseEntity<Empleao>(HttpStatus.NOT_FOUND);
        }

    }
}
