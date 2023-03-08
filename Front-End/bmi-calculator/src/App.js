import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import BMICalculator from './pages/BMICalculator';
import EditBMI from './pages/EditBMI';
import Home from './pages/Home';

function App() {
return <Router>
  <Routes>
    <Route path='/' element={<Home />} />
    <Route path='/check' element={<BMICalculator />} />
    <Route path='/edit/:slug' element={<EditBMI />} />
  </Routes>
</Router>
}

export default App;