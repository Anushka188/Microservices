package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardsDto;

public interface ICardsService {
    CardsDto getCardDetails(String mobileNumber);

    void createCard(String mobileNumber);

    boolean updateCardDetails(CardsDto cardsDto);

    boolean deleteCardDetails(String mobileNumber);
}
