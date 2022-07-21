import {BrowserRouter, Routes, Route} from 'react-router-dom';
import './App.css';
import IndexHome from './components/home';
import UserIndex from './components/user';
import PageNotFound from './components/error/PageNotFound';

function App(props) {
  return (
    <div className="App">
      <BrowserRouter>
            <Routes>
                <Route path='/User/:Name' element={<UserIndex />} />
                <Route path='/error/UserNotExist' element={<PageNotFound/>} />
                <Route path='/*' element={<IndexHome/>} />
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
