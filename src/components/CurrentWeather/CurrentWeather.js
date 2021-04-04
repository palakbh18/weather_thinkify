import React, { useState } from 'react';
import Conditions from '../Conditions/Conditions';
import classes from './CurrentWeather.module.css'


const apiKey= process.env.REACT_APP_API_KEY;
const CurrentWeather = () => {
    let [city, setCity] = useState('');
    let [unit, setUnit] = useState('metric');
    let [error, setError] = useState(false);
    let [loading, setLoading] = useState(false);
   let [responseObj, setResponseObj] = useState({});


   function getCurrentWeather(e) {
    e.preventDefault();
    if (city.length === 0) {
        return setError(true);
    }
    // Clear state in preparation for new data
    setError(false);
    setResponseObj({});
   
    setLoading(true);
   
    let uriEncodedCity = encodeURIComponent(city);
    
    fetch(`https://api.openweathermap.org/data/2.5/weather?units=${unit}&q=${uriEncodedCity}&appid=${apiKey}`, {
        "method": "GET",
        "headers": {
            "accept": "application/json"
        }
    })
    .then(response => response.json())
   .then(response => {
       if (response.cod !== 200) {
           throw new Error()
       }
       setResponseObj(response);
       setLoading(false);
   })
   .catch(err => {
       setError(true);
       setLoading(false);
       console.log(err.message);
   });
   }

   return (
    <div>
        <h2>Find Current Weather Conditions</h2>
            <form onSubmit={getCurrentWeather}>
                <input
                    type="text"
                    placeholder="Enter City"
                    maxLength="50"
                    className={classes.textInput}
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                    />
                    <button  className={classes.Button} type="submit">Get Current Weather</button>
            </form>
        <Conditions
            responseObj={responseObj}
            error={error} 
            loading={loading} 
            />
    </div>
   )
}

export default CurrentWeather;