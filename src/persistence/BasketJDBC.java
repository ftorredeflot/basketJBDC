package persistence;

import model.Player;
import model.Team;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ferran
 */
public class BasketJDBC {

    private Connection conexion;

    public BasketJDBC() {

    }

    public void insertTeam(Team team) throws SQLException {
        String insert = "insert into team values(?,?,?)";
        PreparedStatement preparedStatement = conexion.prepareStatement(insert);
        preparedStatement.setString(1, team.getName());
        preparedStatement.setString(2, team.getLocation());
        preparedStatement.setDate(3, Date.valueOf(team.getFundation()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void insertPlayer(Player player) throws SQLException {
        String insert = "insert into player values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = conexion.prepareStatement(insert);
        preparedStatement.setString(1, player.getName());
        preparedStatement.setDate(2, Date.valueOf(player.getBorn()));
        preparedStatement.setInt(3, player.getnBaskets());
        preparedStatement.setInt(4, player.getnAssists());
        preparedStatement.setInt(5, player.getnRebots());
        preparedStatement.setString(6, player.getPos());
        preparedStatement.setString(7, player.getTeam().getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updatePlayer(Player player, int canastas, int asistencias, int rebotes) throws SQLException {
        PreparedStatement psu = conexion.prepareStatement("UPDATE player set nbaskets = ?, nassists = ?, nrebounds = ? WHERE name = ?");
        psu.setInt(1, canastas);
        psu.setInt(2, asistencias);
        psu.setInt(3, rebotes);
        psu.setString(4, player.getName());
        psu.executeUpdate();
        psu.close();
    }
    
    public void changePlayerTeam(Player player,Team team) throws SQLException {
        PreparedStatement psu = conexion.prepareStatement("UPDATE player set team=? WHERE name = ?");
        psu.setString(1, team.getName());
        psu.setString(2, player.getName());
        psu.executeUpdate();
        psu.close();
    }

    public void connect() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/basket", "jdbc", "patata");
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

}
