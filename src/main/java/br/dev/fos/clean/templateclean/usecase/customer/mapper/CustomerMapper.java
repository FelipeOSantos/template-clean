package br.dev.fos.clean.templateclean.usecase.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.usecase.customer.create.dto.InputCreateCustomerDto;
import br.dev.fos.clean.templateclean.usecase.customer.create.dto.OutputCreateCustomerDto;
import br.dev.fos.clean.templateclean.usecase.customer.find.dto.OutputFindCustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    @Mapping(target = "addressDTO", ignore = true)
    OutputFindCustomerDTO customerToOutputFindCustomerDTO(Customer customer);

    Customer inputCreateCustomerDtoToCustomer(InputCreateCustomerDto inputCreateCustomerDto);

    OutputCreateCustomerDto customerToOutputCreateCustomerDto(Customer customer);
}
