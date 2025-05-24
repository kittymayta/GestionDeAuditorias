package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.Interrogantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterrogantesRepository extends JpaRepository<Interrogantes, Integer> {
}
