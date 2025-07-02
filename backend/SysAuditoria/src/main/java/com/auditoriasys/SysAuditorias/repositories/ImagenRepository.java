package com.auditoriasys.SysAuditorias.repositories;

import java.util.List;

import com.auditoriasys.SysAuditorias.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer>{

    List<Imagen> findByCodigoNormaIso(Integer name);

}
