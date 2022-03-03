package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.dto.CustomerDto;



public class CustomerDaoImpl  implements CustomerDao {
    @Override
    public CustomerDto getCustomerById(Long customerId){
        CustomerDto customerDto = new CustomerDto();
        return customerDto;
    }
    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto){

        return customerDto;
    }

    @Override
    public void updateCustomer(Long customerId, CustomerDto customerDto){

    }

    @Override
    public void deleteById(Long customerId){

    }
}
