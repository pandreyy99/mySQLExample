package repositories;

import connectivity.DatabaseConnection;
import models.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private DatabaseConnection connection = DatabaseConnection.getInstance();

    public void saveTransaction(Transaction transaction, int cardId){
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("INSERT INTO transaction VALUES (null ,?, ?, ?)");

            statement.setString(1, transaction.getMerchant());
            statement.setDouble(2, transaction.getAmount());

            statement.setInt(3, cardId);


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Transaction> getTransactions(){
        List<Transaction> transactions = new ArrayList<Transaction>();
        String sql = "SELECT * FROM transaction";

        try {
            PreparedStatement preparedStatement = connection.getConnection()
                    .prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setMerchant(resultSet.getString("merchant"));
                transaction.setAmount(resultSet.getDouble("amount"));
                /**
                 * to do card select
                 * CardRepository cardRepository =
                 */

                transactions.add(transaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
