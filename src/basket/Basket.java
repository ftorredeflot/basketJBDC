package basket;

import persistence.BasketJDBC;
import model.Player;
import model.Team;
import model.pos;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Stats;

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
            Player player1 = new Player("Magner", LocalDate.now(), 100, 100, 100, pos.alero, team1);
            Player player2 = new Player("Jandol", LocalDate.now(), 200, 200, 200, pos.base, team2);
            Player player3 = new Player("Marine", LocalDate.now(), 300, 300, 30000, pos.escolta, team1);
            Player player4 = new Player("mariaDelaOH", LocalDate.now(), 400, 300, 40000, pos.pivot, team2);

            conexion.insertPlayer(player1);
            conexion.insertPlayer(player2);
            conexion.insertPlayer(player3);
            conexion.insertPlayer(player4);

            System.out.println("Jugadores dados de alta...");
            System.out.println("");
            //ex3

            System.out.println("Modifcar jugador: " + player1.getName());
            conexion.updatePlayer(player1, 1000, 1000, 1000);
            System.out.println(player1.getName() + " modificado con éxito");
            System.out.println("");
            //ex4
            System.out.println("Modifcar jugador: " + player2.getName());
            conexion.changePlayerTeam(player2, team1);
            System.out.println(player2.getName() + " modificado con éxito");
            System.out.println("");
            //ex5
            System.out.println("Eliminar Jugador: " + player3.getName());
            conexion.deletePlayer(player3);
            System.out.println(player3.getName() + " eliminado con éxito");
            System.out.println("");
            //ex6
            System.out.println("Otener jugador: " + player4.getName());
            System.out.println(conexion.selectPlayerByName("mariaDelaOH").toString());
            System.out.println("");

            //ex7
            System.out.println("Obtener jugadores por la letra J");

            for (Player players : conexion.selectPlayerByNameLike("J")) {
                System.out.println(players.toString());
            }
            System.out.println("");
            //ex8
            System.out.println("Jugadores con 200 o más canastas: ");
            for (Player players : conexion.selectPlayerByBaskets(0, 200)) {
                System.out.println(players.toString());
            }

            //ex9
            System.out.println("Jugadores con asistencias entre 50 y 250: ");
            for (Player players : conexion.selectPlayerByAssists(50, 250)) {
                System.out.println(players.toString());
            }
            //ex10
            System.out.println("Jugadores que jueguen la posicion " + pos.base + ": ");

            for (Player players : conexion.selectPlayerByPosition(pos.base)) {
                System.out.println(players.toString());
            }

            //ex11
            System.out.println("Jugadores que hayan nacido en una fecha anterior a una fecha especificada: ");
            for (Player players : conexion.selectPlayerByBirth(Date.valueOf(LocalDate.now()))) {
                System.out.println(players.toString());
            }
            System.out.println("");

            //ex12
            System.out.println("Estadisticas de jugadores agrupados por posicion: ");
            for (Stats stats : conexion.selectAllPlayersAvgMaxMinStatsGroupByPosition()) {
                System.out.println(stats.toString());
            }
            System.out.println("");
            //ex13
            System.out.println("Ranking de jugadores por número de canastas: ");
            int nPos = 1;
            for (Player players : conexion.selectPlayerOByNbaskets()) {
                System.out.print("Pos: " + nPos);
                System.out.println(" Nombre: " + players.getName() + " Canastas: " + players.getnBaskets());
                nPos++;
            }
            System.out.println("");
            //ex14

            int posR = 2; //posicion que buscamos
            int currPos = 1;
            System.out.println("Jugador por posición en el ranking [" + posR + "]: ");
            for (Player players : conexion.selectPlayerOByNbaskets()) {
                if (currPos == posR) {
                    System.out.println("Nombre: " + players.getName());
                }
                currPos++;
            }
            System.out.println("");
//ex15
            System.out.println("Equipos por localidad: " + team2.getLocation());
            for (Team teams : conexion.selectTeamByCity(team2.getLocation())) {
                System.out.println(teams.toString());
            }
            System.out.println("");
//ex16
            System.out.println("Jugadores por equipo: " + team1.getName());
            for (Player players : conexion.selectPlayersByTeam(team1.getName())) {
                System.out.println(players.toString());
            }
            System.out.println("");
//ex17

            System.out.println("Jugadores por equipo et posición: " + team1.getName() + " " + pos.base);
            for (Player players : conexion.selectPlayersByTeamAndPosition(team1.getName(), pos.base)) {
                System.out.println(players.toString());
            }
            System.out.println("");
//ex18
            System.out.println("Jugador con más canastas del equipo: " + team1.getName());
            System.out.println(conexion.selectPlayersMaxCanastasByTeam(team1.getName()).toString());
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
