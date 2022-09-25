import './App.css';
import React, { useState } from 'react';
import {Route, Routes} from "react-router-dom"
import { ToastContainer } from "react-toastify";
import Login from './Component/Login/login';
import Register from './Component/Register/register';
import Header from './Component/Header/Header';
import Footer from './Component/Footer/Footer';
import Index from './Component/Index/Index';

function App() {
  const [userLogin,setUserLogin] = useState({})
  
  const callbackFunction = (childData) => {
    setUserLogin(childData)
  }
  console.log(userLogin);

  return (
    <div className=''>
        <Header UserLogin={userLogin}/>
      <Routes>
      <Route path='/' element={<Index />}></Route>
      <Route path='/login' element={<Login parentCallback={callbackFunction}/>}></Route>
      <Route path='/register' element={<Register/>}></Route>
      </Routes>
        <Footer />
        <ToastContainer pauseOnFocusLoss draggable pauseOnHover />
    </div>

  );
}

export default App;
