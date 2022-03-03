package guru.springframework.msscbrewery.controller;

import guru.springframework.msscbrewery.MsscBreweryApplication;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.services.BeerServiceV2;
import guru.springframework.msscbrewery.dto.CustomerDto;
import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static guru.springframework.msscbrewery.util.Utils.getRandomLong;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MsscBreweryApplication.class)
public class BeerControllerTestV2 {

    @Autowired
    BeerServiceV2 beerServiceV2;

    @Autowired
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
    public void validBeerNotEqualsNewBeer() throws Exception{
        BeerDto beerDto = beerServiceV2.getBeerById(beerId);
        assertNotEquals(validBeer.getId(), beerDto.getId());
    }


    @Test
    public void validCustomerNotEqualsNewCustomer() throws Exception{
        CustomerDto customerDto = customerService.getCustomerById(beerId);
        assertNotEquals(validCustomer.getId(),customerDto.getId());
    }

}