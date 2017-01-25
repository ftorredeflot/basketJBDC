/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basket;

import persistence.BasketJDBC;
import model.Player;
import model.Team;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 *
 * @author ferran
 */
public class Basket {

    public static void main(String[] args) {
        BasketJDBC conexion = new BasketJDBC();
        try {   
            conexion.connect();
            
            System.out.println("Estableciendo la conexión con el servidor...");
            Team team = new Team("Stucom","Barcelona",LocalDate.now());
            //ex 1
            System.out.println("Insertando equipo...");
            conexion.insertTeam(team);
           System.out.println("Equipo insertado con éxito");
           
           
             System.out.println("Estableciendo la conexión con el servidor...");
            Team team2 = new Team("lospatatas","Barcelona",LocalDate.now());
            //ex 1
            System.out.println("Insertando equipo...");
            conexion.insertTeam(team2);
           System.out.println("Equipo insertado con éxito");
           //ex2
           
           
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        } finally {
            try {
                conexion.desconectar();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
               System.out.println("Error al desconectar "+ex.getMessage());
            }
        }
    }
}


