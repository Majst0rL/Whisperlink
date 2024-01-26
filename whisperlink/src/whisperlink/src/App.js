import React from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Gender from "./components/Gender.jsx";
import DateCalendar from "./components/DateCalendar/DateCalendar.jsx";
import Location from "./components/Location/Location.jsx";
import Organization from "./components/Organization.jsx";
import Post from "./components/Post.jsx";
import TimePlanner from "./components/TimePlanner.jsx";
import User from "./components/User.jsx";
import UserRole from "./components/UserRole.jsx";
import Navigation from "./components/Navigation/Navigation.jsx";
import Home from "./components/Home/Home.jsx";

const App = () => {
  return (
    <div>
      <Navigation />
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/genders" element={<Gender type="MALE" />} />
          <Route path="/date-calendars" element={<DateCalendar />} />
          <Route path="/locations/:id" element={<Location />} />
          <Route path="/organizations/:id" element={<Organization />} />
          <Route path="/posts/:id" element={<Post />} />
          <Route path="/time-planners/:id" element={<TimePlanner />} />
          <Route path="/users/:id" element={<User />} />
          <Route path="/user-roles/:role" element={<UserRole />} />

          {/* Add other routes as needed */}
        </Routes>
      </Router>
    </div>
  );
};

export default App;
