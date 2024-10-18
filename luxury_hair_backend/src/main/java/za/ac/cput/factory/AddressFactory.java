package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.UserLogin;
import za.ac.cput.util.Helper;

public class AddressFactory {
    
    // Modified method to include UserLogin as a parameter
    public static Address buildAdd(Long addressId,UserLogin userLogin, String streetName, String province, String city, int zipCode) {
        // Check for null or empty fields, including userLogin
        if (Helper.isNullOrEmpty(String.valueOf(addressId)) || Helper.isNullOrEmpty(streetName)
                || Helper.isNullOrEmpty(province) || Helper.isNullOrEmpty(city)
                || Helper.isNullOrEmpty(String.valueOf(zipCode)) || userLogin == null) {
            return null; // Return null if any field is invalid
        }

        // Create and return a new Address object using the Builder
        return new Address.Builder()
                .setAddressId(addressId)
                .setStreetName(streetName)
                .setProvince(province)
                .setCity(city)
                .setZipCode(zipCode)
                .setUserLogin(userLogin) // Set the UserLogin (foreign key)
                .build();
    }

    public static Address buildAdd(long addressId, long l, String streetName, String province, String city,
            int zipCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildAdd'");
    }
}
