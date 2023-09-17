package base;

import org.testng.annotations.Test;

public class Enums {
    public enum Currency {
        RUPEE("Rupee"),
        DOLLAR("Dollar"),
        POUND("Pound");
        private String label;

        Currency(String label) {
            this.label = label;
        }
        public String getLabel () {
            return label;
        }
    }
}
