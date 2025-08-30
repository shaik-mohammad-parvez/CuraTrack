import React, { useEffect, useState } from 'react';
import axios from 'axios';

function PatientList() {
  const [patients, setPatients] = useState([]);

  useEffect(() => {
    axios.get('/api/patient')
      .then(response => {
        setPatients(response.data);
      })
      .catch(error => {
        console.error('Error fetching patients:', error);
      });
  }, []);

  return (
    <div>
      <h2>Patient List</h2>
      <ul>
        {patients.map(patient => (
          <li key={patient.patientid}>
            {patient.name} {patient.lastname} - {patient.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default PatientList;
