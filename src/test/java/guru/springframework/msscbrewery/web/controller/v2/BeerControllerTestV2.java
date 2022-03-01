package guru.springframework.msscbrewery.web.controller.v2;

import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msscbrewery.MsscBreweryApplication;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertNotEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MsscBreweryApplication.class)
public class BeerControllerTestV2 {

    @Autowired
    BeerServiceV2 beerServiceV2;

    @Autowired
    CustomerService  customerService;

    BeerDtoV2 validBeer;
    CustomerDto validCustomer;
    UUID uuid =UUID.randomUUID();

    @BeforeEach
    public void setUp() {

        validBeer = BeerDtoV2.builder().id(uuid)
                .beerName("Beer1")
                .beerStyle(BeerStyleEnum.LAGER)
                .upc(123456789012L)
                .build();

        validCustomer= CustomerDto.builder()
                .id(uuid)
                .name("Greg Zak")
                .build();

    }
    @Test
    public void validBeerNotEqualsNewBeer() throws Exception{
        BeerDtoV2 beerDtoV2 = beerServiceV2.getBeerById(uuid);
        assertNotEquals(validBeer.getId(),beerDtoV2.getId());
    }


    @Test
    public void validCustomerNotEqualsNewCustomer() throws Exception{
        CustomerDto customerDto = customerService.getCustomerById(uuid);
        assertNotEquals(validCustomer.getId(),customerDto.getId());
    }

}