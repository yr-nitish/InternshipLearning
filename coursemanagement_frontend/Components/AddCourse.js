import React, { useState } from "react";
import axios from "../api";

const AddCourse = () => {
  const [courseData, setCourseData] = useState({
    courseName: "",
    coursePrice: "",
    courseCategory: "",
  });

  const handleChange = (e) => {
    setCourseData({ ...courseData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("/courses/add-course", courseData)
      .then(() => alert("Course added successfully!"))
      .catch((error) => console.error("Error adding course:", error));
  };

  return (
    <div className="container mt-4">
      <div className="card p-4 shadow-lg">
        <h2 className="text-center mb-4">Add New Course</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Course Name</label>
            <input 
              type="text" 
              name="courseName" 
              className="form-control"
              placeholder="Enter Course Name" 
              onChange={handleChange} 
              required 
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Course Price</label>
            <input 
              type="number" 
              name="coursePrice" 
              className="form-control"
              placeholder="Enter Course Price" 
              onChange={handleChange} 
              required 
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Category</label>
            <input 
              type="text" 
              name="courseCategory" 
              className="form-control"
              placeholder="Enter Course Category" 
              onChange={handleChange} 
              required 
            />
          </div>

          <button type="submit" className="btn btn-primary w-100">
            Add Course
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddCourse;
