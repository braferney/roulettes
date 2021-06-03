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

    public usuarioApuesta searchWinner (Integer number){
            return usuarioReposioryApuesta.findByNumber(number);
    }

    public ArrayList<usuarioApuesta> searchWinnerColor (String color){
        return usuarioReposioryApuesta.findByColor(color);
    }

    /*public usuarioApuesta filterByColor(ArrayList<usuarioApuesta> usuario){
        return usuarioReposioryApuesta.findByColor(color);
    }*/
}