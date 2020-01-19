package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classi.Position;

public class PositionDao extends Position{
	
	private Connection con;
	public PositionDao(Connection c) {
		con = c;
	}

	public String MatchRegionDao(String city) {
		ResultSet result;
		String query = "select regione from luogo where città =?";
		String str;
		try {
			str = new String();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, city);
			result = pst.executeQuery();
			while(result.next()) {
			str = result.getString(1);
			}
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
	
	

