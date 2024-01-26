// DataService.js
import axios from "axios";

const baseURL = "http://localhost:8180/api/v1";

export const dataService = {
  getDateCalendars: () => axios.get(`${baseURL}/date-calendars`),
  getDateCalendarById: (id) => axios.get(`${baseURL}/date-calendars/${id}`),
  createDateCalendar: (dateCalendarData) => axios.post(`${baseURL}/date-calendars`, dateCalendarData),
  updateDateCalendar: (id, dateCalendarData) => axios.put(`${baseURL}/date-calendars/${id}`, dateCalendarData),
  deleteDateCalendar: (id) => axios.delete(`${baseURL}/date-calendars/${id}`),

  getLocations: () => axios.get(`${baseURL}/locations`),  // Assuming a locations endpoint in your API
  getLocationById: (id) => axios.get(`${baseURL}/locations/${id}`),
  createLocation: (locationData) => axios.post(`${baseURL}/locations`, locationData),
  updateLocation: (id, locationData) => axios.put(`${baseURL}/locations/${id}`, locationData),
  deleteLocation: (id) => axios.delete(`${baseURL}/locations/${id}`),

  getOrganizations: () => axios.get(`${baseURL}/organizations`),
  getOrganizationById: (id) => axios.get(`${baseURL}/organizations/${id}`),
  createOrganization: (organizationData) => axios.post(`${baseURL}/organizations`, organizationData),
  updateOrganization: (id, organizationData) => axios.put(`${baseURL}/organizations/${id}`, organizationData),
  deleteOrganization: (id) => axios.delete(`${baseURL}/organizations/${id}`),

  getPosts: () => axios.get(`${baseURL}/posts`),
  getPostById: (id) => axios.get(`${baseURL}/posts/${id}`),
  createPost: (postData) => axios.post(`${baseURL}/posts`, postData),
  updatePost: (id, postData) => axios.put(`${baseURL}/posts/${id}`, postData),
  deletePost: (id) => axios.delete(`${baseURL}/posts/${id}`),

  getTimePlanners: () => axios.get(`${baseURL}/timeplanners`),
  getTimePlannerById: (id) => axios.get(`${baseURL}/timeplanners/${id}`),
  createTimePlanner: (timePlannerData) => axios.post(`${baseURL}/timeplanners`, timePlannerData),
  updateTimePlanner: (id, timePlannerData) => axios.put(`${baseURL}/timeplanners/${id}`, timePlannerData),
  deleteTimePlanner: (id) => axios.delete(`${baseURL}/timeplanners/${id}`),

  getUsers: () => axios.get(`${baseURL}/users`),
  getUserById: (id) => axios.get(`${baseURL}/users/${id}`),
  createUser: (userData) => axios.post(`${baseURL}/users`, userData),
  updateUser: (id, userData) => axios.put(`${baseURL}/users/${id}`, userData),
  deleteUser: (id) => axios.delete(`${baseURL}/users/${id}`),

  getUserRoles: () => axios.get(`${baseURL}/userroles`),
};
