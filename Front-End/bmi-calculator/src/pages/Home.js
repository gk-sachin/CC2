import Navbar from "../Navbar";
import { useEffect, useState } from "react";
import axios from 'axios'
import { useNavigate } from "react-router-dom";

function Home() {
    const [data, setData] = useState([])
    const navigate = useNavigate()
    useEffect(() => {
        async function fetchData() {
            const res = await axios.get("http://localhost:8080/bmi")
            await setData(res.data)
            console.log(res);
        }
        fetchData()
    }, [])
    async function handleDelete(id) {
        const res = await axios.delete(`http://localhost:8080/bmi/${id}`)
        await console.log(res);
    }
    return <>
    <Navbar />
    <div className="headers">
        <p>ID</p>
        <p>Height</p>
        <p>Weight</p>
        <p>BMI</p>
        <p>Actions</p>
    </div>
    {data && data.map(bmi => <div className="bmi-row" key={bmi.id}>
        <p>{bmi.id}</p>
        <p>{bmi.height}</p>
        <p>{bmi.weight}</p>
        <p>{bmi.bmiValue}</p>
        <div className="buttons">
        <button onClick={() => {
            navigate(`/edit/${bmi.id}`)
        }}>
            Edit
        </button>&nbsp;
       <button onClick={() => {
        handleDelete(bmi.id)
       }} className="danger">
            Delete
        </button>
        </div>
    </div>)}</>
}

export default Home;