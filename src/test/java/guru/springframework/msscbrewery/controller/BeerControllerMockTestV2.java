package guru.springframework.msscbrewery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.services.BeerServiceV2;
import guru.springframework.msscbrewery.dto.CustomerDto;
import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BeerControllerV2.class)
public class BeerControllerMockTestV2 {

    @MockBean
    BeerServiceV2 beerServiceV2;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired(required=false)
    CustomerService  customerService;

    BeerDto validBeer;
    CustomerDto validCustomer;
    Long beerId = getRandomLong();

    @BeforeEach
    public void setUp() {
        validBeer = BeerDto.builder().id(beerId)
                .beerName("Beer1")
                .beerStyle(BeerStyleEnum.LAGER)
                .upc(123456789012L)
                .build();

       validCustomer= CustomerDto.builder()
                .id(beerId)
                .name("Greg Zak")
                .build();

    }

    @Test
    public void getBeer() throws Exception {
        given(beerServiceV2.getBeer(any(Long.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v2/beer/" + validBeer.getId().longValue()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validBeer.getId().longValue())))
                .andExpect(jsonPath("$.beerName", is("Beer1")));
    }

    @Test
    public void handlePost() throws Exception {
        //given
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        BeerDto savedDto = BeerDto.builder().id(getRandomLong()).beerName("New Beer").build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerServiceV2.saveBeer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v2/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        String beerDtoV2Json = objectMapper.writeValueAsString(beerDto);

        //when
        mockMvc.perform(put("/api/v2/beer/" + getRandomLong())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoV2Json))
                .andExpect(status().isNoContent());

        then(beerServiceV2).should().updateBeer(any());

    }


}
