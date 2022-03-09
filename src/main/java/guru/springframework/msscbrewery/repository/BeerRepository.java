package guru.springframework.msscbrewery.repository;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.repository.dao.BeerDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long>, BeerDao {


 /*
 @Modifying
 @Query("UPDATE person SET first_name = :name WHERE id = :id")
 boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);
 @Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
 Foo retrieveByName(@Param("name") String name);
*/

}
