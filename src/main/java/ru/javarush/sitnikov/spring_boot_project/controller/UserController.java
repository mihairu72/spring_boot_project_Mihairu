package ru.javarush.sitnikov.spring_boot_project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javarush.sitnikov.spring_boot_project.dto.UserDto;
import ru.javarush.sitnikov.spring_boot_project.exception.MyException;
import ru.javarush.sitnikov.spring_boot_project.service.UserService;

import java.util.List;

@RestController // @ResponseBody + @Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping("getAll") // http://localhost:1221/users/getAll
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public void save(@RequestBody @Valid UserDto userDto) throws MyException {
        userService.save(userDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable("id") Long id, @RequestBody @Valid UserDto userDto) {
        userService.updateById(id, userDto);
    }

    @GetMapping("/findByAge/{age}")
    public List<UserDto> findAllByAge(@PathVariable Integer age) {
        return userService.findAllByAge(age);
    }

    @GetMapping("/countAllUsersByAge/{age}")
    public Integer countAllUsersByAge(@PathVariable Integer age) {
        return userService.countUserEntitiesByAgeGreaterThan(age);
    }
    @GetMapping("/findByAgeBetween")
    public List<UserDto> findAllByAgeBetween(@RequestParam Integer ageMin, @RequestParam Integer ageMax) {
        return userService.findAllByAgeBetween(ageMin, ageMax);
    }


}
