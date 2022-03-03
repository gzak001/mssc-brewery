package guru.springframework.msscbrewery.repository.dao;

import guru.springframework.msscbrewery.dto.CustomerDto;



public class CustomerDaoImpl  implements CustomerDao {
    @Override
    public CustomerDto getCustomer(Long customerId){
        CustomerDto customerDto = new CustomerDto();
        return customerDto;
    }
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto){

        return customerDto;
    }

    @Override
    public void updateCustomer(Long customerId, CustomerDto customerDto){

    }

    @Override
    public void deleteCustomer(Long customerId){

    }
}
