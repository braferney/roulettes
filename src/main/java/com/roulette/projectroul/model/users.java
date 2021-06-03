package com.roulette.projectroul.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//Entity users
@Entity
@Table(name= "users")
public class users {
    @Id
    private Long idUser;
    private Integer credits;
    public Long getIdUser() {

        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public Integer getCredits() {

        return credits;
    }
    public void setCredits(Integer credits) {
        this.credits = credits;
    }   
}