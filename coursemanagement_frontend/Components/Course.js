import React, { useEffect, useState } from "react";
import axios from "axios";
import "./Course.css"; 

function Course() {
    const [courses, setCourses] = useState([]);
    const [courseId, setCourseId] = useState("");
    const [course, setCourse] = useState(null);
    const [newCourse, setNewCourse] = useState({ courseName: "", coursePrice: "", courseCategory: "" });
    const [deleteCourseId, setDeleteCourseId] = useState("");

    useEffect(() => {
        fetchAllCourses();
    }, []);

    // Fetch all courses
    const fetchAllCourses = () => {
        axios.get("http://localhost:8080/courses/get-all-courses")
            .then(response => setCourses(response.data))
            .catch(error => console.error("Error fetching courses:", error));
    };

    // Fetch course by ID
    const fetchCourseById = () => {
        if (!courseId) return;
        axios.get(`http://localhost:8080/courses/get-course/${courseId}`)
            .then(response => setCourse(response.data))
            .catch(error => console.error("Error fetching course by ID:", error));
    };

    // Add new course
    const addCourse = () => {
        axios.post("http://localhost:8080/courses/add-course", newCourse)
            .then(response => {
                alert("Course added successfully!");
                setNewCourse({ courseName: "", coursePrice: "", courseCategory: "" });
                fetchAllCourses();
            })
            .catch(error => console.error("Error adding course:", error));
    };

    // Delete course by ID
    const deleteCourse = () => {
        if (!deleteCourseId) {
            alert("Please enter a Course ID to delete.");
            return;
        }
        axios.delete(`http://localhost:8080/courses/delete-course/${deleteCourseId}`)
            .then(response => {
                alert("Course deleted successfully!");
                setDeleteCourseId("");
                fetchAllCourses();
            })
            .catch(error => console.error("Error deleting course:", error));
    };

    return (
        <div className="course-container">
            <h1>Course Management</h1>

            {/* Get All Courses */}
            <h2>All Courses</h2>
            <ul className="course-list">
                {courses.map((course, index) => (
                    <li key={index} className="course-item">
                        <h3>{course.courseName}</h3>
                        <p>Price: ${course.coursePrice}</p>
                        <p>Category: {course.courseCategory}</p>
                    </li>
                ))}
            </ul>

            {/* Get Course By ID */}
            <div className="get-course">
                <h2>Get Course by ID</h2>
                <input
                    type="number"
                    value={courseId}
                    onChange={(e) => setCourseId(e.target.value)}
                    placeholder="Enter Course ID"
                />
                <button onClick={fetchCourseById}>Get Course</button>
                {course && (
                    <div className="course-details">
                        <h3>{course.courseName}</h3>
                        <p>Price: ${course.coursePrice}</p>
                        <p>Category: {course.courseCategory}</p>
                    </div>
                )}
            </div>

            {/* Add Course */}
            <div className="add-course">
                <h2>Add a Course</h2>
                <input
                    type="text"
                    placeholder="Course Name"
                    value={newCourse.courseName}
                    onChange={(e) => setNewCourse({ ...newCourse, courseName: e.target.value })}
                />
                <input
                    type="number"
                    placeholder="Course Price"
                    value={newCourse.coursePrice}
                    onChange={(e) => setNewCourse({ ...newCourse, coursePrice: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Course Category"
                    value={newCourse.courseCategory}
                    onChange={(e) => setNewCourse({ ...newCourse, courseCategory: e.target.value })}
                />
                <button onClick={addCourse}>Add Course</button>
            </div>

            {/* Delete Course */}
            <div className="delete-course">
                <h2>Delete a Course</h2>
                <input
                    type="number"
                    placeholder="Enter Course ID"
                    value={deleteCourseId}
                    onChange={(e) => setDeleteCourseId(e.target.value)}
                />
                <button onClick={deleteCourse}>Delete Course</button>
            </div>
        </div>
    );
}

export default Course;
