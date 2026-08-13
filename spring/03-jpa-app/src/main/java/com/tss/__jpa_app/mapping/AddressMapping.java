package com.tss.__jpa_app.mapping;

import com.tss.__jpa_app.dto.AddressRequestDto;
import com.tss.__jpa_app.dto.AddressResponseDto;
import com.tss.__jpa_app.entity.Address;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AddressMapping {
    AddressResponseDto toDto(Address address);
    Address toAddress(AddressRequestDto addRequestDto);

    void updateAddress(AddressRequestDto dto, @MappingTarget Address address);
}
