package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void buildAdd() {
        // Updated test to include userId and province
        Address address = AddressFactory.buildAdd(1121L, 1001L, "Marlin Road", "Western Cape", "Cape Town", 7798);
        
        assertNotNull(address);
        assertEquals(1121L, address.getAddressId());
        assertEquals(1001L, address.getUserLogin());  // Check userId
        assertEquals("Marlin Road", address.getStreetName());
        assertEquals("Western Cape", address.getProvince()); // Check province
        assertEquals("Cape Town", address.getCity());
        assertEquals(7798, address.getZipCode());
        
        System.out.println(address);
    }
}
