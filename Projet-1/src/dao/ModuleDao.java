package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Formation;
import models.Module;
import models.User;

public class ModuleDao {
	
	UserDao usrDao = new UserDao();

	public  ModuleDao() {

	}

	/*
	 * public ArrayList<Module> getModulesOfFormation(int int1) { List<Module>
	 * listModules = new ArrayList<Module>(); String sql =
	 * "SELECT * FROM Modules WHERE formation="+int1+";"; System.out.println(sql);
	 * try { Connection conn = DbConnector.getConn(); Statement stmt =
	 * conn.createStatement(); ResultSet rs = stmt.executeQuery(sql); // loop
	 * through the result set while (rs.next()) { User user =
	 * usrDao.getUser(rs.getInt("responsableModule"));
	 * 
	 * // listModules.add(new Module(rs.getInt("id"),rs.getString("name"),
	 * rs.getString("description"),user,int1)); } } catch (SQLException e) {
	 * System.out.println(e.getMessage()); } return listModules; }
	 */
	
	/* 
	 * public List<Formation> getAllFormations() {
		List<Formation> listFormations = new ArrayList<Formation>();
		String sql = "SELECT * FROM Formations";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// loop through the result set
			while (rs.next()) {
				User user = usrDao.getUser(rs.getInt("responsableModule"));
				ArrayList<Module> = moduleDao.getModulesOfFormation(rs.getInt("id"));
				Formation tempFormation = new Formation(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("cahierDeCharge"),user);
				listFormations.add(tempFormation);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listFormations;
	}

	
	 * public Formation login(String formationname, String password) { String sql =
	 * "SELECT name,role,formationname,id FROM Formations WHERE formationname='" +
	 * formationname + "' AND password='" + password + "';";
	 * System.out.println(sql); try { Connection conn = DbConnector.getConn();
	 * Statement stmt = conn.createStatement(); ResultSet rs =
	 * stmt.executeQuery(sql);
	 * 
	 * // loop through the result set while (rs.next()) {
	 * System.out.println(rs.getString("name") + "\t" + rs.getString("role") +
	 * "  is Found"); return new Formation(rs.getInt("id"),
	 * rs.getString("formationname"), rs.getString("name"), rs.getString("role")); }
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return null;
	 * }
	 * 
	 * public Boolean saveFormation(Formation newFormation) { String sql =
	 * "INSERT INTO Formations(formationname,name,role,password) values (\"" +
	 * newFormation.getFormationname() + "\",\"" + newFormation.getName() + "\",\""
	 * + newFormation.getRole() + "\",\"" + newFormation.getPassword() + "\");";
	 * System.out.println(sql); try { Connection conn = DbConnector.getConn();
	 * Statement stmt = conn.createStatement(); int rs = stmt.executeUpdate(sql); if
	 * (rs == 1) return true;
	 * 
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return
	 * false; }
	 * 
	 * public Boolean deleteFormation(String id) { String sql =
	 * "DELETE FROM Formations WHERE id=" + id + ";"; System.out.println(sql); try {
	 * Connection conn = DbConnector.getConn(); Statement stmt =
	 * conn.createStatement(); int rs = stmt.executeUpdate(sql); if (rs == 1) return
	 * true;
	 * 
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return
	 * false; }
	 * 
	 * public Boolean isFormationnameExists(String formationname) { String sql =
	 * "SELECT name,role,formationname,id FROM Formations WHERE formationname='" +
	 * formationname + "';"; System.out.println(sql); try { Connection conn =
	 * DbConnector.getConn(); Statement stmt = conn.createStatement(); ResultSet rs
	 * = stmt.executeQuery(sql);
	 * 
	 * // loop through the result set if (rs.next()) { return true; } return false;
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return
	 * false; }
	 * 
	 * public Boolean updateFormation(Formation newFormation) { // TODO
	 * Auto-generated method stub String sql =
	 * "UPDATE Formations SET name = '"+newFormation.getName()
	 * +"', formationname = '"+newFormation.getFormationname()+"', password = '"
	 * +newFormation.getPassword()+"' WHERE id = "+newFormation.getId()+";";
	 * System.out.println(sql); try { Connection conn = DbConnector.getConn();
	 * Statement stmt = conn.createStatement(); int rs = stmt.executeUpdate(sql); if
	 * (rs == 1) return true;
	 * 
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return
	 * false; }
	 */
}