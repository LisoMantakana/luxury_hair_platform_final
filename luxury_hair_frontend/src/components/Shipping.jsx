import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

const ShippingPage = () => {
    const [street, setStreet] = useState("");
    const [city, setCity] = useState("");
    const [province, setProvince] = useState("");
    const [zipCode, setZipCode] = useState("");
    const [addressId, setAddressId] = useState(null); 
    const navigate = useNavigate();
    const userId = 1; 

    useEffect(() => {
        console.log("UserId:", userId); 
      
        const fetchAddress = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/LuxuryHairVendingSystemDB/address/user_login/${userId}`);
                if (response.data) {
                    const { streetName, city, province, zipCode, addressId } = response.data;
                    setStreet(streetName);
                    setCity(city);
                    setProvince(province);
                    setZipCode(zipCode);
                    setAddressId(addressId);
                }
            } catch (error) {
    
                console.error("Error fetching the user's address:", error.message);
                console.error("Axios error config:", error.config);
                console.error("Axios error request:", error.request);
                console.error("Axios error response:", error.response);
            }
        };
       
        
        fetchAddress();
    }, [userId]);

    const handleSubmit = async () => {
        try {
            const data = {
                streetName: street,
                city,
                province,
                zipCode,
            };

            if (addressId) {
              
                await axios.put(`http://localhost:8080/LuxuryHairVendingSystemDB/address/update/${addressId}`, data);
                alert("Address updated successfully!");
            } else {
               
                await axios.post('http://localhost:8080/LuxuryHairVendingSystemDB/address/create', data);
                alert("Shipping details submitted successfully!");
            }

            navigate("/checkout");
        } catch (error) {
            console.error("Error submitting shipping details:", error);
            alert("Failed to submit shipping details.");
        }
    };

    return (
        <>
            <Navbar />
            <div
                style={{
                    maxWidth: "650px",
                    margin: "20px auto",
                    padding: "20px",
                    backgroundColor: "#f7f7f7",
                    color: "#000",
                    border: "1px solid #000",
                    borderRadius: "10px",
                }}
            >
                <div style={{ marginBottom: "20px" }}>
                    <h3>{addressId ? "Edit Shipping Address" : "Shipping Address"}</h3>
                    <div style={{ display: "flex", gap: "10px" }}>
                        <label style={{ flex: 1 }}>
                            Street:
                            <input
                                type="text"
                                value={street}
                                onChange={(e) => setStreet(e.target.value)}
                                placeholder="Street address"
                                style={{
                                    width: "100%",
                                    padding: "8px",
                                    marginTop: "8px",
                                    border: "1px solid #000",
                                    borderRadius: "4px",
                                }}
                            />
                        </label>
                        <label style={{ flex: 1 }}>
                            City:
                            <input
                                type="text"
                                value={city}
                                onChange={(e) => setCity(e.target.value)}
                                placeholder="City"
                                style={{
                                    width: "100%",
                                    padding: "8px",
                                    marginTop: "8px",
                                    border: "1px solid #000",
                                    borderRadius: "4px",
                                }}
                            />
                        </label>
                    </div>
                    <div style={{ display: "flex", gap: "10px", marginTop: "10px" }}>
                        <label style={{ flex: 1 }}>
                            Province:
                            <input
                                type="text"
                                value={province}
                                onChange={(e) => setProvince(e.target.value)}
                                placeholder="Province"
                                style={{
                                    width: "100%",
                                    padding: "8px",
                                    border: "1px solid #000",
                                    borderRadius: "4px",
                                }}
                            />
                        </label>
                        <label style={{ flex: 1 }}>
                            Zip Code:
                            <input
                                type="text"
                                value={zipCode}
                                onChange={(e) => setZipCode(e.target.value)}
                                placeholder="Zip Code"
                                style={{
                                    width: "100%",
                                    padding: "8px",
                                    border: "1px solid #000",
                                    borderRadius: "4px",
                                }}
                            />
                        </label>
                    </div>
                </div>
                <div style={{ marginBottom: "20px" }}>
                    <div style={{ display: "flex", gap: "10px", marginTop: "10px" }}>
                        <button
                            onClick={handleSubmit}
                            style={{
                                flex: 1,
                                padding: "10px",
                                backgroundColor: "#000",
                                color: "white",
                                border: "none",
                                borderRadius: "4px",
                            }}
                        >
                            {addressId ? "Update Address" : "Checkout"}
                        </button>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
};

export default ShippingPage;
