/*package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressRepositoryTest {
    private Address address;
    @Autowired
    private AddressRepository repository;


    @BeforeEach
    void setUp() {
        address = AddressFactory.buildAdd(9876543,"10 Dorset Street","Western Cape","Cape Town",8001);
        assertNotNull(address);
        repository.save(address);
    }

    @Test
    void findByAddressId() {
        address = repository.findByAddressId(1221L);
        System.out.println("Found: " + address);
    }
}
    */