import React, { useState } from "react";
import { Link } from "react-router-dom";

const Organization = ({ id: initialId, name: initialName, description: initialDescription }) => {
  const [id, setId] = useState(initialId || "");
  const [name, setName] = useState(initialName || "");
  const [description, setDescription] = useState(initialDescription || "");
  const [creation, setCreation] = useState(""); // Dodajte potrebne podatke

  const handleEditClick = () => {
    // Logika za urejanje organizacije, če je potrebno
    console.log("Editing organization:", id);
  };

  return (
    <div>
      <h1>Organization Details</h1>
      <p>ID: {id}</p>
      <p>Name: {name}</p>
      <p>Description: {description}</p>
      {/* Dodajte druge podatke po potrebi */}
      <Link to={`/organizations/${id}/edit`} onClick={handleEditClick}>
        Edit Organization
      </Link>
    </div>
  );
};

export default Organization;
