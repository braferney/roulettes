package com.roulette.projectroul.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.roulette.projectroul.model.usuarioModel;
import com.roulette.projectroul.services.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//Controller roulettes
@RestController
@RequestMapping("/roulettes")
public class usuarioController {
    @Autowired
    usuarioService usuarioService;
    @GetMapping()
    public ArrayList<usuarioModel> showRoulettes(){

        return usuarioService.getroulettes();
    } 
    @PostMapping
    public usuarioModel saveRoulette(@RequestBody usuarioModel roulette) {

        return this.usuarioService.saveRoulettes(roulette);
    }
    @GetMapping (path = "/{id}")
    public Optional <usuarioModel> getById(@PathVariable("id") Long id){

        return this.usuarioService.getById(id);
    }
    @GetMapping("/query")
    public ArrayList<usuarioModel> getByState (@RequestParam("active") Boolean active) {

        return this.usuarioService.getByState(active);
    }
    @DeleteMapping (path = "/{id}")
    public String deleteRoulette(@PathVariable("id") Long id) {
        boolean ok =this.usuarioService.deleteRoulette(id);
        if (ok){

            return "Se eliminó el usurio con id "+id;
        } else{

            return "No pudo eliminar el usuario con id "+id;
        }
    }
    @GetMapping ("/activate/{id}")
    public String activateRoulette (@PathVariable("id") Long id) {
        boolean x=this.usuarioService.activateRoulette(id);
        usuarioModel usuario;
        usuario=usuarioService.getByIdNew(id);
        Boolean y= usuario.isActive();
        if (y==true){

            return "La ruleta ya se encuentra activada ";
        }else if(x==true) {
            usuario.setActive(true);
            usuarioService.saveRoulettes(usuario);

            return "Se activó la ruleta con id "+id +"true"; 
        }else {

            return "No se pudo activar la ruleta con id "+id;
        }    
    }
}