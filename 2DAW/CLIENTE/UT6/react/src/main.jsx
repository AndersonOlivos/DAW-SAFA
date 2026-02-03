import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import TeamApp from './TeamApp.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <TeamApp />
  </StrictMode>,
)
