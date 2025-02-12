import React, { useState } from "react";
import axios from "axios";
import { useEffect } from "react";

const GetCourseById = () => {
  const [courseId, setCourseId] = useState("");
  const [course, setCourse] = useState(null);
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setCourseId(e.target.value);
    setError("");
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!courseId.trim()) {
      setError("Please enter a Course ID.");
      setCourse(null);
      return;
    }

    try {
      const response = await axios.get(`http://localhost:8080/courses/get-course/${courseId}`);

      console.log("API Response:", response.data); // Debugging for checking if there is any error

      if (response.data) {
        setCourse(response.data);
        setError("");
      } else {
        setCourse(null);
        setError("No course found with this ID.");
      }

    } catch (err) {
      console.error("Error fetching course:", err); // Debugging for checking the errron if any
      setCourse(null);
      setError("Error fetching course. Please check the ID and try again.");
    }
  };
  return (
    <div className="container mt-4">
      <h2>Get Course by ID</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Course ID</label>
          <input
            type="number"
            className="form-control"
            value={courseId}
            onChange={handleChange}
            required
            placeholder="Enter Course ID"
          />
        </div>
        <button type="submit" className="btn btn-primary">Fetch Course</button>
      </form>

      {error && <div className="alert alert-danger mt-3">{error}</div>}

      {course && (
        <div className="card mt-4">
          <div className="card-body">
            <h5 className="card-title">Course Details</h5>
            <p><strong>ID:</strong> {course.courseId}</p>
            <p><strong>Name:</strong> {course.courseName}</p>
            <p><strong>Description:</strong> {course.coursePrice}</p>
          </div>
        </div>
      )}
    </div>
  );
};

export default GetCourseById;
