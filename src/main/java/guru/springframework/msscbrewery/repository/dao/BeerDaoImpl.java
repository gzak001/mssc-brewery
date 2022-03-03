package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.dto.BeerDto;



public class BeerDaoImpl implements BeerDao {

    @Override
    public BeerDto getBeer(Long beerId){
        BeerDto beerDto = new BeerDto();
        return beerDto;
    }
    @Override
    public BeerDto saveBeer(BeerDto beerDto){
        beerDto = new BeerDto();
        return beerDto;

    }
    @Override
     public void updateBeer(BeerDto beerDto){

    }
    @Override
    public void deleteBeer(Long beerId){

    }
}
