package guru.springframework.msscbrewery.services;


import guru.springframework.msscbrewery.MsscBreweryApplication;
import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static guru.springframework.msscbrewery.util.Utils.getRandomLong;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = MsscBreweryApplication.class)
public class BeerServiceV2Test {

    @Autowired(required=true)
    BeerServiceV2 beerServiceV2;

    BeerDto validBeerV2;
    Long beerid= getRandomLong();
    Long upc = 123456789012L;


    @BeforeEach
    public void setUp() {
        validBeerV2 = BeerDto.builder().id(beerid)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.STOUT)
                .upc(123456789012L)
                .build();
    }

    @Test
        public void getBeer() throws Exception {
        BeerDto beerDto = beerServiceV2.getBeerById(getRandomLong());
        assertEquals(validBeerV2.getUpc(), beerDto.getUpc());
    }

    @Test
    public void saveNewBeer() throws Exception {
        BeerDto beerDto = beerServiceV2.saveNewBeer(validBeerV2);
        assertEquals(validBeerV2.getId(), beerDto.getId());
    }

    @Test
    public void updateBeer() throws Exception {
        BeerDto beerDto = beerServiceV2.updateBeer(validBeerV2);
        assertEquals(validBeerV2.getId(), beerDto.getId());
    }

    @Test
    public void deleteById() throws Exception {
        BeerDto beerDto = beerServiceV2.deleteById(validBeerV2.getId());
        assertEquals(validBeerV2.getId(), beerDto.getId());
    }

}