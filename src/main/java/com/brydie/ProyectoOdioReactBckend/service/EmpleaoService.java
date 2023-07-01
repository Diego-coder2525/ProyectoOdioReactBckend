package com.brydie.ProyectoOdioReactBckend.service;

import com.brydie.ProyectoOdioReactBckend.entity.Empleao;
import com.brydie.ProyectoOdioReactBckend.repository.EmpleaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpleaoService {
    @Autowired
    EmpleaoRepository empleaoRepository;

    public ArrayList<Empleao> listarEmpleao(){
        return (ArrayList<Empleao>) empleaoRepository.findAll();
    }
    public Empleao guardarEmpleao(Empleao empleao){
        // sirve tambien para actualizar
        return empleaoRepository.save(empleao);
    }

    public Optional<Empleao> obtenerPorId(Long id){
        return empleaoRepository.findById(id);
    }
    public boolean eliminarEmpleao(Long id) {
        try {
            // esto suelta una excepcion
            empleaoRepository.deleteById(id);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
