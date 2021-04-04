import logo from './logo.svg';
import './App.css';
import CurrentWeather from './components/CurrentWeather/CurrentWeather';



function App() {
  return (
    <div className="App">
      <header className="App-header">
      <h1> Weather App for Thinkify </h1>
      </header>
      <main>
         <CurrentWeather />
        </main>
        <footer>
              Copyright
        </footer>
    </div>
  );
}

export default App;
