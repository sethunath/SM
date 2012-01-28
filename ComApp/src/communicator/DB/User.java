/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator.DB;

/**
 *
 * @author flyhigh
 */
public class User {

    public User(String username, String ip, String phone, String empId,int dept) {
        this.username = username;
        this.ip = ip;
        this.phone = phone;
        this.empId = empId;
        this.department = dept;
    }
    public User(){
        
    }

    public int getDepartment() {
        return department;
    }

    public String getDept() {
        return dept;
    }

    public String getEmpId() {
        return empId;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
    int id;
    String username;
    String ip;
    String phone;
    String empId;
    String dept;
    int department;
}