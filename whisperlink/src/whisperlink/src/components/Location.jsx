import React, { useState } from "react";
import { Link } from "react-router-dom";

const Location = ({ id, initialAddress, initialCity, initialCountry }) => {
  const [address, setAddress] = useState(initialAddress || "");
  const [city, setCity] = useState(initialCity || "");
  const [country, setCountry] = useState(initialCountry || "");
  const [postalCode, setPostalCode] = useState(""); // Dodajte potrebne podatke

  const handleEditClick = () => {
    // Logika za urejanje lokacije, če je potrebno
    console.log("Editing location:", id);
  };

  return (
    <div>
      <h1>Location Details</h1>
      <p>ID: {id}</p>
      <p>Address: {address}</p>
      <p>City: {city}</p>
      <p>Country: {country}</p>
      {/* Dodajte druge podatke po potrebi */}
      <Link to={`/locations/${id}/edit`} onClick={handleEditClick}>
        Edit Location
      </Link>
    </div>
  );
};

export default Location;
