package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.dto.CustomerDto;



/**
 * Created by jt on 2019-04-21.
 */
public interface CustomerService {
    CustomerDto getCustomerById(Long customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(Long customerId, CustomerDto customerDto);

    void deleteById(Long customerId);
}
