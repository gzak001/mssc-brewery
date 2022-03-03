package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
import guru.springframework.msscbrewery.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class BeerDaoImpl implements BeerDao {

    @Override
    public BeerDto getBeer(Long beerId){


        BeerDto beerDto = BeerDto.builder()
                .id(beerId)
                .beerName("Yeugling")
                .beerStyle(BeerStyleEnum.LAGER)
                .upc(123456789012L)
                .build();

        return beerDto;
    }
    @Override
    public BeerDto saveBeer(BeerDto beerDto){
        BeerDto rtnBeerDto = BeerDto.builder()
                .id(beerDto.getId())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
        return rtnBeerDto;

    }
    @Override
     public void updateBeer(BeerDto beerDto){

    }
    @Override
    public void deleteBeer(Long beerId){

    }
}
