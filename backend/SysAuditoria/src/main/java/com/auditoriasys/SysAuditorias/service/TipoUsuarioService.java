package com.auditoriasys.SysAuditorias.service;

import com.auditoriasys.SysAuditorias.entity.TipoUsuario;
import com.auditoriasys.SysAuditorias.repository.TipoUsuarioRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoUsuarioService {
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	public List<TipoUsuario> getTipoUsuarios() {
		return tipoUsuarioRepository.findAll();
	}
	
	public TipoUsuario createTipoUsuario(TipoUsuario TipoUsuario) {
		return tipoUsuarioRepository.save(TipoUsuario);
	}
	
	public TipoUsuario updateTipoUsuario(TipoUsuario TipoUsuario) {
		return tipoUsuarioRepository.save(TipoUsuario);
	}
	
	public void deleteTipoUsuario(Integer id) {
		tipoUsuarioRepository.deleteById(id);
	}
	
	public Optional<TipoUsuario> findTipoUsuarioById(Integer id) {
		return tipoUsuarioRepository.findById(id);
	}
	
}
