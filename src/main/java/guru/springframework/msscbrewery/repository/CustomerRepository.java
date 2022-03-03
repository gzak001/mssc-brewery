package guru.springframework.msscbrewery.repository;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.repository.dao.CustomerDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> , CustomerDao {
}
