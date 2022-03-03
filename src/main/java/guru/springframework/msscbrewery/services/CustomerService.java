package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.dto.CustomerDto;



/**
 * Created by jt on 2019-04-21.
 */
public interface CustomerService {
    CustomerDto getCustomer(Long customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomer(Long customerId, CustomerDto customerDto);

    void deleteCustomer(Long customerId);
}
