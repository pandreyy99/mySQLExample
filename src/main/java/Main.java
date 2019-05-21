import services.CardService;
import services.TransactionService;

public class Main {
    public static void main(String[] args) {
        CardService cardService = new CardService();

//        cardService.saveCard();

        TransactionService transactionService = new TransactionService();

        transactionService.saveTransaction("Ion");
        transactionService.saveTransaction("Vasile");
        transactionService.getTransactions();
    }
}
