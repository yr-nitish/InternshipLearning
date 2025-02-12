import React, { useState } from "react";
import axios from "../api";

const AddUser = () => {
  const [userData, setUserData] = useState({
    userName: "",
    userEmail: "",
  });

  const handleChange = (e) => {
    setUserData({ ...userData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("/users/add-user", userData)
      .then(() => alert("User added successfully!"))
      .catch((error) => console.error("Error adding user:", error));
  };

  return (
    <div className="container mt-4">
      <div className="card p-4 shadow-lg">
        <h2 className="text-center mb-4">Add New User</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">User Name</label>
            <input 
              type="text" 
              name="userName" 
              className="form-control"
              placeholder="Enter User Name" 
              onChange={handleChange} 
              required 
            />
          </div>

          <div className="mb-3">
            <label className="form-label">User Email</label>
            <input 
              type="email" 
              name="userEmail" 
              className="form-control"
              placeholder="Enter User Email" 
              onChange={handleChange} 
              required 
            />
          </div>

          <button type="submit" className="btn btn-primary w-100">
            Add User
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddUser;
