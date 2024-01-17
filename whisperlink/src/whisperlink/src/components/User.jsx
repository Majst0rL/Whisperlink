import React, { useState } from "react";
import { Link } from "react-router-dom";

const User = ({ id: initialId, firstName: initialFirstName, lastName: initialLastName, username: initialUsername, 
  email: initialEmail, birthDate: initialBirthDate, gender: initialGender, userRole: initialUserRole }) => {
  
  const [id, setId] = useState(initialId || "");
  const [firstName, setFirstName] = useState(initialFirstName || "");
  const [lastName, setLastName] = useState(initialLastName || "");
  const [username, setUsername] = useState(initialUsername || "");
  const [email, setEmail] = useState(initialEmail || "");
  const [birthDate, setBirthDate] = useState(initialBirthDate || "");
  const [gender, setGender] = useState(initialGender || "");
  const [userRole, setUserRole] = useState(initialUserRole || "");
  const [posts, setPosts] = useState([]); // Dodajte potrebne podatke

  const handleEditClick = () => {
    // Logika za urejanje uporabnika, če je potrebno
    console.log("Editing user:", id);
  };

  return (
    <div>
      <h1>User Details</h1>
      <p>ID: {id}</p>
      <p>First Name: {firstName}</p>
      <p>Last Name: {lastName}</p>
      <p>Username: {username}</p>
      <p>Email: {email}</p>
      <p>Birth Date: {birthDate}</p>
      <p>Gender: {gender}</p>
      <p>User Role: {userRole}</p>
      {/* Dodajte druge podatke po potrebi */}
      <Link to={`/users/${id}/edit`} onClick={handleEditClick}>
        Edit User
      </Link>
    </div>
  );
};

export default User;
