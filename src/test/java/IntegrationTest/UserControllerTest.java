package IntegrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportcompany.transportcompany.models.dtos.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class UserControllerTest {

    public static final String API_USERS_URL = "/api/users";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateUserShouldPass() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Maria");
        userDTO.setEmail("maria@gmail.com");
        userDTO.setAddress("Brasov");

        mockMvc.perform(post(API_USERS_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(objectToJsonString(userDTO))))
                .andExpect(status().is(200));
    }

    @Test
    void testCreateUserWithInvalidEmailShouldFail() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Maria");
        userDTO.setEmail("mariagmail.com");
        userDTO.setAddress("Brasov");

        System.out.println("UserDTO converted: " + userDTO);
        mockMvc.perform(post(API_USERS_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(objectToJsonString(userDTO))))
                .andExpect(status().is(400));
    }

    @Test
    void testGetUsersShouldPass() throws Exception {
        UserDTO userMaria = new UserDTO();
        userMaria.setName("Maria");
        userMaria.setEmail("maria@gmail.com");
        userMaria.setAddress("Brasov");

        UserDTO userIon = new UserDTO();
        userIon.setName("Ion");
        userIon.setEmail("ion@gmail.com");
        userIon.setAddress("Bucuresti");

        List<UserDTO> users = new ArrayList<>();
        users.add(userMaria);
        users.add(userIon);

        for (UserDTO user : users) {
            mockMvc.perform(post(API_USERS_URL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(Objects.requireNonNull(objectToJsonString(user))))
                    .andExpect(status().is(200));
        }

        MvcResult mvcResult = mockMvc.perform(get(API_USERS_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andReturn();
    }

    private String objectToJsonString(Object response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.findAndRegisterModules();
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
        }
        return null;
    }
}
