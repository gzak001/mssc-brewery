package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.dto.BeerDto;

import java.util.Optional;


/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {

    Optional<Beer> getBeerById(Long beerId);

    BeerDto getBeer(Long beerId);

    BeerDto saveBeer(BeerDto beerDto);

    void updateBeer(Long beerId, BeerDto beerDto);

    void deleteById(Long beerId);
}
