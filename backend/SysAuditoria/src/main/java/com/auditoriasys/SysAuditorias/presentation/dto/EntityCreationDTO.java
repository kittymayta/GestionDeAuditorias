package com.auditoriasys.SysAuditorias.presentation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record EntityCreationDTO(
        String codigo,
        @NotBlank @NotNull @Size(min = 2) String nombre,
        @Min(0) Integer codigoTipoEntidad
) {
}
