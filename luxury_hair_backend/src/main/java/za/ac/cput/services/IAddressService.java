package za.ac.cput.services;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.UserLogin;

import java.util.List;
import java.util.Optional;



public interface IAddressService extends IService<Address, Long> {
  
    List<Address> getall();  // Returns a list of all addresses

    Optional<Address> findByUserId(Long userId); // Fetches address by userId
}
