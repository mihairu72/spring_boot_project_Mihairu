package ru.javarush.sitnikov.spring_boot_project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javarush.sitnikov.spring_boot_project.dto.UserDto;
import ru.javarush.sitnikov.spring_boot_project.rabbitmq.RabbitMqSender;

@RestController
@RequiredArgsConstructor
@RequestMapping("send")
public class MessageController {

    private final RabbitMqSender rabbitMqSender;

    @PostMapping
    public void sendMessage(@RequestBody UserDto userDto) {
        rabbitMqSender.send(userDto);
    }

}
