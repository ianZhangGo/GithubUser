import React, { useState, useEffect } from 'react'
import { useNavigate  } from 'react-router-dom'
import './index.css'


function IndexHome(props) {
  //input box value
  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  //input box value change
  const handleChange = event => {
    setMessage(event.target.value);
  };

  //search user. redirect to new url
  const handleClick = event => {
    event.preventDefault();

    navigate('/User/'+message);
  };

  return (
    <div>
        <label>
            <h1 className="main">GitHub User </h1>
        </label>
        <br></br>
        <input
            className='search'
            type="text"
            id="message"
            name="message"
            onChange={handleChange}
            value={message}
            placeholder="Search Github User" 
        />
        <button type="submit" onClick={handleClick}>Search</button>
    </div>
    
  )
}

// Search button click trigger
function search(){
  let tokenAmount = document.getElementById("numberInput").value;
}
export default IndexHome