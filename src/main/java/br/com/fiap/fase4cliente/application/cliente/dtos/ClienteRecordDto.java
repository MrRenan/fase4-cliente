package br.com.fiap.fase4cliente.application.cliente.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRecordDto(@NotBlank String name, @NotBlank @Email String email) {
    public ClienteRecordDto(@NotBlank String name, @NotBlank @Email String email) {
        this.name = name;
        this.email = email;
    }

    public @NotBlank String name() {
        return this.name;
    }

    public @NotBlank @Email String email() {
        return this.email;
    }
}
