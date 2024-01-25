// DateCalendar.jsx
import React, { useEffect, useState } from "react";
import { dataService } from "../../modules/DataService.js"; // Import named export dataService

const DateCalendarComponent = () => {
    const [dateCalendars, setDateCalendars] = useState([]);
    const [day, setDay] = useState(0);
    const [month, setMonth] = useState(0);
    const [year, setYear] = useState(0);

    useEffect(() => {
        dataService.getDateCalendars() // Use dataService instead of DataService
            .then((response) => setDateCalendars(response.data))
            .catch((error) => console.error("Error fetching data:", error));
    }, []);

    const ustvari = (event) => {
        event.preventDefault();

        const newDateCalendar = {
            day: day,
            month: month,
            year: year
        };
        
        dataService.createDateCalendar(newDateCalendar);
        document.location.reload();
    }

    return (
        <div>
            <h1>Date Calendars</h1>
            <form onSubmit={ustvari}>
                Day: <input type="number" name="day" value={day} onChange={(e) => {setDay(e.target.value)}} />
                Month: <input type="number" name="month" value={month} onChange={(e) => {setMonth(e.target.value)}} />
                Year: <input type="number" name="year" value={year} onChange={(e) => {setYear(e.target.value)}} />
                <input type="submit" value="Dodaj" />
            </form>

            <hr />

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
            
        </div>
    );
};

export default DateCalendarComponent;
