import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./Components/Navbar";
import Home from "./Components/Home"; 
import GetUserById from "./Components/GetUserById";
import UserList from "./Components/UserList";
import CourseList from "./Components/CourseList";
import AddCourse from "./Components/AddCourse";
import AddUser from "./Components/AddUser";
import EnrollUser from "./Components/EnrollUser";
import GetCourseById from "./Components/GetCourseById";
import Enrollments from "./Components/Enrollments";
import OrderList from "./Components/OrderList";
import AddOrder from "./Components/AddOrder";
import GetOrderById from "./Components/GetOrderById";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/courses" element={<CourseList />} />
        <Route path="/course/add" element={<AddCourse />} />
        <Route path="/users" element={<UserList />} />
        <Route path="/user/add" element={<AddUser />} />
        <Route path="/user/enroll" element={<EnrollUser />} />
        <Route path="/course/get" element={<GetCourseById />} />
        <Route path="/user/get" element={<GetUserById />} />
        <Route path="/enrollments" element={<Enrollments />} />
        {/* Orders Routes */}
        <Route path="/orders" element={<OrderList />} />
        <Route path="/order/add" element={<AddOrder />} />
        <Route path="/order/get" element={<GetOrderById />} />
      </Routes>
    </Router>
  );
}

export default App;
