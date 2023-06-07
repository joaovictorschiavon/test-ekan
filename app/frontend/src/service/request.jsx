import axios from 'axios';

const api = axios.create({
  baseURL: `http://localhost:3000`,
  headers: {
    "Content-type": "application/json"
}
});

export const createClient = async (endpoint, body) => {
    const { data } = await api.post(endpoint, body,);
    return data;
} 

export const returnAllClients = async (endpoint) => {
    const { data } = await api.get(endpoint);
    return data;
};

export const getClient = async (endpoint) => {
  const { data } = await api.get(endpoint);
  return data;
};

export const updateClient = async (endpoint, body) => {
  const { data } = await api.put(endpoint, body);
  return data;
};

export const deleteClient = async (endpoint) => {
  const { data } = await api.delete(endpoint);
  return data;
};

export default api;