package com.eazybytes.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Cards",
        description = "Schema to hold Card information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardsDto {
    @NotEmpty(message = "Mobile number can not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
    @Schema(
            description = "Mobile Number of Customer", example = "4354437687"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card number can not be empty")
    @Pattern(regexp = "^[0-9]{12}$", message = "Invalid card number")
    @Schema(
            description = "Card Number of the customer", example = "100646930341"
    )
    private String cardNumber;

    @NotEmpty(message = "Card type can not be empty")
    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "Total card limit should not be greater then zero")
    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    private Long totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    @Schema(
            description = "Total amount used by Customer", example = "10000"
    )
    private Long amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    private Long availableAmount;
}
