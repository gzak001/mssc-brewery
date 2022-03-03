package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.dto.CustomerDto;



public interface CustomerDao {

    CustomerDto getCustomerById(Long customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(Long customerId, CustomerDto customerDto);

    void deleteById(Long customerId);
}
