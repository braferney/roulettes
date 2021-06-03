package com.roulette.projectroul.services;

import java.util.ArrayList;
import java.util.Optional;
import com.roulette.projectroul.model.usuarioModel;
import com.roulette.projectroul.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Service roulettes
@Service
public class usuarioService {
    @Autowired
    usuarioRepository usuarioRepository;
    public ArrayList<usuarioModel> getroulettes() {

        return (ArrayList<usuarioModel>)usuarioRepository.findAll();
    }
    public usuarioModel  saveRoulettes(usuarioModel roulette) {

        return usuarioRepository.save(roulette);
    }
    public Optional<usuarioModel> getById(Long id) {

        return usuarioRepository.findById(id);
    }
    public usuarioModel getByIdNew(Long id){

        return usuarioRepository.findByIdR(id);
    }
    public ArrayList<usuarioModel> getByState(Boolean active){

        return usuarioRepository.findByActive(active);
    }
    public boolean deleteRoulette(Long id){
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