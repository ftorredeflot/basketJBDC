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
        preparedStatement.setString(1,team.getName());
        preparedStatement.setString(2,team.getLocation());
        preparedStatement.setDate(3, Date.valueOf(team.getFundation()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
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
