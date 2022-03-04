package guru.springframework.msscbrewery.repository;

import guru.springframework.msscbrewery.MsscBreweryApplication;

import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import static guru.springframework.msscbrewery.util.Utils.getRandomLong;
import static org.junit.jupiter.api.Assertions.*;

/*
https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
 */


@SpringBootTest(classes = MsscBreweryApplication.class)
public class BeerRepositoryTest {

    @Autowired(required=true)
    BeerRepository beerRepository;

    Long beerId=getRandomLong();


    BeerDto expectedBeer = null;
    BeerDto actualBeer=null;

    @BeforeEach
    public void setUp() {
        expectedBeer = BeerDto.builder()
                .id(beerId)
                .beerName("Yeugling")
                .beerStyle(BeerStyleEnum.LAGER)
                .upc(123456789012L)
                .build();
    }


    @Test
    public void saveBeer() throws Exception {
        BeerDto actualBeer = beerRepository.saveBeer(expectedBeer);
        assertEquals(expectedBeer.getId(), actualBeer.getId());
    }
    @Test
     public void getBeer() throws Exception {
        beerRepository.saveBeer(expectedBeer);
        actualBeer = beerRepository.getBeer(expectedBeer.getId());
        assertEquals(expectedBeer.getId(), actualBeer.getId());
    }

    @Test
       public void updateBeer() throws Exception {
        beerRepository.saveBeer(expectedBeer);
        expectedBeer.setUpc(2222222222222L);
        beerRepository.updateBeer(expectedBeer);
        BeerDto actualBeer = beerRepository.getBeer(expectedBeer.getId());
        assertEquals(expectedBeer.getUpc(), actualBeer.getUpc());
    }

    @Test
        public void deleteBeer() throws Exception {
        beerRepository.saveBeer(expectedBeer);
        beerRepository.deleteBeer(expectedBeer.getId());
        actualBeer = beerRepository.getBeer(expectedBeer.getId());
        assertNull(actualBeer);
    }

}
