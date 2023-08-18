package com.masai.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Medicine;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;
import com.masai.utitlity.DBUtils;

public class MedicineDaoImpl implements MedicineDao {

	@Override
	public void addMed(Medicine med) throws SomethingWentWrongException {
		Connection con = DBUtils.connect();
		try {
			String query = "Insert into Medicine values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, med.getMedId());
			ps.setString(2, med.getName());
			ps.setString(3, med.getCompany());
			ps.setBigDecimal(4, med.getPricePerUnit());
			ps.setDate(5, Date.valueOf(med.getMfgDate()));
			ps.setDate(6, Date.valueOf(med.getExpDate()));

			System.out.println(ps.executeUpdate() > 0 ? "Medicine Added Successfully" : "Something Went Wrong.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBUtils.disconnect(con);
		}

	}

	@Override
	public void updateMed(String id, String name, String company, BigDecimal price, LocalDate mfgDate,
			LocalDate expDate) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = DBUtils.connect();
		try {
			String query = "UPDATE medicine SET name = ?, company = ?, price_per_unit = ?, MfgDate = ?, ExpDate = ? WHERE med_Id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, company);
			ps.setBigDecimal(3, price);
			ps.setDate(4, Date.valueOf(mfgDate));
			ps.setDate(5, Date.valueOf(expDate));
			ps.setString(6, id);

			System.out.println(ps.executeUpdate() > 0 ? "Medicine Updated Successfully" : "Something Went Wrong.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.disconnect(con);
		}

	}

	@Override
	public void deleteMed(String id) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = DBUtils.connect();
		try {
			String query = "Delete from Medicine where med_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			System.out.println(ps.executeUpdate() > 0 ? "Medicine Deleted Successfully" : "Something Went Wrong.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.disconnect(con);
		}

	}

	@Override
	public List<Medicine> viewAllMeds() throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = DBUtils.connect();
		List<Medicine> list = new ArrayList<Medicine>();
		try {
			String query = "Select * from Medicine";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String medId = rs.getString("med_Id");
				String name = rs.getString("name");
				String company = rs.getString("company");
				BigDecimal pricePerUnit = rs.getBigDecimal("price_per_unit");
				LocalDate mfgDate = rs.getDate("MfgDate").toLocalDate();
				LocalDate expDate = rs.getDate("ExpDate").toLocalDate();
				Medicine medicine = new Medicine(medId, name, company, pricePerUnit, mfgDate, expDate);
				list.add(medicine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.disconnect(con);
		}
		return list;
	}

}
