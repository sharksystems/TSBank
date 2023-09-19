package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currencies {
    RUPEE("Rupee"),
    DOLLAR("Dollar"),
    POUND("Pound");
    private final String currency;
}
