import React, { useState } from 'react';
import Navbar from '../Navbar';
const BMICalculator = () => {
  const [height, setHeight] = useState('');
  const [weight, setWeight] = useState('');
  const [id, setID] = useState('')
  const [bmi, setBMI] = useState(null);

  const handleSubmit = async (event) => {
    event.preventDefault();

    const response = await fetch('http://localhost:8080/bmi', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({id, height, weight }),
    });

    if (response.ok) {
      const data = await response.json();
      await console.log(data);
      setBMI(data);
    } else {
      console.error('Failed to calculate BMI');
    }
  };

  return (
    <>
    <Navbar />
    <div className='siz'>
      <div>
      <h1>BMI Calculator</h1>
      <form onSubmit={handleSubmit}>
      <label>
          ID:        </label>

          <input type="number" value={id} onChange={(e) => setID(e.target.value)} />
        <br />
        <label>
          Height (cm):        </label>

          <input type="number" value={height} onChange={(e) => setHeight(e.target.value)} />
        <br />
        <label>
          Weight (kg):        </label>

          <input type="number" value={weight} onChange={(e) => setWeight(e.target.value)} />
        <br />
        <button className = "but" type="submit">Calculate</button>
      </form>
      {bmi && <p>Your BMI is {bmi.bmiValue}</p>}
      </div>
    </div></>
  );
};

export default BMICalculator;
