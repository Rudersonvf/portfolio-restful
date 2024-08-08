import { BrowserRouter, Route, Routes } from "react-router-dom";
import Admin from "./pages/Admin";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/admin/" element={<Admin />}>
          <Route path="projects" />
          <Route path="experiences" />
          <Route path="educations" />
          <Route path="skills" />
          <Route path="categories" />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
