package com.auditoriasys.SysAuditorias.repositories;

import com.auditoriasys.SysAuditorias.entities.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{

}
