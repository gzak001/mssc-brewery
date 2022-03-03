package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
import guru.springframework.msscbrewery.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import static guru.springframework.msscbrewery.util.Utils.getRandomLong;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    BeerRepository beerRepository;

    @Override
    public BeerDto getBeerById(Long beerId) {

        BeerDto beerDto = beerRepository.getBeer(beerId);
        if(beerDto==null){
            beerDto= BeerDto.builder().id(getRandomLong())
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.LAGER)
                    .build();
        }

        return beerDto;
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
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
