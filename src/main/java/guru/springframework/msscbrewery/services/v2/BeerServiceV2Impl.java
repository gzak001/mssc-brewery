package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jt on 2019-04-23.
 */
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.STOUT)
                .upc(123456789012L)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {

        BeerDtoV2 beerDtoV2 =
                 BeerDtoV2.builder().id(beerDto.getId())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .build();
        return beerDtoV2;
    }

    @Override
    public BeerDtoV2 updateBeer(BeerDtoV2 beerDto) {
        BeerDtoV2 beerDtoV2 =
                BeerDtoV2.builder().id(beerDto.getId())
                        .beerName(beerDto.getBeerName())
                        .beerStyle(beerDto.getBeerStyle())
                        .upc(beerDto.getUpc())
                        .build();
        return beerDtoV2;
    }

    @Override
    public BeerDtoV2 deleteById(UUID beerId) {
        BeerDtoV2 beerDtoV2 =
                BeerDtoV2.builder().id(beerId)
                        .build();
        return beerDtoV2;
    }
}
