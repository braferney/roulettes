package com.roulette.projectroul.model;

import javax.persistence.*;
//Entity roulettes 
@Entity
@Table (name="roulettes")
public class usuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idR;
    private String roulette;
    private Boolean active;
    public Long getIdR() {

        return idR;
    }
    public void setIdR(Long idR) {
        this.idR = idR;
    }
    public String getRoulette() {

        return roulette;
    }
    public void setRoulette(String roulette) {
        this.roulette = roulette;
    }
   
    public boolean isActive() {

        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}