package ru.javarush.sitnikov.spring_boot_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotNull
    private Integer age;
}
