import { useState } from 'react'

import './App.css'
import Applayout from './applayout'
import { createBrowserRouter } from 'react-router-dom'
import { RouterProvider } from 'react-router'
import Listemployee from './Listemployee'
import Employeecomopnent from './employeecomponent'
function App() {
 

  const router=createBrowserRouter(
    [
      {
        path:"/",
        element:<Applayout/>,
        children:[
          {
             path:"/employees",
               element:<Listemployee/>,
          },{
            path:"/add-employees",
             element:<Employeecomopnent/>,

          },{
            path:"/edit-employee/:id",
            element:<Employeecomopnent/>
          }
        ]
      }
    ]
  )
  return <RouterProvider router={router}></RouterProvider>
}

export default App
