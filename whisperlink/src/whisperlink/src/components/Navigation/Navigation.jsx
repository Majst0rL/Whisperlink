
import React from "react";

export default function Navigation({ role }) {
  return (
    <nav>
        <a href="/">Home</a>
        <a href="genders">Genders</a>
        <a href="/date-calendars">Date Calendars</a>
        <a href="/locations/:id">Locations</a>
        <a href="/organizations/:id">Organizations</a>
        <a href="/posts/:id">Posts</a>
        <a href="/time-planners/:id">Time Planners</a>
        <a href="/users/:id">Users</a>
        <a href="/user-roles/:role">User Roles</a>
    </nav>
  );
};
