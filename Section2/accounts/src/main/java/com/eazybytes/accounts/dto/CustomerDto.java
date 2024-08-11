package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold customer and Account information"
)
public class CustomerDto {
    @Schema(
            name = "Name of customer",
            example = "Anushka Suryawanshi"
    )
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min=5,max = 30,message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            name = "Email of customer",
            example = "anushkasuryawanshi@gmail.com"
    )
    @NotEmpty(message = "Email address can not be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            name = "Mobile Number of customer",
            example = "9087654389"
    )
    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;
}
