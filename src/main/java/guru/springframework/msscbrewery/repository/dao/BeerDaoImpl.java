package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.dto.BeerStyleEnum;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class BeerDaoImpl extends JdbcDao implements BeerDao {


     @Override
    public BeerDto getBeer(Long beerId){


         RowMapper rowMapper = (rs, rowNum) -> {
             BeerDto beerDto = new BeerDto();
             beerDto.setId(rs.getLong("id"));
             beerDto.setBeerName(rs.getString("beer_Name"));
             beerDto.setBeerStyle(BeerStyleEnum.valueOf(rs.getString("beer_Style")));
             beerDto.setUpc(rs.getLong("upc"));
             return beerDto;
         };
         String queryString = "select * from BEER where ID = ?  and ID = ?";
         BeerDto beerDto =null;
         try {
             beerDto = (BeerDto) getJdbcTemplate.queryForObject(queryString, new Object[]{beerId, beerId}, rowMapper);
         }
         catch(Exception e){
           System.out.println("Missing Beer: "+ beerId);
         }


       return beerDto;


    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto){
        final String queryString = "insert into beer (ID, BEER_NAME ,BEER_STYLE, UPC , CREATED_DATE, UPDATED_DATE )  values (?,?,?,?,?,?)";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        String currentDateTime = now.format(format);

        try {
            int updCnt= getJdbcTemplate.update(queryString, beerDto.getId() ,beerDto.getBeerName(), beerDto.getBeerStyle().name(),beerDto.getUpc(),currentDateTime,currentDateTime);
            System.out.println("inserting ID "+beerDto.getId()+", inserted count: "+updCnt);
        }
        catch(Exception e){

            System.out.println("Did not Insert Beer: "+ beerDto.getId());
            System.out.println(e.toString());
        }
        return beerDto;

    }
    @Override
     public void updateBeer(BeerDto beerDto){

        final String queryString = "update beer set BEER_NAME=? ,BEER_STYLE=?, UPC=? , UPDATED_DATE=?  where ID=?";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        String currentDateTime = now.format(format);

        try {
            int updCnt= getJdbcTemplate.update(queryString, beerDto.getBeerName(), beerDto.getBeerStyle().name(),beerDto.getUpc(),currentDateTime,beerDto.getId());
            System.out.println("Updating ID "+beerDto.getId()+", updated count: "+updCnt);
        }
        catch(Exception e){

            System.out.println("Did not Update Beer: "+ beerDto.getId());
            System.out.println(e.toString());
        }


    }
    @Override
    public void deleteBeer(Long beerId){
        String queryString = "Delete from BEER where ID = ? ";
        BeerDto beerDto =null;
        try {

            int updCnt = getJdbcTemplate.update(queryString, beerId);
            System.out.println("deleting ID "+beerId+", deleted rows: "+updCnt);
        }
        catch(Exception e){
            System.out.println("Did not Delete Beer: "+ beerId);
        }

    }

}
