package guru.springframework.msscbrewery.repository;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.repository.dao.BeerDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long>, BeerDao {

   }
