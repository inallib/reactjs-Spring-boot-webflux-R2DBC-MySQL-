import React from 'react';
import { shallow } from 'enzyme';
import {SubHeader} from '../components/courses/SubHeader';
import Button from 'react-bootstrap/Button'
import "../setupTest"

describe("Subheader Component tests", () => {
  let wrapper
  it("should render courses component", () => {
    wrapper = shallow(<SubHeader />)
  })

  it("renders header text", () => {
    const headerText = <h2>Courses</h2>
    expect(wrapper.contains(headerText)).toEqual(true);
  })

  it("renders Add course button", () => {
    const headerText = <Button variant="success">Add course</Button>
    expect(wrapper.contains(headerText)).toEqual(true);
  })
});

