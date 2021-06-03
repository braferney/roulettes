package com.roulette.projectroul.controller;

import java.util.ArrayList;
import java.util.Random;
import com.roulette.projectroul.model.usuarioApuesta;
import com.roulette.projectroul.services.usuarioServiceApuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//Controller bets
@RestController
@RequestMapping("/bets")
public class usuarioControllerApuesta {
    @Autowired
    usuarioServiceApuesta usuarioServiceApuesta;
    @GetMapping
    public ArrayList<usuarioApuesta> getBets(){

        return usuarioServiceApuesta.getBets();
    }
    @PostMapping ("/color")
    public String betColor(@RequestBody usuarioApuesta usuario){
        Integer amount=usuario.getAmount();
        String color = usuario.getColor();
        if (amount<=10000){
            if (color.equals("Rojo") || color.equals("Negro")){
                usuarioServiceApuesta.saveBets(usuario);   

                return "Apuesta al color "+color;   
            }else {

                return "Solo se puede ingresar el color Negro o Rojo";
            }        
        }  else {

            return "El monto maximo de apuesta es $10.000";
        }        
    }
    @PostMapping ("/number")
    public String betNumber(@RequestBody usuarioApuesta usuario){
        Integer amount=usuario.getAmount();
        Integer number =usuario.getNumber();
        if (amount<=10000){
            if (number>=0 && number<=36){
                if(number%2==0){
                    usuario.setColor("Rojo");
                    usuarioServiceApuesta.saveBets(usuario);

                    return "Apuesta al numero "+number + " color Rojo";
                }else{
                    usuario.setColor("Negro");
                    usuarioServiceApuesta.saveBets(usuario);

                    return "Apuesta al numero "+number +" color Negro";
                }
            }else{

                return "Los numeros disponibles de apuesta son los numeros entre 0 y 36";
            }
        }else{

            return "El monto maximo de apuesta es $10.000";
        }
    }
    @GetMapping("/query")
    public ArrayList<usuarioApuesta> getByidR(@RequestParam("idR") Long idR ){

        return this.usuarioServiceApuesta.getByIdR(idR);
    }
    @GetMapping(path = "/close/{idR}")
    public String winnerBet(@PathVariable("idR") Long idR) {
        ArrayList<usuarioApuesta> usuario;
        usuarioApuesta winner;
        usuario = usuarioServiceApuesta.getByIdR(idR);
        Random rnd = new Random();
        Integer random= rnd.nextInt(19)*2;
        String iscolor;
        if (random%2==0){
             iscolor= "Rojo";
        }else {
            iscolor ="Negro";
        }
        usuario=usuarioServiceApuesta.searchWinnerColor(usuario, iscolor);
        winner = usuarioServiceApuesta.searchWinner(random);
        Integer amount = winner.getAmount();
        Long idUser = winner.getIdUser();
        String color = winner.getColor();
        if (color.equals("null")){
            Integer ganate = amount*5;

            return  random+" El usuario con id "+idUser+" ha ganado "+ganate+ " por su apuesta por numero";
        }else {
            Float ganate = amount*1.8f;
            if (random%2==0){

                return "El usuario con id "+idUser+"ha ganado "+ganate+" por su apuesta por color "+color;
            }else{

                return "El usuario con id "+idUser+"ha ganado "+ganate+" por su apuesta por color "+color;
            } 
        }
    }
}