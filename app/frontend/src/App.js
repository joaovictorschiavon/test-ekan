import React from 'react'
import { Route, Routes } from 'react-router';
import './App.css'
import Options from './components/Options'
import RegisterForm from './components/RegisterForm'
import UpdateForm from './components/UpdateForm'

function App() {
  return (
    <Routes>
      <Route exact path="/" element={<Options />} />
      <Route path="/register" element={<RegisterForm />} />
      <Route path="/update" element={<UpdateForm />} />
    </Routes>
  );
}

export default App;