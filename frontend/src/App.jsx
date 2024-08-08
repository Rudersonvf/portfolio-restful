import { BrowserRouter, Route, Routes } from "react-router-dom";
import Admin from "./pages/Admin";
import Experiences from "./pages/Admin/Experiences";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/admin/" element={<Admin />}>
          <Route path="projects" />
          <Route path="experiences" element={<Experiences/>}/>
          <Route path="educations" />
          <Route path="skills" />
          <Route path="categories" />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
