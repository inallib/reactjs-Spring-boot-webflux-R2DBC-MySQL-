import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {AppHeader} from './common/header/AppHeader';
import {Home} from './home/Home';
import {Courses} from './courses/Courses';
import {ManageCourses} from './courses/ManageCourses';

import {About} from './about/About';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import Container from 'react-bootstrap/Container'
import {Provider as AlertProvider} from 'react-alert'
import AlertTemplate from 'react-alert-template-basic'

const options = {
  position: 'top right',
  timeout: 5000,
  offset: '30px',
  transition: 'scale'
}

export const AppContent = () => {
  return (
    <AlertProvider template={AlertTemplate} {...options}>
    <Container>
      <Row>
        <Col xs={6}>
          <AppHeader />
          <Switch>
            <Route exact path="/" component={Home} />
            <Route exact path="/courses" component={Courses} />
            <Route exact path="/about" component={About} />
            <Route exact path="/manage" component={ManageCourses} />
          </Switch>
        </Col>
      </Row>
    </Container>
    </AlertProvider>
  )
}