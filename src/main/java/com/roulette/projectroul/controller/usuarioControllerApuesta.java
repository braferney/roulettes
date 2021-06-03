package com.roulette.projectroul.controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import com.roulette.projectroul.model.usuarioApuesta;
import com.roulette.projectroul.services.usuarioServiceApuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bets")
public class usuarioControllerApuesta {
    @Autowired
    usuarioServiceApuesta usuarioServiceApuesta;

    @GetMapping
    public ArrayList<usuarioApuesta> obtenerUsuarios(){
        return usuarioServiceApuesta.obtenerUsuarios();
    }

    @PostMapping ("/color")
    public String apuestaColor(@RequestBody usuarioApuesta usuario){
        Integer amount=usuario.getAmount();
        String color = usuario.getColor();
        if (amount<=10000){
            if (color.equals("Rojo") || color.equals("Negro")){
                //usuario.setNumber(40);
                usuarioServiceApuesta.guardarUsuario(usuario);    
                return "Apuesta al color "+color;   
            }else {
                return "Solo se puede ingresar el color Negro o Rojo";
            }        
        }  else {
            return "El monto maximo de apuesta es $10.000";
        }        
    }
    @PostMapping ("/number")
    public String apuestaNumber(@RequestBody usuarioApuesta usuario){
        Integer amount=usuario.getAmount();
        Integer number =usuario.getNumber();
        if (amount<=10000){
            if (number>=0 && number<=36){
                if(number%2==0){
                    usuario.setColor("Rojo");
                    usuarioServiceApuesta.guardarUsuario(usuario);
                    return "Apuesta al numero "+number + " color Rojo";
                }else{
                    usuario.setColor("Negro");
                    usuarioServiceApuesta.guardarUsuario(usuario);
                    return "Apuesta al numero "+number +" color Negro";
                }
            }else{
                return "Los numeros disponibles de apuesta son los numeros entre 0 y 36";
            }
        }else{
            return "El monto maximo de apuesta es $10.000";
        }
    }
    

    @GetMapping(path = "/{id}")
    public Optional<usuarioApuesta> obtenerUsuarioPorid(@PathVariable ("id") Long id){
        return this.usuarioServiceApuesta.obtenerPorid(id);
    }

    @GetMapping("/query")
    public ArrayList<usuarioApuesta> obtenerUsuarioPoridR(@RequestParam("idR") Long idR ){
        return this.usuarioServiceApuesta.obtenerPorIdR(idR);
    }

    @DeleteMapping (path = "id")
    public String eliminarPorId (@PathVariable ("id") Long id){
        boolean ok = this.usuarioServiceApuesta.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id "+id;
        }else {
            return "No se pudo eliminar el usuario con id " +id;
        }
    }

    @GetMapping(path = "/close/{idR}")
    public String winnerBet(@PathVariable("idR") Long idR) {
        ArrayList<usuarioApuesta> usuario;
        usuarioApuesta winner;
        usuario = usuarioServiceApuesta.obtenerPorIdR(idR);
        Random rnd = new Random();
        Integer random= rnd.nextInt(19)*2;
        String iscolor;
        if (random%2==0){
             iscolor= "Rojo";
        }else {
            iscolor ="Negro";
        }
        
        usuario=usuarioServiceApuesta.searchWinnerColor(iscolor);
        winner = usuarioServiceApuesta.searchWinner(random);
        Integer amount = winner.getAmount();
        
        Long idUser = winner.getIdUser();
        String color = winner.getColor();
        
        //Integer number=winner.getNumber();
        
        //return "algo";
        if (color.equals("null")){
            Integer ganate = amount*4;
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

