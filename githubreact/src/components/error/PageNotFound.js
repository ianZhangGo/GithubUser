import React from 'react'
import { Link  } from 'react-router-dom'

function PageNotFound() {
  return (
    <div>
        <h1>User not exists</h1>
        <p style={{textAlign:"center"}}>
            <Link to="/">Go to Home </Link>
        </p>
    </div>
  )
}

export default PageNotFound