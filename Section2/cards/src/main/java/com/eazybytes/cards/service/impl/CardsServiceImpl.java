package com.eazybytes.cards.service.impl;

import com.eazybytes.cards.constant.CardsConstants;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Cards;
import com.eazybytes.cards.exception.CardAlreadyExistException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardsMapper;
import com.eazybytes.cards.repository.CardsRepository;
import com.eazybytes.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {
    private CardsRepository cardsRepository;

    /**
     *
     * @param mobileNumber of customer
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> card = cardsRepository.findByMobileNumber(mobileNumber);
        if (card.isPresent()) {
            throw new CardAlreadyExistException("Card already registered with given number "+mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
        System.out.println(card);
    }
    /**
     *
     * @param mobileNumber
     * @return the new card
     */
    public Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit((long) CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0L);
        newCard.setAvailableAmount((long) CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }
    /**
     *
     * @param mobileNumber
     * @return card details based on given mobile number
     */
    @Override
    public CardsDto getCardDetails(String mobileNumber) {
        Cards card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        CardsDto cardsDto = new CardsDto();
        return CardsMapper.CardsToCardsDto(card, cardsDto);
    }

    /**
     *
     * @param cardsDto
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateCardDetails(CardsDto cardsDto) {
        Cards card = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", cardsDto.getMobileNumber())
        );
        CardsMapper.CardsDtoToCards(cardsDto,card);
        cardsRepository.save(card);
        return true;
    }

    /**
     *
     * @param mobileNumber
     * @return boolean indicating if the delete of card details is successful or not
     */
    @Override
    public boolean deleteCardDetails(String mobileNumber) {
        Cards card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardsRepository.delete(card);
        return true;
    }

}
