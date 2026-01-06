package zona_fit.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conect {
    public static Connection getConect(){
        Connection conect =  null;
        var dataBase = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/"+dataBase;
        var user =  "root";
        var password = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("Unexpected error in db connection: " + e.getMessage());
        }
        return conect;
    }

    public static void main(String[] args) {
        var con = Conect.getConect();
        if(con!=null){
            System.out.println("Succesfull connection..." + con);
        }else {
            System.out.println("Failed connection...");
        }
    }
}
