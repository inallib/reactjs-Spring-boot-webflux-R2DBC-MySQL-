import React, {Fragment} from 'react';
import {SubHeader} from './SubHeader'
import {ListOfCourse} from './ListOfCourses'

export const Courses = () => {
    return (
      <Fragment>
        <SubHeader/>
        <ListOfCourse/>
      </Fragment>
    )
}