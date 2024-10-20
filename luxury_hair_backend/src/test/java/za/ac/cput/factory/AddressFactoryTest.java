package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void buildAdd() {

        Address address = AddressFactory.buildAdd(1121L, "Marlin Road", "Western Cape", "Cape Town", 7798);
        assertNotNull(address);
        assertEquals(1121L, address.getAddressId());
        assertEquals("Marlin Road", address.getStreetName());
        assertEquals("Western Cape", address.getProvince());
        assertEquals("Cape Town", address.getCity());
        assertEquals(7798, address.getZipCode());
        System.out.println(address);
    }
}