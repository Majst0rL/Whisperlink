import React, { useState } from "react";
import { Link } from "react-router-dom";
import { dataService } from "../modules/DataService";

const Location = ({ id, initialAddress, initialCity, initialCountry }) => {
  const [address, setAddress] = useState(initialAddress || "");
  const [city, setCity] = useState(initialCity || "");
  const [country, setCountry] = useState(initialCountry || "");
  const [postalCode, setPostalCode] = useState(""); // Dodajte potrebne podatke

  const handleEditClick = () => {
    // Logika za urejanje lokacije, če je potrebno
    console.log("Editing location:", id);
  };

  const addLocation = () => {
    const lokacija = {
      address: "Nekaj",

    }
    dataService.createLocation(lokacija);
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

      <br />
      <button onClick={addLocation}>Dodaj lokacijo</button>
    </div>
  );
};

export default Location;
