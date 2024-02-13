package ru.javarush.sitnikov.spring_boot_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javarush.sitnikov.spring_boot_project.dto.UserDto;
import ru.javarush.sitnikov.spring_boot_project.entity.UserEntity;
import ru.javarush.sitnikov.spring_boot_project.exception.MyException;
import ru.javarush.sitnikov.spring_boot_project.mapper.UserMapper;
import ru.javarush.sitnikov.spring_boot_project.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDto> getAll() {
        return userMapper.toUserDtos(userRepository.findAll());
    }

    public void save(UserDto userDto) throws MyException {
//        if (1==1) throw new MyException("My first exception!!!");
        userRepository.save(userMapper.toUserEntity(userDto));
    }

    public void deleteById (Long id) {
        userRepository.deleteById(id);
    }

    public void updateById(Long id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        userEntity.setName(userDto.getName());
//        userEntity.setAge(userDto.getAge());
        userRepository.save(userEntity);
    }

    public List<UserDto> findAllByAge(Integer age) {
        List<UserEntity> userEntities = userRepository.findUserEntitiesByAgeGreaterThanOrderByAge(age);
        return userMapper.toUserDtos(userEntities);
    }

    public Integer countUserEntitiesByAgeGreaterThan(Integer age) {
        return userRepository.countUserEntitiesByAgeGreaterThan(age);
    }

    public List<UserDto> findAllByAgeBetween(Integer ageMin, Integer ageMax) {
        List<UserEntity> userEntities = userRepository.findUserEntitiesByAgeBetween(ageMin, ageMax);
        return userMapper.toUserDtos(userEntities);
    }

}
