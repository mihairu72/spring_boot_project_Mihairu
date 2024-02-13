package ru.javarush.sitnikov.spring_boot_project.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.javarush.sitnikov.spring_boot_project.service.UserService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javarush.sitnikov.spring_boot_project.constants.TestConstants.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAll_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/getAll")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, times(1)).getAll();
    }
//    void getAll_Success() throws Exception {
//        mockMvc.perform(
//                get("/users/getAll")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        verify(userService, times(1)).getAll();
//    }


    @Test
    void findByAge_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/findByAge/{age}", AGE)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, times(1)).findAllByAge(AGE);
    }

    @Test
    void findAllByAgeBetween_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/findByAgeBetween?ageMin={minAge}&ageMax={maxAge}", MINAGE, MAXAGE)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, times(1)).findAllByAgeBetween(MINAGE, MAXAGE);
    }

    @Test
    void save_new_DTO_Success() throws Exception {
        USER_DTO_TEST.setName(NAME);
        USER_DTO_TEST.setAge(AGE);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(USER_DTO_TEST)))
                .andExpect(status().isOk());

        verify(userService, times(1)).save(USER_DTO_TEST);
    }


    @Test
    void deleteById_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/users/{id}", ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteById(ID);
    }

}
