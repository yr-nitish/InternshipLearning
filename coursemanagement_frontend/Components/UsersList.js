import React, { useEffect, useState } from "react";
import axios from "axios";
import "./UsersList.css";

function UsersList() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/users")
            .then(response => {
                console.log(response);
                setUsers(response.data);
            })
            .catch(error => console.error("Error fetching users:", error));
    }, []);

    return (
        <div className="users-container">
            <h1>Users List</h1>
            <ul className="users-list">
                {users.length > 0 ? (
                    users.map((user, index) => (
                        <li key={index} className="user-item">
                            <h2>{user.userName}</h2>
                            <h4>Email: {user.userEmail}</h4>
                            <h4>User ID: {user.userId}</h4>
                        </li>
                    ))
                ) : (
                    <p className="loading-message">Loading users...</p>
                )}
            </ul>
        </div>
    );
}

export default UsersList;
