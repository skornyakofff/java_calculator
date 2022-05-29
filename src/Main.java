import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputString;
        Scanner in = new Scanner(System.in);
        inputString = in.nextLine();

        try {
            System.out.print(calc(inputString));
        } catch (Exception e) {
            System.out.print(e.getMessage());
            System.exit(1);
        }
    }
    static String calc(String input) throws Exception {
        String[] values = input.split(" ");
        if(values.length != 3)
            throw new Exception("throws Exception");

        try {
            System.out.println(calculator(Integer.parseInt(values[0]), Integer.parseInt(values[2]), values[1].toCharArray()[0], false));

        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                checkCount(values[0]);
                checkCount(values[2]);
                return toRoman(calculator(Integer.parseInt(toArabic(values[0].toUpperCase())),
                        Integer.parseInt(toArabic(values[2].toUpperCase())), values[1].toCharArray()[0], true));
            }
            else throw new Exception("throws Exception");
        }
        return null;
        /*if (values[0].compareTo("1") >= 0 && values[0].compareTo("10") <= 0
                && values[2].compareTo("1") >= 0 && values[2].compareTo("10") <= 0) {
            return Integer.toString(arabicCalc(Integer.parseInt(values[0]), Integer.parseInt(values[2]), values[1].toCharArray()[0], false));
        }
        else if()*/
    }
    static int calculator(int a, int b, char operation, boolean flag) throws Exception {
        switch(operation) {
            case '+': {
                return a + b;
            }

            case '-': {
                if(flag && a - b < 0)
                    throw new Exception("throws Exception");
                else return a - b;
            }

            case '*': {
                return a * b;
            }

            case '/': {
                return a / b;
            }

            default: {
                throw new Exception("throws Exception");
            }
        }
    }
    static String toRoman(int number) {
        StringBuilder result = new StringBuilder();
        for(Roman key: Roman.getReverseSortedArray()) {
            while(number >= key.getValue()) {
                number -= key.getValue();
                result.append(key);
            }
        }
        return result.toString();
    }
    static String toArabic(String number) throws Exception {
        int result = 0;
        for(Roman key: Roman.getReverseSortedArray()) {
            while(number.startsWith(key.name())) {
                result += key.getValue();
                number = number.replaceFirst(key.name(), "");
            }
        }
        if(number.compareTo("") != 0 || result > 10)
            throw new Exception("throws Exception");
        return Integer.toString(result);
    }
    static void checkCount(String number) throws Exception {
        if(number.length() - number.replace("I", "").length() > 3
                || number.length() - number.replace("V", "").length() > 3
                || number.length() - number.replace("X", "").length() > 3
                || number.length() - number.replace("L", "").length() > 3
                || number.length() - number.replace("C", "").length() > 3)
            throw new Exception("throws Exception");
    }
}