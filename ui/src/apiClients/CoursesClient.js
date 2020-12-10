import {API_BASE_URL} from '../constants';
import {request} from '../util/APIUtils'

export function fetchAllCourses() {
  return request({
    url: API_BASE_URL + "/courses",
    method: 'GET'
  });
}

export function deleteCourse(id) {
  return request({
    url: API_BASE_URL + "/courses/"+id,
    method: 'DELETE',
  });
}