package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.UserLogin;
import java.util.Optional;


import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
    // Find all addresses by the associated UserLogin (userId)
    List<Address> findByUserLogin(UserLogin userLogin);

    // Find all addresses by userId from UserLogin
    Optional<Address> findByUserId(Long userId);

    // Optional: You can also query by other fields, like city, streetName, etc.
    List<Address> findByCity(String city);
}
