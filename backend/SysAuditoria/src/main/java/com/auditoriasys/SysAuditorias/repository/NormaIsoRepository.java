package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.NormaIso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NormaIsoRepository extends JpaRepository<NormaIso,Integer>{

}
