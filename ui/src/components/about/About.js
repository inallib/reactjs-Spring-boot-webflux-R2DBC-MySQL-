import React, {Fragment} from 'react';

import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import Container from 'react-bootstrap/Container'

export const About = () => {
  return (
    <Fragment>
    <Container>
      <Row>
        <Col xs={6}>
          Contact the developer at inallib@gmail.com
        </Col>
      </Row>
    </Container>
    </Fragment>
  )
}