/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.*;

/**
 *
 * @author OlivierTroussard
 */
public class ConnexionBD {
    
    private static String url = "jdbc:mysql://mysql-hdc.alwaysdata.net:3306/hdc"; //à créer
    private static String user = "hdc_db";
    private static String passwd = "java";
    private static Connection connect;
    
    //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static Connection getInstance() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
