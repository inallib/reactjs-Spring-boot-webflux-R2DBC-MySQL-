import {API_BASE_URL} from '../constants';
import {request} from '../util/APIUtils'

export function fetchAllCourses() {
  return request({
    url: API_BASE_URL + "/courses",
    method: 'GET'
  });
}

export function deleteCourse(course) {
  return request({
    url: API_BASE_URL + "/courses",
    method: 'DELETE',
    body: JSON.stringify(course)
  });
}