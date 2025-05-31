package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.TipoUsuario;
import com.auditoriasys.SysAuditorias.service.TipoUsuarioService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/tipoUsuarios")
public class TipoUsuarioController {
	
	@Autowired
	TipoUsuarioService tipoUsuariosService;
	
	@GetMapping
	public List<TipoUsuario> listarTipoUsuarios() {
		return tipoUsuariosService.getTipoUsuarios();
	}
	
	@GetMapping("/{id}")
	public Optional<TipoUsuario> buscarPorId(@PathVariable Integer id) {
		return tipoUsuariosService.findTipoUsuarioById(id);
	}
	
	@PostMapping("create")
	public TipoUsuario crear(@RequestBody TipoUsuario TipoUsuario) {
		return tipoUsuariosService.createTipoUsuario(TipoUsuario);
	}
	
	@PostMapping("update/{id}")
	public TipoUsuario actualizar(@RequestBody TipoUsuario TipoUsuario, @PathVariable Integer id) {
		TipoUsuario.setCodigoTipoUsuario(id);
		return tipoUsuariosService.updateTipoUsuario(TipoUsuario);
	}
	
	@DeleteMapping("delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		tipoUsuariosService.deleteTipoUsuario(id);
	}
	
}
