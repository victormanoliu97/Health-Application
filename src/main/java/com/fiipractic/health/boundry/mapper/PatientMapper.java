package com.fiipractic.health.boundry.mapper;

import com.fiipractic.health.boundry.dtos.PatientDTO;
import com.fiipractic.health.entity.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Victor Manoliu on 12-Apr-18
 */
@Mapper
public interface PatientMapper {

    PatientMapper MAPPER = Mappers.getMapper( PatientMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "patient_id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber.phoneNumber", target = "phoneNumber.phoneNumber"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "address.street", target = "address.street"),
            @Mapping(source = "email.email", target = "email.email"),
    })
    PatientDTO fromPatient(Patient patient);

    @Mappings({
            @Mapping(source = "patient_id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber.phoneNumber", target = "phoneNumber.phoneNumber"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "address.street", target = "address.street"),
            @Mapping(source = "email.email", target = "email.email"),
    })
    Patient toPatient(PatientDTO patientDto);

    @Mappings({
            @Mapping(source = "patient_id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber.phoneNumber", target = "phoneNumber.phoneNumber"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "address.street", target = "address.street"),
            @Mapping(source = "email.email", target = "email.email"),
    })
    void toPatient(PatientDTO patientDto, @MappingTarget Patient patientEntity);
}

