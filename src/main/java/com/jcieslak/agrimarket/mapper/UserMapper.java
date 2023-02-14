package com.jcieslak.agrimarket.mapper;

import com.jcieslak.agrimarket.model.User;
import com.jcieslak.agrimarket.payload.request.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "password", ignore = true)
    User registerToEntity(RegisterRequest registerRequest);
}
