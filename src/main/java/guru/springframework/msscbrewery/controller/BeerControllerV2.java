package guru.springframework.msscbrewery.controller;

import guru.springframework.msscbrewery.services.BeerServiceV2;
import guru.springframework.msscbrewery.dto.BeerDto;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by jt on 2019-04-23.
 */
@Slf4j
//@AllArgsConstructor
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {


    private BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") Long beerId){

        return new ResponseEntity<>(beerServiceV2.getBeer(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto){

        log.debug("in handle post...");

        val savedDto = beerServiceV2.saveBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") Long beerId, @Valid @RequestBody BeerDto beerDto){

        beerServiceV2.updateBeer(beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") Long beerId){
        beerServiceV2.deleteBeer(beerId);
    }

}
