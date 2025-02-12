import React, { useState } from "react";
import axios from "axios";

const GetUserById = () => {
  const [userId, setUserId] = useState("");
  const [user, setUser] = useState(null);
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setUserId(e.target.value);
    setError(""); // Clear previous errors
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!userId.trim()) {
      setError("Please enter a User ID.");
      setUser(null);
      return;
    }

    try {
      const response = await axios.get(`http://localhost:8080/users/get-user/${userId}`);

      console.log("API Response:", response.data); // Debugging

      if (response.data && response.data.userId) {
        setUser(response.data);
        setError("");
      } else {
        setUser(null);
        setError("No user found with this ID.");
      }
    } catch (err) {
      console.error("Error fetching user:", err); // Debugging
      setUser(null);
      setError("Error fetching user. Please check the ID and try again.");
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Get User by ID</h2>

      <form onSubmit={handleSubmit} className="card p-4 shadow">
        <div className="mb-3">
          <label className="form-label">User ID</label>
          <input
            type="number"
            className="form-control"
            value={userId}
            onChange={handleChange}
            required
            placeholder="Enter User ID"
          />
        </div>
        <button type="submit" className="btn btn-primary w-100">Fetch User</button>
      </form>

      {error && <div className="alert alert-danger mt-3">{error}</div>}

      {user && (
        <div className="card mt-4 shadow">
          <div className="card-body">
            <h5 className="card-title">User Details</h5>
            <p><strong>ID:</strong> {user.userId}</p>
            <p><strong>Name:</strong> {user.userName}</p>
            <p><strong>Email:</strong> {user.userEmail}</p>
          </div>
        </div>
      )}
    </div>
  );
};

export default GetUserById;