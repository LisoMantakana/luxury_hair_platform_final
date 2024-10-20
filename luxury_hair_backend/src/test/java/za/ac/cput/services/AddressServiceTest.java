package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {

    @Autowired
    private AddressService service;
    Address address;

    @BeforeEach
    void setUp() {
        address = AddressFactory.buildAdd(22341L, "Corsair Way", "Western Cape", "Cape Town", 7765);
    }

    @Test
    @Order(1)
    void create() {
        Address add = service.create(address);
        assertNotNull(add);
        assertEquals(address.getAddressId(), add.getAddressId());
        assertEquals(address.getStreetName(), add.getStreetName());
        assertEquals(address.getProvince(), add.getProvince());
        assertEquals(address.getCity(), add.getCity());
        assertEquals(address.getZipCode(), add.getZipCode());
        System.out.println("Added: " + add);
    }

    @Test
    @Order(2)
    void read() {
        Address read = service.read(address.getAddressId());
        assertNotNull(read);
        assertEquals(address.getAddressId(), read.getAddressId());
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        // Updated the Address instance without houseNumber
        Address updatedAddress = new Address.Builder()
                .copy(address)
                .setStreetName("Updated Corsair Way") // Update with new street name
                .build();
        Address updated = service.update(updatedAddress);
        assertNotNull(updated);
        assertEquals("Updated Corsair Way", updated.getStreetName());
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(service.getAll());
    }
}