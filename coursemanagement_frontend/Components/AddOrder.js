import React, { useState } from "react";

const AddOrder = () => {
  const [userId, setUserId] = useState("");
  const [courseId, setCourseId] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const order = { userId, courseId };

    fetch("http://localhost:8080/orders/place-order", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(order),
    })
      .then((response) => response.json())
      .then((data) => {
        alert("Order placed successfully!");
        setUserId("");
        setCourseId("");
      })
      .catch((error) => console.error("Error placing order:", error));
  };

  return (
    <div className="container mt-4">
      <h2>Place an Order</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">User ID</label>
          <input type="text" className="form-control" value={userId} onChange={(e) => setUserId(e.target.value)} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Course ID</label>
          <input type="text" className="form-control" value={courseId} onChange={(e) => setCourseId(e.target.value)} required />
        </div>
        <button type="submit" className="btn btn-primary">Place Order</button>
      </form>
    </div>
  );
};

export default AddOrder;
