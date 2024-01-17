// DateCalendar.jsx
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { dataService } from "../modules/DataService.js"; // Import named export dataService

const DateCalendarComponent = () => {
    const [dateCalendars, setDateCalendars] = useState([]);

    useEffect(() => {
        dataService.getDateCalendars() // Use dataService instead of DataService
            .then((response) => setDateCalendars(response.data))
            .catch((error) => console.error("Error fetching data:", error));
    }, []);

    return (
        <div>
            <h1>Date Calendars</h1>
            <ul>
                {dateCalendars.map((dateCalendar) => (
                    <li key={dateCalendar.id}>
                        <p>ID: {dateCalendar.id}</p>
                        <p>Day: {dateCalendar.day}</p>
                        <p>Month: {dateCalendar.month}</p>
                        <p>Year: {dateCalendar.year}</p>
                        {/* Add other details as needed */}
                    </li>
                ))}
            </ul>
            {/* Add a link to navigate to a specific route */}
            <Link to="/date-calendars/dodaj">Add Date Calendar</Link>
        </div>
    );
};

export default DateCalendarComponent;
