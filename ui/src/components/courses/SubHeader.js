import React, {Fragment} from 'react';
import Button from 'react-bootstrap/Button'
import {Link} from 'react-router-dom';

export const SubHeader = () => {
  return (
    <Fragment>
      <h2>Courses</h2>
      <Link to="/manage">
        <Button variant="success">Add course</Button>
      </Link>
      <hr/>
      <br/>
    </Fragment>
  )
}