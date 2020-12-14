import React from 'react';
import { shallow } from 'enzyme';
import {Courses} from '../components/courses/Courses';
import "../setupTest"

describe("CourseComponent", () => {
  it("should render courses component", () => {
    shallow(<Courses />)
  })
})