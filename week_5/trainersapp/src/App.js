import {
  BrowserRouter,
  Routes,
  Route,
  Link,
  Navigate
} from "react-router-dom";

import Home from "./Components/Home";
import TrainersList from "./Components/TrainersList";
import TrainerDetails from "./Components/TrainerDetails";

function App() {

  return (

      <BrowserRouter>

        <h1>My Academy Trainers App</h1>

        <Link to="/">Home</Link>

        {" | "}

        <Link to="/trainers">Show Trainers</Link>

        <hr />

        <Routes>

          <Route
              path="/"
              element={<Navigate to="/home" />}
          />

          <Route
              path="/home"
              element={<Home />}
          />

          <Route
              path="/trainers"
              element={<TrainersList />}
          />

          <Route
              path="/trainers/:id"
              element={<TrainerDetails />}
          />

        </Routes>

      </BrowserRouter>

  );

}

export default App;