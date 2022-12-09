package com.slshop.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.slshop.common.entity.Customer;
import com.slshop.customer.CustomerMapper;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerUserDetailsService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> loginCustomerOptional = customerMapper.findByEmail(username);
        return loginCustomerOptional.map(loginCustomer -> new CustomerUserDetails(loginCustomer))
                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりませんでした。"));
    }

}
