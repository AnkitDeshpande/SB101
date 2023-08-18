package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Lawyer;
import com.masai.exception.NoRecordsFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.utility.DBUtils;

public class CourtDAOJdbcImpl implements CourtDAO {

	@Override
	public List<Lawyer> getLawyerList() throws SomeThingWentWrongException {

		List<Lawyer> ls = new ArrayList<>();

		try (Connection con = DBUtils.connect()) {

			String q = "Select * from lawyer";
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Lawyer l = new Lawyer();
				l.setId(rs.getInt(1));
				l.setName(rs.getString(2));
				l.setEmail(rs.getString(3));
				l.setAddress(rs.getString(4));
				l.setExp(rs.getInt(5));
				ls.add(l);
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong. Try again.");
		}

		return ls;
	}

	@Override
	public Lawyer findLawyerById(int id) throws NoRecordsFoundException, SomeThingWentWrongException {
		Lawyer l = null;
		
		try(Connection c = DBUtils.connect()){
			String q = "Select * from lawyer where id = ?";
			PreparedStatement ps = c.prepareStatement(q);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				l = new Lawyer();
				l.setId(rs.getInt(1));
				l.setName(rs.getString(2));
				l.setEmail(rs.getString(3));
				l.setAddress(rs.getString(4));
				l.setExp(rs.getInt(5));
			}
		}catch(SQLException e) {
			throw new NoRecordsFoundException("No record found.");
		}
		return l;
	}

	@Override
	public String saveLawyer(Lawyer l) throws SomeThingWentWrongException {
		try(Connection c = DBUtils.connect()){
			PreparedStatement ps = c.prepareStatement("INSERT INTO lawyer values(?,?,?,?,?)");
			ps.setInt(1, l.getId());
			ps.setString(2, l.getName());
			ps.setString(3, l.getEmail());
			ps.setString(4, l.getAddress());
			ps.setInt(5, l.getExp());
			
			int rowAffected = ps.executeUpdate();
			
			return rowAffected > 0 ? "Lawyer saved successfully." : "Failed to save lawyer.";
			
		}catch(SQLException e){
			throw new SomeThingWentWrongException("Unable to add lawyer.");
		}
	}

	@Override
	public String deleteLawyerById(int id) throws SomeThingWentWrongException, NoRecordsFoundException {
		try (Connection c = DBUtils.connect()){
			PreparedStatement ps = c.prepareStatement("Delete from lawyer where id = ?");
			
			ps.setInt(1, id);
			
			int rowAffected = ps.executeUpdate();
			return rowAffected > 0 ? "Lawyer deleted successfully." : "Failed to delete lawyer.";
		} catch (SQLException e) {
			throw new SomeThingWentWrongException("Unable to Delete.");
		}
	}

	@Override
	public String updateLawyerExperience(int id, int experience) throws SomeThingWentWrongException, NoRecordsFoundException {
		Connection c = null;
		try {
			c = DBUtils.connect();
			
			c.setAutoCommit(false);
			Lawyer l = findLawyerById(id);
			if(l==null) {
				c.rollback();
				throw new NoRecordsFoundException("Lawyer not found");
			}
			
			try(PreparedStatement ps = c.prepareStatement("Update lawyer set experience = ? where id = ?")) {
				
				ps.setInt(1, experience);
				ps.setInt(2, id);
				
				int rowAffected = ps.executeUpdate();
				if(rowAffected>0) {
					c.commit();
					return "Lawyer Updated Successfully";
				}
				c.rollback();
				c.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException("Unable to Update.");
		}
		return "Failed to update lawyer experience.";			
	}

}
