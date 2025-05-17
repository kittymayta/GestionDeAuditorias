package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.Usuario;
import com.auditoriasys.SysAuditorias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuariosService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuariosService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Integer id) {
        return usuariosService.findUserById(id);
    }

    @PostMapping("create")
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuariosService.createUsuario(usuario);
    }

    @PostMapping("update/{id}")
    public Usuario actualizar(@RequestBody Usuario usuario, @PathVariable Integer id) {
        usuario.setCodigoUsuario(id);
        return usuariosService.updateUsuario(usuario);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuariosService.deleteUsuario(id);
    }

    @GetMapping("tipoUsuario/{codigoTipoUsuario}")
    public List<Usuario> buscarPorTipoUsuario(@PathVariable Integer codigoTipoUsuario) {
        return usuariosService.findUserByUserType(codigoTipoUsuario);
    }

    //Este metodo cambia el estado del usuario
    @PostMapping("/{id}/cambiarEstado")
    public Usuario cambiarEstado(@PathVariable Integer id) {
        return usuariosService.cambiarEstado(id);
    }

    @GetMapping("/activos")
    public List<Usuario> buscarUsuariosActivos() {
        return usuariosService.getUsuariosActivos();
    }
}
