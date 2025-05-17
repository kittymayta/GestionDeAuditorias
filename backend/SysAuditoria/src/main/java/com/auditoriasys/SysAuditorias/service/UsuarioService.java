package com.auditoriasys.SysAuditorias.service;

import com.auditoriasys.SysAuditorias.entity.Usuario;
import com.auditoriasys.SysAuditorias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findUserById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> findUserByUserType(Integer id) {
        return usuarioRepository.findByTipoUsuarioCodigoTipoUsuario(id);
    }

    public Usuario cambiarEstado(Integer id) {
        Usuario u = findUserById(id).get();
        if(u.isEstadoUso()) u.setEstadoUso(false);
        else u.setEstadoUso(true);

        updateUsuario(u);

        return u;
    }

    public List<Usuario> getUsuariosActivos() {
        return getUsuarios().stream().filter( u -> u.isEstadoUso()==true).toList();
    }
}