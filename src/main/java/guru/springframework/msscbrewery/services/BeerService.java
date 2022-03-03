package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.dto.BeerDto;



/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    BeerDto getBeerById(Long beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(Long beerId, BeerDto beerDto);

    void deleteById(Long beerId);
}
