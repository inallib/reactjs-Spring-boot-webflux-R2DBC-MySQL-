import React, {Fragment, useEffect, useState} from 'react';
import Table from 'react-bootstrap/Table'
import {deleteCourse, fetchAllCourses} from "../../apiClients/CoursesClient";
import {useAlert} from 'react-alert'
import Button from 'react-bootstrap/Button'
import {Link} from 'react-router-dom';


export const ListOfCourse = () => {
  const [courses, setCourses] = useState([]);
  const [loadingRequired, setLoadingRequired] = useState(true);

  const alert = useAlert()
  const fetchCourses = () => {
    fetchAllCourses().then(data => {
      if (data.error)
        alert.show('Course could not be loded!')
      else {
        setLoadingRequired(false)
        setCourses(data)
      }
    })
  }

  useEffect(() => {
    if (loadingRequired === true) {
      fetchCourses()
    }
  })

  const handleDelete = (id) => {
    deleteCourse(id).then(res => {
        setLoadingRequired(true)
        alert.show('Course deleted')
    })
  }

  const courseList = courses.map(course => (
    <tr>
      <td>
        <Button variant="danger" type="button" onClick={() => handleDelete(course.id)}>
          Delete
        </Button>
      </td>
      <td  colSpan="4"><Link id={course.title} to={{pathname: "/manage", course: course}} >{course.title}</Link></td>
      <td>{course.authorId}</td>
      <td>{course.category}</td>
    </tr>
  ));

  return(
    <Fragment>
      <Table responsive="lg">
        <thead>
        <tr>
          <th>Action</th>
          <th colSpan="4">Title</th>
          <th>Author ID</th>
          <th>Category</th>
        </tr>
        </thead>
        <tbody>
          {courseList}
        </tbody>
      </Table>
    </Fragment>
  )
}