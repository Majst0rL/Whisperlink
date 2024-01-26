import React, { useState } from 'react';

const LocationForm = ({ onAddLocation }) => {
    const [address, setAddress] = useState('');
    const [city, setCity] = useState('');
    const [country, setCountry] = useState('');
    const [postalCode, setPostalCode] = useState('');

    const handleAddLocation = () => {
        // Validate input if needed

        // Create a new location object
        const newLocation = {
            address,
            city,
            country,
            postalCode,
        };

        // Call the onAddLocation function from the parent component
        onAddLocation(newLocation);

        // Reset form fields
        setAddress('');
        setCity('');
        setCountry('');
        setPostalCode('');
    };

    return (
        <div>
            <h2>Add Location</h2>
            <label>
                Address:
                <input type="text" value={address} onChange={(e) => setAddress(e.target.value)} />
            </label>
            <br />
            <label>
                City:
                <input type="text" value={city} onChange={(e) => setCity(e.target.value)} />
            </label>
            <br />
            <label>
                Country:
                <input type="text" value={country} onChange={(e) => setCountry(e.target.value)} />
            </label>
            <br />
            <label>
                Postal Code:
                <input type="text" value={postalCode} onChange={(e) => setPostalCode(e.target.value)} />
            </label>
            <br />
            <button onClick={handleAddLocation}>Add Location</button>
        </div>
    );
};

export default LocationForm;
