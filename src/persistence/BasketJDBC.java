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

    public void changePlayerTeam(Player player, Team team) throws SQLException {
        PreparedStatement psu = conexion.prepareStatement("UPDATE player set team=? WHERE name = ?");
        psu.setString(1, team.getName());
        psu.setString(2, player.getName());
        psu.executeUpdate();
        psu.close();
    }

    public void deletePlayer(Player player) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement("DELETE FROM player WHERE name=? ");
        pst.setString(1, player.getName());
        pst.executeUpdate();
        pst.close();
    }

    public Player selectPlayerByName(String name) throws SQLException {
        PreparedStatement selectTable = conexion.prepareStatement("SELECT * FROM player WHERE name = ?");
        selectTable.setString(1, name);
        ResultSet result = selectTable.executeQuery();
        Player player = new Player();
        if (result.next()) {
            player.setName(result.getString("name"));
            player.setBorn(result.getDate("birth").toLocalDate());
            player.setnAssists(result.getInt("nassists"));
            player.setnBaskets(result.getInt("nbaskets"));
            player.setnRebots(result.getInt("nrebounds"));
            player.setPos(result.getString("position"));
            player.setTeam(selectTeamByName(result.getString("team")));
        }
        result.close();
        selectTable.close();
        return player;
    }

    public Team selectTeamByName(String name) throws SQLException {
        PreparedStatement selectTable = conexion.prepareStatement("SELECT * FROM team WHERE name = ?");
        selectTable.setString(1, name);
        ResultSet result = selectTable.executeQuery();
        Team team = new Team();
        if (result.next()) {
            team.setName(result.getString("name"));
            team.setLocation(result.getString("city"));
            team.setFundation(result.getDate("creation").toLocalDate());
        }
        result.close();
        selectTable.close();
        return team;

    }

    public List<Player> selectPlayerByNameLike(String like) throws SQLException {
        PreparedStatement selectTable = conexion.prepareStatement("select * from player WHERE name LIKE '%" + like + "%'");
        ResultSet result = selectTable.executeQuery();
        ArrayList players = new ArrayList();
        while (result.next()) {
            Player player = new Player();
            player.setName(result.getString("name"));
            player.setBorn(result.getDate("birth").toLocalDate());
            player.setnAssists(result.getInt("nassists"));
            player.setnBaskets(result.getInt("nbaskets"));
            player.setnRebots(result.getInt("nrebounds"));
            player.setPos(result.getString("position"));
            player.setTeam(selectTeamByName(result.getString("team")));
            players.add(player);
        }
        result.close();
        selectTable.close();
        return players;

    }

    public List<Player> selectPlayerByBaskets(Integer min, Integer max) throws SQLException {
        PreparedStatement selectTable = conexion.prepareStatement("select * from player where nbaskets >= " + min + " && nbaskets <= " + max + "");
        ResultSet result = selectTable.executeQuery();
        ArrayList players = new ArrayList();
        while (result.next()) {
            Player player = new Player();
            player.setName(result.getString("name"));
            player.setBorn(result.getDate("birth").toLocalDate());
            player.setnAssists(result.getInt("nassists"));
            player.setnBaskets(result.getInt("nbaskets"));
            player.setnRebots(result.getInt("nrebounds"));
            player.setPos(result.getString("position"));
            player.setTeam(selectTeamByName(result.getString("team")));
            players.add(player);
        }
        result.close();
        selectTable.close();
        return players;

    }
    
        public List<Player> selectPlayerByAssists(Integer min, Integer max) throws SQLException {
        PreparedStatement selectTable = conexion.prepareStatement("select * from player where nassists >= " + min + " && nbaskets <= " + max + "");
        ResultSet result = selectTable.executeQuery();
        ArrayList players = new ArrayList();
        while (result.next()) {
            Player player = new Player();
            player.setName(result.getString("name"));
            player.setBorn(result.getDate("birth").toLocalDate());
            player.setnAssists(result.getInt("nassists"));
            player.setnBaskets(result.getInt("nbaskets"));
            player.setnRebots(result.getInt("nrebounds"));
            player.setPos(result.getString("position"));
            player.setTeam(selectTeamByName(result.getString("team")));
            players.add(player);
        }
        result.close();
        selectTable.close();
        return players;

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
