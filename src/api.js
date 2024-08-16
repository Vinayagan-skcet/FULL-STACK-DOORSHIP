// src/api.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api'; // Adjust the URL as needed

export const signUp = (username, email, password) => {
  return axios.post(`${API_URL}/signup`, { username, email, password });
};

export const signIn = (username, password) => {
  return axios.post(`${API_URL}/signin`, { username, password });
};
