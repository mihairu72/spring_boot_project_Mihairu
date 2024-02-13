package ru.javarush.sitnikov.spring_boot_project.rabbitmq;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import ru.javarush.sitnikov.spring_boot_project.dto.UserDto;

@Component
@RequiredArgsConstructor
public class RabbitMqSender {

    private final RabbitTemplate rabbitTemplate;

    public Queue queue() {
        return new Queue("myQueue");
    }

    public void send(UserDto userDto) {
        rabbitTemplate.convertAndSend("myQueue", userDto);
        System.out.println("Sent '" + userDto + "' successfully!!!");
    }

}

// docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
