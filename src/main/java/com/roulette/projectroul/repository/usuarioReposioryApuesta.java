package com.roulette.projectroul.repository;

import java.util.ArrayList;

import com.roulette.projectroul.model.usuarioApuesta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioReposioryApuesta extends CrudRepository <usuarioApuesta,Long> {
    public abstract ArrayList<usuarioApuesta> findByidR(Long idR);
    public abstract Integer findByAmount(Integer amount);
}