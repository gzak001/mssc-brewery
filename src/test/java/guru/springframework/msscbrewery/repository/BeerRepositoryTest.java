package guru.springframework.msscbrewery.repository;

import guru.springframework.msscbrewery.MsscBreweryApplication;

import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static guru.springframework.msscbrewery.util.Utils.getRandomLong;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
 */

@SpringBootTest(classes = MsscBreweryApplication.class)
public class BeerRepositoryTest {

    @Autowired(required=true)
    BeerRepository beerRepository;

    BeerDto validBeer;
    Long beerid= 1L;
    Long upc = 123456789012L;


    @BeforeEach
    public void setUp() {
        validBeer = BeerDto.builder()
                .id(beerid)
                .beerName("Yeugling")
                .beerStyle(BeerStyleEnum.LAGER)
                .upc(123456789012L)
                .build();
    }


    @Test
    public void saveBeer() throws Exception {
        BeerDto beerDto = beerRepository.saveBeer(validBeer);
        assertEquals(validBeer.getId(), beerDto.getId());
    }
    @Test
    public void getBeer() throws Exception {
        BeerDto beerDto = beerRepository.getBeer(beerid);
        assertEquals(validBeer.getUpc(), beerDto.getUpc());
    }



    @Test
    public void updateBeer() throws Exception {
        beerRepository.updateBeer(validBeer);
        assertEquals(validBeer.getId(), validBeer.getId());
    }

    @Test
    public void deleteBeer() throws Exception {
        beerRepository.deleteBeer(validBeer.getId());
        assertEquals(validBeer.getId(), validBeer.getId());
    }

}
