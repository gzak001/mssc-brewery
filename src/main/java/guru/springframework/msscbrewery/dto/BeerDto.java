package guru.springframework.msscbrewery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt on 2019-04-23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private Long id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;

 }
