package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
import org.springframework.stereotype.Service;



import static guru.springframework.msscbrewery.util.Utils.getRandomLong;

/**
 * Created by jt on 2019-04-23.
 */
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDto getBeer(Long beerId) {
        return BeerDto.builder().id(getRandomLong())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.STOUT)
                .upc(123456789012L)
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {

        BeerDto beerDtoV2 =
                 BeerDto.builder().id(beerDto.getId())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .build();
        return beerDtoV2;
    }

    @Override
    public BeerDto updateBeer(BeerDto beerDto) {
        BeerDto beerDtoV2 =
                BeerDto.builder().id(beerDto.getId())
                        .beerName(beerDto.getBeerName())
                        .beerStyle(beerDto.getBeerStyle())
                        .upc(beerDto.getUpc())
                        .build();
        return beerDtoV2;
    }

    @Override
    public BeerDto deleteBeer(Long beerId) {
        BeerDto beerDto =
                BeerDto.builder().id(beerId)
                        .build();
        return beerDto;
    }
}
