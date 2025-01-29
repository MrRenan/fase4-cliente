package br.com.fiap.fase4cliente.features.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Cliente {

    private String id;
    private String nome;

}