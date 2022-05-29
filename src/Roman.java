import java.util.Arrays;
import java.util.Comparator;

enum Roman {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);
    int value;

    Roman(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    static Roman[] getReverseSortedArray() {
        return Arrays.stream(Roman.values())
                .sorted(Comparator.comparing((Roman e) -> e.value).reversed()).toArray(Roman[]::new);
    }
}
