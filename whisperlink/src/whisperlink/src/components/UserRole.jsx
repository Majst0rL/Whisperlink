
import React from "react";
import { Link } from "react-router-dom";

const UserRole = ({ role }) => {
  return (
    <div>
      <h1>User Role Details</h1>
      <p>Role: {role}</p>
      {/* Add other details as needed */}
      <Link to={`/user-roles/${role}/edit`}>Edit User Role</Link>
    </div>
  );
};

export default UserRole;
