package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{

}
