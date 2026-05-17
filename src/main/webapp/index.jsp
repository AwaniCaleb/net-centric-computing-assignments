<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.models.Patient" %>
<%@ page import="com.dao.PatientDAO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital System - Patients</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { border-collapse: collapse; width: 80%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Registered Patients</h2>
    
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
        
        <%
            // Call the DAO to fetch the data
            PatientDAO dao = new PatientDAO();
            List<Patient> patientList = dao.getAllPatients();
            
            // Loop through the list and generate HTML rows
            for(Patient p : patientList) {
        %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getFirstName() %></td>
                <td><%= p.getLastName() %></td>
                <td><%= p.getEmail() %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>