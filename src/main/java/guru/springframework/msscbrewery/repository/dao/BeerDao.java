package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.dto.BeerDto;




    public interface BeerDao {

    BeerDto getBeer(Long beerId);

    BeerDto saveBeer(BeerDto beerDto);

    void updateBeer(BeerDto beerDto);

    void deleteBeer(Long beerId);
}
