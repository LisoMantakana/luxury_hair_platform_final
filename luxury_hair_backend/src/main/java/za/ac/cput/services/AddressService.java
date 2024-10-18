package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> getall() {
        return repository.findAll();  // Return all addresses as a list
    }

    @Override
    public Address create(Address address) {
        return repository.save(address);  // Save new address
    }

    @Override
    public Address read(Long id) {
        Optional<Address> address = repository.findById(id);
        return address.orElse(null);  // Return address if present
    }

    @Override
    public Address update(Address address) {
        return repository.save(address);  // Update address if exists
    }

    @Override
    public Optional<Address> findByUserId(Long userId) {
        return repository.findByUserId(userId);  // Assuming repository method exists for fetching by userId
    }
}
