package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.services.IAddressService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AddressControllerTest {

    @Mock
    private IAddressService addressService;

    @InjectMocks
    private AddressController addressController;

    private Address address1, address2;
    private final String BASE_URL = "http://localhost:8080/LuxuryHairVendingSystemDB/address";
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        address1 = new Address.Builder()
                .setAddressId(1L)
                .setStreetName("Main Street")
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setZipCode(8000)
                .build();

        address2 = new Address.Builder()
                .setAddressId(2L)
                .setStreetName("Second Street")
                .setCity("Johannesburg")
                .setProvince("Gauteng")
                .setZipCode(2000)
                .build();
    }

    @Test
    void testSubmitAddress() {
        // Simulate successful creation of address1
        when(addressService.create(any(Address.class))).thenReturn(address1);

        // Use the addressController to submit address1
        ResponseEntity<Address> response = addressController.create(address1);

        // Verify the response status and content
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(address1.getAddressId(), response.getBody().getAddressId());
        assertEquals("Main Street", response.getBody().getStreetName());

        // Verify that the addressService was called once
        verify(addressService, times(1)).create(address1);
    }

    @Test
    void testCreateAddress() {
        when(addressService.create(any(Address.class))).thenReturn(address1);

        ResponseEntity<Address> response = addressController.create(address1);

        assertEquals(HttpStatus.OK, response.getStatusCode());  // Assuming create returns HttpStatus.OK
        assertNotNull(response.getBody());
        assertEquals(address1.getAddressId(), response.getBody().getAddressId());
        verify(addressService, times(1)).create(address1);
    }

    @Test
    void testReadAddress_Success() {
        when(addressService.read(1L)).thenReturn(address1);

        ResponseEntity<Address> response = addressController.read(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getAddressId());
        verify(addressService, times(1)).read(1L);
    }

    @Test
    void testReadAddress_NotFound() {
        when(addressService.read(1L)).thenReturn(null);

        ResponseEntity<Address> response = addressController.read(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(addressService, times(1)).read(1L);
    }

    @Test
    void testUpdateAddress_Success() {
        when(addressService.update(any(Address.class))).thenReturn(address1);

        ResponseEntity<Address> response = addressController.update(address1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(address1.getAddressId(), response.getBody().getAddressId());
        verify(addressService, times(1)).update(address1);
    }

    @Test
    void testUpdateAddress_NotFound() {
        when(addressService.update(any(Address.class))).thenReturn(null);

        ResponseEntity<Address> response = addressController.update(address1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(addressService, times(1)).update(address1);
    }

    @Test
    void testGetAllAddresses() {
        when(addressService.getAll()).thenReturn(Arrays.asList(address1, address2));

        ResponseEntity<List<Address>> response = addressController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(addressService, times(1)).getAll();
    }

    @Test
    void testGetAllAddresses_Empty() {
        when(addressService.getAll()).thenReturn(Arrays.asList());

        ResponseEntity<List<Address>> response = addressController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());  // Should return OK even if the list is empty
        assertTrue(response.getBody().isEmpty());
        verify(addressService, times(1)).getAll();
    }
}
