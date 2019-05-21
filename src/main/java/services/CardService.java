package services;

import models.Card;
import repositories.CardRepository;

public class CardService {

    private static CardRepository cardRepository = new CardRepository();

    public void saveCard(){
        Card card = new Card();
        card.setOwner("Ion");
        card.setBalance(3000);

        cardRepository.saveCard(card);
        System.out.println("Card saved!");
    }
}
