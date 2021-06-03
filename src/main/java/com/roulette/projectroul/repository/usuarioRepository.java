package com.roulette.projectroul.repository;

import java.util.ArrayList;
import com.roulette.projectroul.model.usuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Repository roulettes
@Repository
public interface usuarioRepository extends CrudRepository<usuarioModel , Long> {
    public abstract ArrayList<usuarioModel> findByActive(Boolean active);
    public abstract usuarioModel findByIdR(Long id);
}