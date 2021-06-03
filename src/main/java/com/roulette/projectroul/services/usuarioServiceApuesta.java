package com.roulette.projectroul.services;

import java.util.ArrayList;
import com.roulette.projectroul.model.usuarioApuesta;
import com.roulette.projectroul.repository.usuarioReposioryApuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Service bets
@Service
public class usuarioServiceApuesta {
    @Autowired
    usuarioReposioryApuesta usuarioReposioryApuesta;
    public ArrayList<usuarioApuesta> getBets (){

       return (ArrayList<usuarioApuesta>) usuarioReposioryApuesta.findAll();
    }
    public usuarioApuesta saveBets(usuarioApuesta usuario){

         return usuarioReposioryApuesta.save(usuario);
    }
    public ArrayList<usuarioApuesta> getByIdR(Long idR) {

        return  usuarioReposioryApuesta.findByidR(idR);
    }
    public usuarioApuesta searchWinner (Integer number){

            return usuarioReposioryApuesta.findByNumber(number);
    }
    public ArrayList<usuarioApuesta> searchWinnerColor (ArrayList<usuarioApuesta> user,String color){

        return user= usuarioReposioryApuesta.findByColor(color);
    }
}