import './App.css';
import axios from './api/axios';
import useState from 'react';

function App() {

  const [users, setUsers] = useState([]);

  axios.get("/users").then((response) => {
    setUsers(response);
    console.log(response);
  })

  return (
    <div className="App">
      <h1>Users</h1>
      {
        users.map((user) => {
          return (
            <table>

            </table>
          )
        })
      }
    </div>
  );
}

export default App;
