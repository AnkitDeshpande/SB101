package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Lawyer;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.uitility.DBUtils;

public class CourtDAOImpl implements CourtDAO {

	@Override
	public List<Lawyer> getLawyerList() {
		Connection con = DBUtils.connect();
		String query = "Select * from lawyer";
		List<Lawyer> list = new ArrayList<Lawyer>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Lawyer lawyer = new Lawyer();
				lawyer.setId(rs.getInt(1));
				lawyer.setName(rs.getString(2));
				lawyer.setEmail(rs.getString(3));
				lawyer.setAddress(rs.getString(4));
				lawyer.setExperience(rs.getInt(5));
				list.add(lawyer);
			}
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBUtils.close(con);
		}

		return null;
	}

	@Override
	public Lawyer findLawyerById(int id) {
		Connection con = DBUtils.connect();
		Lawyer lawyer = null;
		String query = "Select * from Lawyer where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				lawyer = new Lawyer();
				lawyer.setId(rs.getInt(1));
				lawyer.setName(rs.getString(2));
				lawyer.setEmail(rs.getString(3));
				lawyer.setAddress(rs.getString(4));
				lawyer.setExperience(rs.getInt(5));
				return lawyer;

			} else {
				System.out.println("No records found with the Id : " + id);
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBUtils.close(con);
		}

		return null;
	}

	@Override
	public String saveLawyer(Lawyer lawyer) {
		Connection con = DBUtils.connect();
		String query = "Insert into lawyer(id, name, email, address, experience) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, lawyer.getId());
			ps.setString(2, lawyer.getName());
			ps.setString(3, lawyer.getEmail());
			ps.setString(4, lawyer.getAddress());
			ps.setInt(5, lawyer.getExperience());

			return ps.executeUpdate() > 0 ? "\nLawyer added successfully" : "Something went wrong, try again later";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBUtils.close(con);
		}

		return null;
	}

	@Override
	public String deleteLawyerById(int id) {
		Connection con = DBUtils.connect();
		String query = "Delete from lawyer where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0 ? "\nLawyer Deleted successfully" : "Something went wrong, try again later";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBUtils.close(con);
		}

		return null;
	}

	@Override
	public String updateLawyerExperience(int id, int experience) {
		Connection con = DBUtils.connect();
		String query = "Update Lawyer set experience = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			con.setAutoCommit(false);
			Lawyer lawyer = findLawyerById(id);

			if (lawyer == null) {
				con.rollback();
				throw new NorecordsFoundException("No records found with id : " + id);
			} else {
				ps.setInt(1, experience);
				ps.setInt(2, id);

				if (ps.executeUpdate() > 0) {
					con.commit();
					return "\nExperience updated successfully.";
				} else {
					con.rollback();
					return "Couldn't update, try again later.";
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBUtils.close(con);
		}

		return null;
	}

}
