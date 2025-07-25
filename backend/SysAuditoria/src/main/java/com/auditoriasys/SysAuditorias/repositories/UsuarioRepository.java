package com.auditoriasys.SysAuditorias.repositories;

import java.util.List;

import com.auditoriasys.SysAuditorias.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    List<Usuario> findByTipoUsuarioCodigoTipoUsuario (Integer codigoTipoUsuario);

}
