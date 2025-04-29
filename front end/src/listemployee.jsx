import { useEffect, useState } from 'react';
import './css/Listemployeecomponent.css';
import { listemployees } from './employeeservice';
import { useNavigate } from 'react-router-dom';
import { deleteemployee } from './employeeservice';
export default function Listemployeecomponent(){
    const navigator=useNavigate();
  const [employee, setemployees]=useState([])
useEffect(()=>{
    const fetchemployees=async(employee)=>{
        try {
           const data=await listemployees();
           setemployees(data);
           console.log(data);
        } catch (error) {
           console.log(error)
           
        }
       
       }
       fetchemployees();
},[])
function updateemployee(id){
    navigator(`/edit-employee/${id}`)
}
async function deleteemployees(id){
    console.log(id);
   const succes=await deleteemployee(id);
   if(succes){
    setemployees(prv=>prv.filter(emp => emp.id !== id))
   }
}




   return(<>
    <h1>List of employees</h1>
    <button
        className="add-employee-btn"
        onClick={() => navigator('/add-employees')}
      >
        Add Employee
      </button>
    <table>
        <thead>
            <tr>
                <th>Employee id</th>
                <th>Employee Firstname</th>
                <th>Employee Lastname</th>
                <th>Employee Email</th>
                <th>Actions</th>
            </tr>
        </thead>
       <tbody>
            {
employee.map(employee=>(
    <tr key={employee.id}>
        <td>{employee.id}</td>
        <td>{employee.firstname}</td>
        <td>{employee.lastname}</td>
        <td>{employee.email}</td>
        <td><button onClick={()=>updateemployee(employee.id)}>Update</button>
        <button onClick={()=>deleteemployees(employee.id)}>Delete</button></td>
    </tr>
))
            }
        </tbody>
    </table>
    </>
)}