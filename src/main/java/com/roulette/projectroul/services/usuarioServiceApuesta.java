package com.roulette.projectroul.services;

import java.util.ArrayList;
import java.util.Optional;

import com.roulette.projectroul.model.usuarioApuesta;
import com.roulette.projectroul.repository.usuarioReposioryApuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioServiceApuesta {
    @Autowired
    usuarioReposioryApuesta usuarioReposioryApuesta;

    public ArrayList<usuarioApuesta> obtenerUsuarios (){
       return (ArrayList<usuarioApuesta>) usuarioReposioryApuesta.findAll();
    }

    public usuarioApuesta guardarUsuario(usuarioApuesta usuario){
         return usuarioReposioryApuesta.save(usuario);
    }

    public Optional<usuarioApuesta> obtenerPorid (Long id){
        return usuarioReposioryApuesta.findById(id);
    }

    public ArrayList<usuarioApuesta> obtenerPorIdR(Long idR) {
        return  usuarioReposioryApuesta.findByidR(idR);
    }

    public boolean eliminarUsuario (Long id){
        try {
            usuarioReposioryApuesta.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

    public boolean acceptBet (Integer amount){
        Integer x= usuarioReposioryApuesta.findByAmount(amount);
        if (x<=10000){
            return true;
        }else {
            return false;
        }
    }
}