import React, { useState } from "react";
import axios from "../api";

const EnrollUser = () => {
  const [data, setData] = useState({ userId: "", courseId: "" });

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("/users/enroll", data)
      .then(() => alert("User enrolled successfully!"))
      .catch((error) => console.error("Error enrolling user:", error));
  };

  return (
    <div className="container mt-4">
      <div className="card p-4 shadow-lg">
        <h2 className="text-center mb-4">Enroll User in Course</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">User ID</label>
            <input 
              type="number" 
              name="userId" 
              className="form-control"
              placeholder="Enter User ID" 
              onChange={handleChange} 
              required 
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Course ID</label>
            <input 
              type="number" 
              name="courseId" 
              className="form-control"
              placeholder="Enter Course ID" 
              onChange={handleChange} 
              required 
            />
          </div>

          <button type="submit" className="btn btn-success w-100">
            Enroll User
          </button>
        </form>
      </div>
    </div>
  );
};

export default EnrollUser;
