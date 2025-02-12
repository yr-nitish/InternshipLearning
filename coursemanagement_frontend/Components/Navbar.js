import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg" style={{ backgroundColor: "rgb(29, 30, 39)" }}>
      <div className="container">
        <Link className="navbar-brand text-light" to="/">
          Home
        </Link>
        <button
          className="navbar-toggler border-light"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" style={{ filter: "invert(1)" }}></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">

            {/* Courses Dropdown */}
            <li className="nav-item dropdown">
              <a
                className="nav-link dropdown-toggle text-white"
                href="#"
                id="courseDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Courses
              </a>
              <ul className="dropdown-menu custom-dropdown" aria-labelledby="courseDropdown">
                <li><Link className="dropdown-item" to="/courses">Get All Courses</Link></li>
                <li><Link className="dropdown-item" to="/course/add">Add Course</Link></li>
                <li><Link className="dropdown-item" to="/course/get">Get Course by ID</Link></li>
              </ul>
            </li>

            {/* Users Dropdown */}
            <li className="nav-item dropdown">
              <a
                className="nav-link dropdown-toggle text-white"
                href="#"
                id="userDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Users
              </a>
              <ul className="dropdown-menu custom-dropdown" aria-labelledby="userDropdown">
                <li><Link className="dropdown-item" to="/users">Get All Users</Link></li>
                <li><Link className="dropdown-item" to="/user/add">Add User</Link></li>
                <li><Link className="dropdown-item" to="/user/get">Get User by ID</Link></li>
                <li><Link className="dropdown-item" to="/user/enroll">Enroll User</Link></li>
              </ul>
            </li>

            {/* Orders Dropdown */}
            <li className="nav-item dropdown">
              <a
                className="nav-link dropdown-toggle text-white"
                href="#"
                id="orderDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Orders
              </a>
              <ul className="dropdown-menu custom-dropdown" aria-labelledby="orderDropdown">
                <li><Link className="dropdown-item" to="/orders">Get All Orders</Link></li>
                <li><Link className="dropdown-item" to="/order/add">Place Order</Link></li>
                <li><Link className="dropdown-item" to="/order/get">Get Order by ID</Link></li>
              </ul>
            </li>

            {/* Enrollments Button */}
            <li className="nav-item">
              <Link className="nav-link text-white" to="/enrollments">
                Enrollments
              </Link>
            </li>

          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
