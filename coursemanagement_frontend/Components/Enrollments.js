import React, { useEffect, useState } from "react";

const Enrollments = () => {
  const [enrollments, setEnrollments] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/users/enrollments")
      .then((response) => response.json())
      .then((data) => {
        setEnrollments(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching enrollments:", error);
        setLoading(false);
      });
  }, []);

  return (
    <div className="container mt-4">
      <h2 className="text-center">Enrolled Users</h2>

      {loading ? (
        <p>Loading...</p>
      ) : enrollments.length === 0 ? (
        <p>No enrollments found.</p>
      ) : (
        <table className="table table-bordered">
          <thead className="table-dark">
            <tr>
              <th>User ID</th>
              <th>User Name</th>
              <th>Email</th>
              <th>Course ID</th>
              <th>Course Name</th>
            </tr>
          </thead>
          <tbody>
            {enrollments.map((enrollment, index) => (
              <tr key={index}>
                <td>{enrollment.userId}</td>
                <td>{enrollment.userName}</td>
                <td>{enrollment.userEmail}</td>
                <td>{enrollment.courseId}</td>
                <td>{enrollment.courseName}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default Enrollments;
