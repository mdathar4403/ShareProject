import './App.css';

import { BrowserRouter,Route, Routes } from "react-router-dom";
import Home from './components/Home';
import Create from './components/Create';
import ShareDetails from './components/ShareDetails';
import Navbar from './components/Navbar';

function App() {
  

  return (
    <BrowserRouter>
      <div className="App">
        <Navbar />
        <div className="content">
          <Routes>
            <Route exact path="/" element={<Home/>}/>
            <Route path="/create" element={<Create/>}/>
            <Route path="/share/:id" element={<ShareDetails />}/>
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  )
}

export default App;
