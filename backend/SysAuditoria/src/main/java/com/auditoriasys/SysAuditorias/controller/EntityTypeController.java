package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.TipoEntidad;
import com.auditoriasys.SysAuditorias.service.TipoEntidadService;
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
@RequestMapping("api/tipoEntidades")
public class EntityTypeController {
	
	@Autowired
	TipoEntidadService TipoEntidadsService;
	
	@GetMapping
	public List<TipoEntidad> listarTipoEntidades() {
		return TipoEntidadsService.getTipoEntidades();
	}
	
	@GetMapping("/{id}")
	public Optional<TipoEntidad> buscarPorId(@PathVariable Integer id) {
		return TipoEntidadsService.findTipoEntidadById(id);
	}
	
	@PostMapping("create")
	public TipoEntidad crear(@RequestBody TipoEntidad TipoEntidad) {
		return TipoEntidadsService.createTipoEntidad(TipoEntidad);
	}
	
	@PostMapping("update/{id}")
	public TipoEntidad actualizar(@RequestBody TipoEntidad TipoEntidad, @PathVariable Integer id) {
		TipoEntidad.setCodigoTipoEntidad(id);
		return TipoEntidadsService.updateTipoEntidad(TipoEntidad);
	}
	
	@DeleteMapping("delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		TipoEntidadsService.deleteTipoEntidad(id);
	}
	
}
