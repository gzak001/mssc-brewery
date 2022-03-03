package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



import static guru.springframework.msscbrewery.util.Utils.getRandomLong;

/**
 * Created by jt on 2019-04-21.
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomer(Long customerId) {
        return CustomerDto.builder()
                .id(getRandomLong())
                .name("Joe Buck")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(getRandomLong())
                .build();
    }

    @Override
    public void updateCustomer(Long customerId, CustomerDto customerDto) {
        //todo impl
        log.debug("Updating....");
    }

    @Override
    public void deleteCustomer(Long customerId) {
        log.debug("Deleting.... ");
    }
}
