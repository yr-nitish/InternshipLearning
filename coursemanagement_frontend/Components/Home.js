import React from "react";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="container text-center mt-5">
      <h1 className="display-4">Welcome to Course Management</h1>
      <p className="lead">
        Manage users, courses, and enrollments with ease.
      </p>
      <div className="d-flex justify-content-center mt-4 gap-3">
        <Link to="/courses" className="btn btn-primary btn-lg">
          View Courses
        </Link>
        <Link to="/users" className="btn btn-success btn-lg">
          View Users
        </Link>
        <Link to="/enrollments" className="btn btn-info btn-lg">
          View Enrollments
        </Link>
      </div>
    </div>
  );
};

export default Home;
