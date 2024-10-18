package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.services.IAddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:1573")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    // Create new address
    @PostMapping("/create")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        Address newAddress = addressService.create(address);
        return ResponseEntity.status(201).body(newAddress);
    }

    // Get address by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> read(@PathVariable Long id) {
        Address address = addressService.read(id);
        return address != null ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
    }

    // Update an existing address
    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody Address address) {
        Address updatedAddress = addressService.update(address);
        return updatedAddress != null ? ResponseEntity.ok(updatedAddress) : ResponseEntity.notFound().build();
    }

    // Get all addresses (this is where the error was, now fixed)
    @GetMapping("/getall")
    public ResponseEntity<List<Address>> getAll() {
        List<Address> addresses = addressService.getall();
        return !addresses.isEmpty() ? ResponseEntity.ok(addresses) : ResponseEntity.noContent().build();  // Return list or no content
    }

    // Fetch an address by user ID
    @GetMapping("/user_login/{userId}")
    public ResponseEntity<Address> getAddressByUserId(@PathVariable Long userId) {
        Optional<Address> address = addressService.findByUserId(userId);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


