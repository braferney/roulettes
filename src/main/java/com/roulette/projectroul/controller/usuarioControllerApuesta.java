package com.roulette.projectroul.controller;

import java.util.ArrayList;
import java.util.Optional;

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

    @PostMapping
    public usuarioApuesta guardarUsuario(@RequestBody usuarioApuesta usuario){
        Integer amount=usuario.getAmount();
        Integer number =usuario.getNumber();
        String color = usuario.getColor();
        if (amount<=10000){
            if(0<=number && number<=36){
                return this.usuarioServiceApuesta.guardarUsuario(usuario);
            }else if (color=="Rojo" || color=="Negro"){
                return this.usuarioServiceApuesta.guardarUsuario(usuario);
            }else {
                return null;
            }
        }else  {
            return null;
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

    /*@GetMapping(value="/start")
    public SomeData getMethodName(@RequestParam String param) {
        return new SomeData();
    }
    
    /*    @GetMapping (path="/start")
        public String acceptedBet (Integer amount){
        Boolean x= usuarioServiceApuesta.acceptBet(amount);
        if (x==true){
            return "Apuesta con monto" + amount;
            }else {
            return null;
        }
        }
        */


}

