package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.EstadoAuditoria;
import com.auditoriasys.SysAuditorias.service.EstadoAuditoriaService;
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
@RequestMapping("api/estadosAuditoria")
public class EstadoAuditoriaController {
	
	@Autowired
	private EstadoAuditoriaService estadoAuditoriaService;
	
	@GetMapping
	public List<EstadoAuditoria> listarEstadosAuditorias() {
		return estadoAuditoriaService.getEstadoAuditorias();
	}
	
	@GetMapping("/{id}")
	public Optional<EstadoAuditoria> buscarPorId(@PathVariable Integer id) {
		return estadoAuditoriaService.findEstadoAuditoriaById(id);
	}
	
	@PostMapping("create")
	public EstadoAuditoria crear(@RequestBody EstadoAuditoria estadoAuditoria) {
		return estadoAuditoriaService.createEstadoAuditoria(estadoAuditoria);
	}
	
	@PostMapping("update/{id}")
	public EstadoAuditoria actualizar(@RequestBody EstadoAuditoria estadoAuditoria, @PathVariable Integer id) {
		estadoAuditoria.setCodigoEstadoAuditoria(id);
		return estadoAuditoriaService.updateEstadoAuditoria(estadoAuditoria);
	}
	
	@DeleteMapping("delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		estadoAuditoriaService.deleteEstadoAuditoria(id);
	}
}
