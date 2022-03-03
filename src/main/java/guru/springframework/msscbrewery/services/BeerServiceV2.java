package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.dto.BeerDto;



/**
 * Created by jt on 2019-04-23.
 */
public interface BeerServiceV2 {
    BeerDto getBeerById(Long beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(BeerDto beerDto);

    BeerDto deleteById(Long beerId);
}
