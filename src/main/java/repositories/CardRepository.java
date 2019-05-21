package repositories;

import connectivity.DatabaseConnection;
import models.Card;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardRepository {

    private DatabaseConnection connection = DatabaseConnection.getInstance();

    public void saveCard(Card card){
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("INSERT INTO card VALUES (NULL , ?, ?)");

            statement.setString(1, card.getOwner());
            statement.setDouble(2, card.getBalance());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Card getCardByOwner(String owner){
        Card card = new Card();

        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * FROM card WHERE owner = ?");
            statement.setString(1, owner);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                card.setId(resultSet.getInt("ID"));
                card.setOwner(resultSet.getString("Owner"));
                card.setBalance(resultSet.getDouble("Balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }
}
