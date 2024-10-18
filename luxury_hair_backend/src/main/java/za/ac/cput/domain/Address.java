package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String streetName;
    private String province;
    private String city;
    private int zipCode;

    // Many Addresses can belong to one UserLogin
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Specify the foreign key column
    private UserLogin userLogin; // Foreign key relationship to UserLogin

    public Address() {
    }

    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.streetName = builder.streetName;
        this.province = builder.province;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
        this.userLogin = builder.userLogin; // Set the userLogin
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public UserLogin getUserLogin() {
        return userLogin; // Getter for UserLogin (userId)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return zipCode == address.zipCode &&
                Objects.equals(addressId, address.addressId) &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(province, address.province) &&
                Objects.equals(city, address.city) &&
                Objects.equals(userLogin, address.userLogin); // Include userLogin in equals
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, streetName, province, city, zipCode, userLogin); // Include userLogin in hashCode
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetName='" + streetName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", userLogin=" + userLogin + // Include userLogin in toString
                '}';
    }

    public static class Builder {
        private Long addressId;
        private String streetName;
        private String province;
        private String city;
        private int zipCode;
        private UserLogin userLogin; // Add userLogin to the builder

        public Builder setAddressId(Long addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setZipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setUserLogin(UserLogin userLogin) { // Setter for UserLogin
            this.userLogin = userLogin;
            return this;
        }

        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.streetName = address.streetName;
            this.province = address.province;
            this.city = address.city;
            this.zipCode = address.zipCode;
            this.userLogin = address.userLogin; // Copy userLogin
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
