import { useEffect, useState } from "react";
import { Addmployees, getemployee, updateemployee } from "./employeeservice";
import { useNavigate, useParams } from "react-router-dom";

export default function AddEmployeeForm() {
  const [formData, setFormData] = useState({
    firstname: "",
    lastname: "",
    email: "",
  });
  
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      const fetchEmployee = async () => {
        try {
          const { data } = await getemployee(id);
          setFormData({
            firstname: data.firstname,
            lastname: data.lastname,
            email: data.email,
          });
        } catch (error) {
          console.error("Error fetching employee:", error);
        }
      };
      fetchEmployee();
    }
  }, [id]);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (id) {
        await updateemployee(id, formData);
        console.log("Employee updated:", formData);
      } else {
        await Addmployees(formData);
        console.log("Employee added:", formData);
      }
      navigate("/employees");
    } catch (error) {
      console.error("Error submitting form:", error);
    }
  };

  return (
    <form className="form" onSubmit={handleSubmit}>
      <h2>{id ? "Update Employee" : "Add Employee"}</h2>

      <input
        type="text"
        name="firstname"
        value={formData.firstname}
        onChange={handleChange}
        placeholder="Enter First Name"
        required
      />

      <label>Last Name</label>
      <input
        type="text"
        name="lastname"
        value={formData.lastname}
        onChange={handleChange}
        placeholder="Enter Last Name"
        required
      />

      <label>Email</label>
      <input
        type="email"
        name="email"
        value={formData.email}
        onChange={handleChange}
        placeholder="Enter Email"
        required
      />

      <button type="submit">{id ? "Update" : "Submit"}</button>
    </form>
  );
}
