import React, {Fragment, useEffect, useState} from 'react';
import Button from 'react-bootstrap/Button'
import Form from 'react-bootstrap/Form'
import {Link} from 'react-router-dom'
import {fetchAuthors, saveCourse} from "../../apiClients/ManageCoursesClient";
import {useAlert} from 'react-alert'


export const ManageCourses = (props) => {
  const [authors, setAuthors] = useState([]);
  const [id, setId] = useState();
  const [title, setTitle] = useState();
  const [authorId, setAuthorId] = useState();
  const [authorName, setAuthorName] = useState();
  const [category, setCategory] = useState();
  const [authorNameLoaded, setAuthorNameLoaded] = useState(true);
  const [loadedForEdit, setLoadedForEdit] = useState(true);
  const alert = useAlert()

  function handleSubmit() {
    const course = Object.assign({}, {id, title, authorId, category})
    saveCourse(course).then(data => {
      alert.show('Course saved')
      setTitle("")
      setCategory("")
    })
  }

  function getAuthorID(value) {
    let author = authors.find(o => o.name === value)
    if (author){
      setAuthorName(value)
      return authors.find(o => o.name === value).id
    }
    return 0
  }

  useEffect(() => {
    initialLoad()
    loadDataForEdit()
    loadAuthorName()
  })

  function loadAuthorName() {
    if (authors && props.location.course && authorNameLoaded) {
      let author = authors.find(o => o.id === authorId)
      if (author) {
        setAuthorNameLoaded(false)
        setAuthorName(authors.find(o => o.id === authorId).name)
      }
      return 0
    }
  }

  function initialLoad() {
    if (authors.length < 1) {
      fetchAuthors().then(data => {
        setAuthors(data)
      })
    }
  }

  function loadDataForEdit() {
    if (props.location.course && loadedForEdit){
      setId(props.location.course.id)
      setTitle(props.location.course.title)
      setAuthorId(props.location.course.authorId)
      setCategory(props.location.course.category)
      setLoadedForEdit(false)
    }
  }
  const authorNames = authors.map(author => (
    <option>{author.name}</option>
  ));

  return (
    <Fragment>
      <h2>Manage Courses</h2>
      <Form >
        <Form.Group controlId="title">
          <Form.Label>Title</Form.Label>
          <Form.Control required type="text" value={title} placeholder="Enter title" onChange={e => setTitle(e.target.value)} />
        </Form.Group>
        <Form.Group controlId="author">
          <Form.Label>Author</Form.Label>
          <Form.Control as="select" value={authorName} onChange={e => setAuthorId(getAuthorID(e.target.value))} >
            <option>Select author</option>
            {authorNames}
          </Form.Control>
        </Form.Group>
        <Form.Group controlId="category">
          <Form.Label>Category</Form.Label>
          <Form.Control required type="text" placeholder="Enter Category" value={category} onChange={e => setCategory(e.target.value)} />
        </Form.Group>
        <hr/>
        <Button variant="primary" type="button" onClick={handleSubmit}>
          Save
        </Button>
        &nbsp;&nbsp;
        <Link to="/courses">
          <Button variant="success">Go to course list</Button>
        </Link>
      </Form>
    </Fragment>
  )
}