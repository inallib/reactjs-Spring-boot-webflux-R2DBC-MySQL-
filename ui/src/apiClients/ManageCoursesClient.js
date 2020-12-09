import {API_BASE_URL} from '../constants';
import {request} from '../util/APIUtils'

export function fetchAuthors() {
  return request({
    url: API_BASE_URL + "/authors",
    method: 'GET'
  });
}

export function saveCourse(course) {
  return request({
    url: API_BASE_URL + "/courses",
    method: 'post',
    body: JSON.stringify(course)
  });
}