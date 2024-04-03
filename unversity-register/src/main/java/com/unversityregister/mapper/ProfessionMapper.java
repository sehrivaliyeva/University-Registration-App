package com.unversityregister.mapper;

import com.unversityregister.demo.Profession;
import com.unversityregister.dto.ProfessionRequest;
import com.unversityregister.dto.ProfessionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfessionMapper {
    ProfessionMapper INSTANCE = Mappers.getMapper(ProfessionMapper.class);

    @Mapping(target = "name", source = "name")
    Profession mapRequestToProfession(ProfessionRequest professionRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProfessionResponse mapProfessionToResponse(Profession profession);

}
