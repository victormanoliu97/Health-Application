package com.fiipractic.health.boundry.mapper;

import com.fiipractic.health.boundry.dtos.DoctorDTO;
import com.fiipractic.health.entity.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Victor Manoliu on 12-Apr-18
 */
@Mapper
public interface DoctorMapper {

    DoctorMapper MAPPER = Mappers.getMapper( DoctorMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "doctor_id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber.phoneNumber", target = "phoneNumber.phoneNumber"),
            @Mapping(source = "function", target = "function"),
            @Mapping(source = "address.street", target = "address.street"),
            @Mapping(source = "email.email", target = "email.email"),
    })
    DoctorDTO fromDoctor(Doctor doctor);

    @Mappings({
            @Mapping(source = "doctor_id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber.phoneNumber", target = "phoneNumber.phoneNumber"),
            @Mapping(source = "function", target = "function"),
            @Mapping(source = "address.street", target = "address.street"),
            @Mapping(source = "email.email", target = "email.email"),
    })
    Doctor toDoctor(DoctorDTO doctorDto);

    @Mappings({
            @Mapping(source = "doctor_id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber.phoneNumber", target = "phoneNumber.phoneNumber"),
            @Mapping(source = "function", target = "function"),
            @Mapping(source = "address.street", target = "address.street"),
            @Mapping(source = "email.email", target = "email.email"),
    })
    void toDoctor(DoctorDTO doctorDto, @MappingTarget Doctor doctorEntity);
}

