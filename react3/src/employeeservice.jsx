import axios from "axios"
import { useEffect } from "react"
const api="http://localhost:8080/api/employees"

export const listemployees=async() => {
    try {
        const response=await axios.get(api);
        return response.data;
    } catch (error) {
        console.error('Error fetching employees:', error);
    }

}
export const Addmployees=async(employee) => {
    try {
        const response=await axios.post(api,employee);
        return response.data;
    } catch (error) {
        console.error('Error fetching employees:', error);
    }
  

}
export const getemployee=(employeeid)=>axios.get(api+"/"+employeeid);
export const updateemployee=(employeeid,employee)=>axios.put(api +'/'+ employeeid,employee);
export const deleteemployee=(employeeid)=>axios.delete(api+'/'+employeeid);