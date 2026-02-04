import React from 'react';
import { Routes, Route } from 'react-router-dom';
import TeamApp from './TeamApp.jsx';
import Ejercicio3 from "./components/ejercicio3.jsx";

const App = () => {
    return (
        <Routes>
            <Route path="/" element={<TeamApp />} />
            <Route path="/ejercicio3" element={<Ejercicio3 />} />
        </Routes>
    );
};

export default App;