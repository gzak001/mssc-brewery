package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.dto.CustomerDto;



public interface CustomerDao {

    CustomerDto getCustomer(Long customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomer(Long customerId, CustomerDto customerDto);

    void deleteCustomer(Long customerId);
}
