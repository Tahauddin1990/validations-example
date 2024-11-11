package com.tahauddin.syed.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrepaidCardRequest {

    private String id;
    @NotNull(message = "{prepaidCards.cardName.notNull}") private String cardName;
    @NotNull(message = "{prepaidCards.cardType.notNull}") private String cardType;
    @NotNull(message = "{prepaidCards.amount.notNull}")
    @Min(value = 1l ,message = "{prepaidCards.amount.min}") private Double amount;private String charges;
    @NotNull(message = "{prepaidCards.deliveryMethod.notNull}") private String deliveryMethod;
    @NotNull(message = "{prepaidCards.fromAccount.notNull}") private String fromAccount;

}
