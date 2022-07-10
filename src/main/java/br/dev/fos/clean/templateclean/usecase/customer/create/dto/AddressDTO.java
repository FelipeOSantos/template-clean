package br.dev.fos.clean.templateclean.usecase.customer.create.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/* 
Pergunta: Porque repetir os DTOs ao inves de reutilizarmos.
Resposta: Principio da responsabilidade unica, se por algum motivo esses DTOs mudarem nao afetam os outros usecases.
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressDTO {
    String street;
    String city;
    String number;
    String zip;
}
