package guru.springframework.msscbrewery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.dto.CustomerDto;
import guru.springframework.msscbrewery.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static guru.springframework.msscbrewery.util.Utils.getRandomLong;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerMockTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerDto validCustomer;

    @BeforeEach
    public void setUp() {
        validCustomer = CustomerDto.builder()
                .id(getRandomLong().longValue())
                .name("Customer1")
                .build();
    }

    @Test
    public void getCustomer() throws Exception {
        given(customerService.getCustomer(any())).willReturn(validCustomer);

        mockMvc.perform(get("/api/v1/customer/" + validCustomer.getId().longValue()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validCustomer.getId().longValue())))
                .andExpect(jsonPath("$.name", is("Customer1")));
    }

    @Test
    public void handlePost() throws Exception {
        //given
        CustomerDto customerDto = validCustomer;
        customerDto.setId(null);
        CustomerDto savedDto = CustomerDto.builder().id(getRandomLong()).name("New Customer").build();
        String customerDtoJson = objectMapper.writeValueAsString(customerDto);

        given(customerService.saveCustomer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/customer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given
        CustomerDto customerDto = validCustomer;
        customerDto.setId(null);
        String customerDtoJson = objectMapper.writeValueAsString(customerDto);

        //when
        mockMvc.perform(put("/api/v1/customer/" + getRandomLong())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerDtoJson))
                .andExpect(status().isNoContent());

        then(customerService).should().updateCustomer(any(), any());

    }
}
