import React, { useEffect, useState } from "react";
import { dataService } from "../../modules/DataService.js";

const LocationComponent = () => {
    const [locations, setLocations] = useState([]);
    const [id, setId] = useState(0);
    const [address, setAddress] = useState("");
    const [postalCode, setPostalCode] = useState("");
    const [city, setCity] = useState("");
    const [country, setCountry] = useState("");

    useEffect(() => {
        dataService.getLocations() // Use dataService instead of DataService
            .then((response) => setLocations(response.data))
            .catch((error) => console.error("Error fetching data:", error));
    }, []);

    const createLocation = (event) => {
        event.preventDefault();

        const newLocation = {
            address: address,
            postalCode: postalCode,
            city: city,
            country: country
        };

        dataService.createLocation(newLocation);
        document.location.reload();
    }

    const updateLocation = (event) => {
        event.preventDefault();

        const updatedLocation = {
            id: id,
            address: address,
            postalCode: postalCode,
            city: city,
            country: country
        };

        dataService.updateLocation(id, updatedLocation);
        document.location.reload();
    }

    const deleteLocation = (id) => {
        dataService.deleteLocation(id);
        document.location.reload();
    }

    return (
        <div>
            <h1>Locations</h1>
            <form>
                Address: <input type="text" name="address" value={address} onChange={(e) => { setAddress(e.target.value) }} />
                Postal Code: <input type="text" name="postalCode" value={postalCode} onChange={(e) => { setPostalCode(e.target.value) }} />
                City: <input type="text" name="city" value={city} onChange={(e) => { setCity(e.target.value) }} />
                Country: <input type="text" name="country" value={country} onChange={(e) => { setCountry(e.target.value) }} />
                <input type="submit" value="Add" onClick={createLocation} />

                Id: <input type="number" name="id" value={id} onChange={(e) => { setId(e.target.value) }} />
                <input type="submit" value="Update" onClick={updateLocation} />
            </form>

            <hr />

            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Address</th>
                    <th>Postal Code</th>
                    <th>City</th>
                    <th>Country</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {locations.map((location) => (
                    <tr key={location.id}>
                        <td>{location.id}</td>
                        <td>{location.address}</td>
                        <td>{location.postalCode}</td>
                        <td>{location.city}</td>
                        <td>{location.country}</td>
                        <td><button onClick={() => { deleteLocation(location.id) }}>Delete</button></td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default LocationComponent;
