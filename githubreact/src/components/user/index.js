import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import './index.css'

function UserIndex(){
    // user information
    const [posts, setPosts] = useState([]);

    // following number
    const [count, setCount] = useState(0);

    //url parameter
    const params = useParams();

    // repo is public or private
    let access = "public";

    // has repo or not
    let hasRepo = true;

    const navigate = useNavigate();

    // fetch data from http://localhost:8000/Users/<User>
    useEffect(() => {
        fetch('http://localhost:8000/Users/'+params.Name)
            .then((response) => {
                //console.log(response)
                if (response.status===200){
                    return response.json()
                }else{
                    navigate('/error/UserNotExist');
                }
            })
            .then((data) => {
                //console.log(data);
                setPosts(data);
                setCount(data.numFollowing);
            })
            .catch((err) => {
                //console.log(err);
                navigate('/error/UserNotExist');
            });
    }, []);

    if (posts.repos==null){
        // render page after the data fetched.
        return(
            <>Still loading...</>
        )
    } else {
        if(posts.repos.reposName === null){
            hasRepo=false;
        }

        if(posts.repos.private===true){
            access = "private";
        } else {
            access = "public";
        }
    }

    return (
        <div>
            <ul>
                <li>Login: {posts.signInName}</li>
                <li>Name: {posts.userName}</li>
                <li>Followers: {posts.numFollower}</li>
                <li>Followings: {count}&nbsp;
                    <button onClick={() => setCount(count + 10)}>
                    Add Followngs
                    </button>   
                </li>
                <li>
                    User {posts.signInName} with {posts.numFollower} followers is following {count}. {hasRepo ?(<>One repo for this user is {posts.repos.reposName} and it is {access}.</>):(<>Thit user has no repo</>)}
                </li>
            </ul>
        </div>
    )
}

export default UserIndex