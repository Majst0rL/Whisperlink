// DateCalendar.jsx
import React, { useEffect, useState } from "react";
import { dataService } from "../../modules/DataService.js"; // Import named export dataService

const DateCalendarComponent = () => {
    const [dateCalendars, setDateCalendars] = useState([]);
    const [day, setDay] = useState(0);
    const [month, setMonth] = useState(0);
    const [year, setYear] = useState(0);
    const [id, setId] = useState(0);

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

    const posodobi = (event) => {
        event.preventDefault();

        const newDateCalendar = {
            id: id,
            day: day,
            month: month,
            year: year
        };

        dataService.updateDateCalendar(id, newDateCalendar);
        document.location.reload();
    }

    const izbrisi = (id) => {
        dataService.deleteDateCalendar(id);
        document.location.reload();
    }

    return (
        <div>
            <h1>Date Calendars</h1>
            <form>
                Day: <input type="number" name="day" value={day} onChange={(e) => {setDay(e.target.value)}} />
                Month: <input type="number" name="month" value={month} onChange={(e) => {setMonth(e.target.value)}} />
                Year: <input type="number" name="year" value={year} onChange={(e) => {setYear(e.target.value)}} />
                <input type="submit" value="Dodaj" onClick={ustvari} />

                Id: <input type="number" name="id" value={id} onChange={(e) => {setId(e.target.value)}} />
                <input type="submit" value="Posodobi" onClick={posodobi} />
            </form>

            <hr />

            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Day</th>
                        <th>Month</th>
                        <th>Year</th>
                        <th>Operacija</th>
                    </tr>
                </thead>
                <tbody>
                    {dateCalendars.map((dateCalendar) => (
                        <tr key={dateCalendar.id}>
                            <td>{dateCalendar.id}</td>
                            <td>{dateCalendar.day}</td>
                            <td>{dateCalendar.month}</td>
                            <td>{dateCalendar.year}</td>
                            <td><button onClick={() => {izbrisi(dateCalendar.id)}}>Izbriši</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default DateCalendarComponent;
