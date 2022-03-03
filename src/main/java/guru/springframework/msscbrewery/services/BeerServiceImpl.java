package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    BeerRepository beerRepository;

    public Optional<Beer> getBeerById(Long beerId) {

        //Optional<Beer> beer = beerRepository.findById(beerId);
        Optional<Beer> beer = beerRepository.findById(beerId);
        return beer;
    }
    @Override
    public BeerDto getBeer(Long beerId) {

        //Optional<Beer> beer = beerRepository.findById(beerId);
        BeerDto beerDto = beerRepository.getBeer(beerId);
        return beerDto;
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        BeerDto beerDtoSaved = beerRepository.saveBeer(beerDto);

        return beerDtoSaved;

    }

    @Override
    public void updateBeer(Long beerId, BeerDto beerDto) {
        beerRepository.updateBeer(beerDto);
    }

    @Override
    public void deleteById(Long beerId) {
        beerRepository.deleteBeer(beerId);
    }
}
