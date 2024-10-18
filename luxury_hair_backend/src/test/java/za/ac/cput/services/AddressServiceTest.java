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
        // Include userId (e.g., 1001L) in the Address creation
        address = AddressFactory.buildAdd(22341L, 1001L, "Corsair Way", "Western Cape", "Cape Town", 7765);
    }

    @Test
    @Order(1)
    void create() {
        Address created = service.create(address);
        assertNotNull(created);
        assertEquals(address.getAddressId(), created.getAddressId());
        assertEquals(address.getUserLogin(), created.getUserLogin()); // Validate userId
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        Address read = service.read(address.getAddressId());
        assertNotNull(read);
        assertEquals(address.getAddressId(), read.getAddressId());
        assertEquals(address.getUserLogin(), read.getUserLogin()); // Validate userId on read
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        // Update address and validate userId remains unchanged
        Address updatedAddress = new Address.Builder()
                .copy(address)
                .setStreetName("Updated Corsair Way") // Update with new street name
                .build();
        Address updated = service.update(updatedAddress);
        assertNotNull(updated);
        assertEquals("Updated Corsair Way", updated.getStreetName());
        assertEquals(address.getUserLogin(), updated.getUserLogin()); // Ensure userId remains consistent
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void getall() {
        System.out.println("All addresses: " + service.getall());
    }
}
