/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flyhigh
 */
public class DBModel {

    protected DBConnect dbConnector;

    public DBModel() {
    }

    /**
    Checks whether empid already there
     */
    public boolean empIdExists(String empId) {
        boolean retVal = false;
        try {

            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from employees where employeeId = ?");
            ps.setString(1, empId);
            ResultSet rs = ps.executeQuery();
            retVal = rs.next();
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retVal;
    }

    public void addUser(String username, int department, String ip, String phone, String empId) {
        try {
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("insert into employees(username,department,phone,ip,employeeId) values(?,?,?,?,?)");
            ps.setString(1, username);
            ps.setInt(2, department);
            ps.setString(3, phone);
            ps.setString(4, ip);
            ps.setString(5, empId);
            ps.executeUpdate();
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editUser(String username, String department, String ip, String phone, String empId) {
        try {
            int dept = 0;
            dept = getIdDepartment(department);
            String sql = "update employees set username = ? , ip = ? , phone = ? , department = ? where employeeId= ? ";
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, ip);
            ps.setString(3, phone);
            ps.setInt(4, dept);
            ps.setString(5, empId);
            int rs = ps.executeUpdate();
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean renameDepartment(String old, String newd) {
        if (checkDepartment(newd)) {
            return false;
        }
        try {
            String sql = "update departments set department=? where department=?";
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement(sql);
            ps.setString(1, newd);
            ps.setString(2, old);
            ps.executeUpdate();
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public ArrayList getDepartments() {
        ArrayList al = new ArrayList();
        try {

            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from departments");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al.add(rs.getString("department"));
            }
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }

    public boolean checkDepartment(String dept) {
        try {
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from departments where department=?");
            ps.setString(1, dept);
            ResultSet rs = ps.executeQuery();
            boolean rval = rs.next();
            dbConnector.close();
            return rval;
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean addDepartment(String dept) {
        try {
            if (!checkDepartment(dept)) {
                dbConnector = new DBConnect();
                PreparedStatement ps = dbConnector.con.prepareStatement("insert into departments(department) values (?)");
                ps.setString(1, dept);
                int rs = ps.executeUpdate();
                dbConnector.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean editDepartment(String oldDept, String dept) {
        try {
            if (!checkDepartment(dept)) {
                dbConnector = new DBConnect();
                PreparedStatement ps = dbConnector.con.prepareStatement("update departments set department=? where department=?");
                ps.setString(1, dept);
                ps.setString(2, oldDept);
                int rs = ps.executeUpdate();
                dbConnector.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList getUsersByDepartment(String department) {
        ArrayList al = new ArrayList();
        try {
            int did = getIdDepartment(department);
            System.out.println("dept "+did);
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from employees where department = ?");
            ps.setInt(1,did);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] p = {rs.getString("username"),rs.getString("employeeId")};
                al.add(p);
            }
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    public ArrayList getAllUsers() {
        ArrayList al = new ArrayList();
        try {
            
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from employees");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString("username"),rs.getString("ip"), rs.getString("phone"), rs.getString("employeeId"),rs.getInt("department"));
                al.add(u);
            }
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("Function done");
        return al;
    }
    public String getDepartmentById(int id) {
        String c = null;
        try {
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from departments where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = rs.getString("department");
            }
            dbConnector.close();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public User getUserByEmpId(String empId) {
        try {
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from employees where employeeId = ?");
            ps.setString(1, empId);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? new User(rs.getString("username"), rs.getString("ip"), rs.getString("phone"), rs.getString("employeeId"), rs.getInt("department")) : null;
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void deleteUser(String empId){
        try {
            dbConnector = new DBConnect();
            System.out.println("delete "+empId);
            PreparedStatement ps = dbConnector.con.prepareStatement("delete from employees where employeeId = ?");
            ps.setString(1, empId);
            ps.executeUpdate();
            dbConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getIdDepartment(String department) {
        try {
            dbConnector = new DBConnect();
            PreparedStatement ps = dbConnector.con.prepareStatement("select * from departments where department = ?");
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            int c = 0;
            if (rs.next()) {
                c = rs.getInt("id");
            }
            rs.close();
            dbConnector.close();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}


