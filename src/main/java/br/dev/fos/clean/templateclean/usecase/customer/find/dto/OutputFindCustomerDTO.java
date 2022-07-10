package br.dev.fos.clean.templateclean.usecase.customer.find.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OutputFindCustomerDTO {
    String id;
    String name;
    Integer age;
    AddressDTO addressDTO;
}
