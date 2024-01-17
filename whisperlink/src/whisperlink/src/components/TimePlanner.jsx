import React, { useState } from "react";
import { Link } from "react-router-dom";

const TimePlanner = ({ id: initialId, date: initialDate, location: initialLocation, name: initialName }) => {
  const [id, setId] = useState(initialId || "");
  const [date, setDate] = useState(initialDate || "");
  const [location, setLocation] = useState(initialLocation || "");
  const [name, setName] = useState(initialName || "");

  const handleEditClick = () => {
    // Logika za urejanje načrtovalca časa, če je potrebno
    console.log("Editing time planner:", id);
  };

  return (
    <div>
      <h1>Time Planner Details</h1>
      <p>ID: {id}</p>
      <p>Date: {date}</p>
      <p>Location: {location}</p>
      <p>Name: {name}</p>
      {/* Dodajte druge podatke po potrebi */}
      <Link to={`/time-planners/${id}/edit`} onClick={handleEditClick}>
        Edit Time Planner
      </Link>
    </div>
  );
};

export default TimePlanner;
