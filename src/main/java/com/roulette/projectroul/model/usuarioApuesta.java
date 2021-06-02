package com.roulette.projectroul.model;

import javax.persistence.*;

@Entity
@Table (name="bets")
public class usuarioApuesta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long numbet; 
    
    //@ManyToOne 
    private Long idR;

    private Integer amount;
    private Boolean active;
    private Long idUser;
    private Integer number;
    private String color;
   
    public Long getIdR() {
        return idR;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setIdR(Long idR) {
        this.idR = idR;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

}
