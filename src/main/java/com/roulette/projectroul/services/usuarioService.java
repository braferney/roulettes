package com.roulette.projectroul.services;

import java.util.ArrayList;
//import java.util.Optional;
import java.util.Optional;

import com.roulette.projectroul.model.usuarioModel;
import com.roulette.projectroul.repository.usuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;

@Service
public class usuarioService {
    @Autowired
    usuarioRepository usuarioRepository;
    

    public ArrayList<usuarioModel> obtenerUsuarios() {
        return (ArrayList<usuarioModel>)usuarioRepository.findAll();
    }

    public usuarioModel  guardarUsuario(usuarioModel roulette) {
        return usuarioRepository.save(roulette);
    }
    
    public Optional<usuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public usuarioModel obtenerporIdNuev(Long id){
        return usuarioRepository.findByIdR(id);
    }

    public ArrayList<usuarioModel> obtenerPorEstado(Boolean active){
        return usuarioRepository.findByActive(active);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true; 
        }catch(Exception err){
            return false; 
        }
    }
    public boolean activateRoulette(Long id){
        return usuarioRepository.existsById(id);
    } 

    public boolean getActive (usuarioModel usuario){
        return usuario.isActive();
    }
}