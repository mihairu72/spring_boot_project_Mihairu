package ru.javarush.sitnikov.spring_boot_project.service;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.sitnikov.spring_boot_project.dto.UserDto;
import ru.javarush.sitnikov.spring_boot_project.entity.UserEntity;
import ru.javarush.sitnikov.spring_boot_project.mapper.UserMapper;
import ru.javarush.sitnikov.spring_boot_project.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static UserDto userDto;

    private static UserEntity userEntity;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void init() {
        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Januarius");
        userEntity.setAge(33);

        userDto = new UserDto();
        userDto.setName("Januarius");
        userDto.setAge(33);
    }

    @Test
    public void getAll_whenUsersExist_ReturnUsers() {
        var expected = List.of(userDto);

        when(userRepository.findAll()).thenReturn(List.of(userEntity));
        when(userMapper.toUserDtos(List.of(userEntity))).thenReturn(List.of(userDto));

        var actual = userService.getAll();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

//    public List<UserDto> getAll() {
//        return userMapper.toUserDtos(userRepository.findAll());
//    }
}
