import React from 'react';
import Nav from 'react-bootstrap/Nav'

export const AppHeader = () => {
  return (
    <h6>
    <Nav defaultActiveKey="/" as="hl">
      <Nav.Item>
        <Nav.Link href="/">Home </Nav.Link>
         |
        <Nav.Link href="/courses" eventKey="link-1"> Courses </Nav.Link>
         |
        <Nav.Link href="/about" eventKey="link-1"> About </Nav.Link>
      </Nav.Item>
    </Nav>
    </h6>
  )
}