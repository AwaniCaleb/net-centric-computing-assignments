package com.dao;

import com.utils.DBConnection;
import com.models.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        // This is the ONLY line you need to change for your own tables when copying my assignment!
        String sql = "SELECT patient_id, patient_first_name, patient_last_name, patient_email FROM patients";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("patient_first_name"),
                    rs.getString("patient_last_name"),
                    rs.getString("patient_email")
                );
                patients.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
}
