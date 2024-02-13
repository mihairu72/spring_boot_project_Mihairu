package ru.javarush.sitnikov.spring_boot_project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.javarush.sitnikov.spring_boot_project.dto.UserDto;
import ru.javarush.sitnikov.spring_boot_project.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    List<UserDto> toUserDtos(List<UserEntity> userEntity);

    UserEntity toUserEntity(UserDto userDto);
}
