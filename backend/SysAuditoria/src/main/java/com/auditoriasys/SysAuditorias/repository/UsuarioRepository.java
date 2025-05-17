package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    List<Usuario> findByTipoUsuarioCodigoTipoUsuario (Integer codigoTipoUsuario);

}
