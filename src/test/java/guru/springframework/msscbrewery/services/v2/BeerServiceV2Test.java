package guru.springframework.msscbrewery.services.v2;


import guru.springframework.msscbrewery.MsscBreweryApplication;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = MsscBreweryApplication.class)
public class BeerServiceV2Test {

    @Autowired(required=true)
    BeerServiceV2 beerServiceV2;

    BeerDtoV2 validBeerV2;
    UUID uuid= UUID.randomUUID();
    Long upc = 123456789012L;


    @BeforeEach
    public void setUp() {
        validBeerV2 = BeerDtoV2.builder().id(uuid)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.STOUT)
                .upc(123456789012L)
                .build();
    }

    @Test
        public void getBeer() throws Exception {
        BeerDtoV2 beerDtoV2 = beerServiceV2.getBeerById(UUID.randomUUID());
        assertEquals(validBeerV2.getUpc(), beerDtoV2.getUpc());
    }

    @Test
    public void saveNewBeer() throws Exception {
        BeerDtoV2 beerDtoV2 = beerServiceV2.saveNewBeer(validBeerV2);
        assertEquals(validBeerV2.getId(), beerDtoV2.getId());
    }

    @Test
    public void updateBeer() throws Exception {
        BeerDtoV2 beerDtoV2 = beerServiceV2.updateBeer(validBeerV2);
        assertEquals(validBeerV2.getId(), beerDtoV2.getId());
    }

    @Test
    public void deleteById() throws Exception {
        BeerDtoV2 beerDtoV2 = beerServiceV2.deleteById(validBeerV2.getId());
        assertEquals(validBeerV2.getId(), beerDtoV2.getId());
    }

}