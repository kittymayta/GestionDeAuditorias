package com.auditoriasys.SysAuditorias.repositories;

import com.auditoriasys.SysAuditorias.entities.NormaIso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NormaIsoRepository extends JpaRepository<NormaIso,Integer>{

}
