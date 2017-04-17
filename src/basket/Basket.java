/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basket;

import persistence.BasketJDBC;
import model.Player;
import model.Team;
import model.pos;
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
            Team team1 = new Team("Stucom1", "Barcelona", LocalDate.now());
            //ex 1
            System.out.println("Insertando equipo...");
            conexion.insertTeam(team1);
            System.out.println("Equipo insertado con éxito");

            System.out.println("Estableciendo la conexión con el servidor...");
            Team team2 = new Team("lospatatas1", "Barcelona", LocalDate.now());
            //ex 1
            System.out.println("Insertando equipo...");
            conexion.insertTeam(team2);
            System.out.println("Equipo insertado con éxito");

            //ex2
            Player player1 = new Player("Magner", LocalDate.now(), 100, 100, 100, pos.alero , team1);
            Player player2 = new Player("Jandol", LocalDate.now(), 200, 200, 200, pos.base, team2);
             Player player3 = new Player("Marine", LocalDate.now(), 300, 300, 30000, pos.escolta, team1);
            Player player4 = new Player("mariaDelaOH", LocalDate.now(), 400, 300, 40000, pos.pivot, team2);

            conexion.insertPlayer(player1);
            conexion.insertPlayer(player2);
            conexion.insertPlayer(player3);
            conexion.insertPlayer(player4);

            System.out.println("Jugadores dados de alta...");
            System.out.println("");

        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        } finally {
            try {
                conexion.desconectar();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar " + ex.getMessage());
            }
        }
    }
}
