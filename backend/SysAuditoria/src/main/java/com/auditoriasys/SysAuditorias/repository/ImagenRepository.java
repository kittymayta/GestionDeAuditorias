package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepository  extends JpaRepository<Imagen, Integer> {
    List<Imagen> findByCodigoNormaIso(Integer name);
}
