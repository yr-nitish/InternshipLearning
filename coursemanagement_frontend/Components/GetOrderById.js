import React, { useState } from "react";

const GetOrderById = () => {
  const [orderId, setOrderId] = useState("");
  const [order, setOrder] = useState(null);
  const [error, setError] = useState("");

  const handleSearch = () => {
    if (!orderId.trim()) {
      setError("Please enter an Order ID.");
      setOrder(null);
      return;
    }

    fetch(`http://localhost:8080/orders/get-order/${orderId}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Order not found.");
        }
        return response.json();
      })
      .then((data) => {
        setOrder(data);
        setError("");
      })
      .catch((error) => {
        setError(error.message);
        setOrder(null);
      });
  };

  return (
    <div className="container mt-4">
      <h2>Get Order by ID</h2>
      <div className="mb-3">
        <label className="form-label">Enter Order ID:</label>
        <input
          type="text"
          className="form-control"
          value={orderId}
          onChange={(e) => setOrderId(e.target.value)}
          required
        />
      </div>
      <button className="btn btn-primary" onClick={handleSearch}>
        Fetch Order
      </button>

      {error && <p className="text-danger mt-3">{error}</p>}

      {order && (
        <div className="mt-4">
          <h4>Order Details</h4>
          <ul className="list-group">
            <li className="list-group-item"><strong>Order ID:</strong> {order.orderId}</li>
            <li className="list-group-item"><strong>Created At:</strong> {order.createdAt}</li>
            <li className="list-group-item"><strong>User ID:</strong> {order.userId}</li>
            <li className="list-group-item"><strong>Course ID:</strong> {order.courseId}</li>
          </ul>
        </div>
      )}
    </div>
  );
};

export default GetOrderById;