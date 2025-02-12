import React, { useState, useEffect } from "react";
import axios from "../api";

const CourseList = () => {
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios
      .get("/courses/get-all-courses")
      .then((response) => {
        setCourses(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching courses:", error);
        setLoading(false);
      });
  }, []);

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">All Courses</h2>

      {loading ? (
        <div className="text-center">
          <div className="spinner-border text-primary" role="status">
            <span className="visually-hidden">Loading...</span>
          </div>
          <p>Loading courses...</p>
        </div>
      ) : courses.length === 0 ? (
        <div className="alert alert-warning text-center">No courses found.</div>
      ) : (
        <div className="row">
          {courses.map((course) => (
            <div key={course.courseId} className="col-md-4 mb-4">
              <div className="card shadow-sm">
                <div className="card-body text-center">
                  <h5 className="card-title">{course.courseName}</h5>
                  <p className="card-text">
                    <strong>Price:</strong> ${course.coursePrice}
                  </p>
                </div>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default CourseList;
