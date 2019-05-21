package services;

import models.Card;
import models.Transaction;
import repositories.CardRepository;
import repositories.TransactionRepository;

import java.util.List;

public class TransactionService {

    private static TransactionRepository transactionRepository = new TransactionRepository();
    private static CardRepository cardRepository = new CardRepository();

    public void saveTransaction(String owner){
        Transaction transaction = new Transaction();

        transaction.setMerchant("Merchant 1");
        transaction.setAmount(300);

        Card card = cardRepository.getCardByOwner(owner);

        transactionRepository.saveTransaction(transaction, card.getId());
        System.out.println("Transaction saved!");
    }

    public void getTransactions(){
        List<Transaction> transactionList = transactionRepository.getTransactions();

//        for (Transaction t : transactionList)
//            System.out.println(t);

        transactionList.forEach(System.out::println);
    }
}
