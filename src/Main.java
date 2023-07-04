import java.util.Scanner;

public class Main {
    enum Type {
        ARABIC, ROME, NON
    }
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String nums;
        nums = scanner.nextLine();
        String[] a = nums.split("[\\+\\-\\*\\/]");

        String num1 = a[0];
        String num2 = a[1];

        Type num1Type = Type.ARABIC;
        Type num2Type = Type.ARABIC;

        for(int i = 0; i < num1.length(); i++) {
            if(!Character.isDigit(num1.charAt(i))) {
                if (num1.contains("X") || num1.contains("V") || num1.contains("I") || num1.contains("L")
                        || num1.contains("C") || num1.contains("D") || num1.contains("M")){
                    num1Type = Type.ROME;
                }else {
                    num1Type = Type.NON;
                }
            } else{
                num1Type = Type.ARABIC;
            }
        }
        for(int y = 0; y < num2.length(); y++) {
            if(!Character.isDigit(num2.charAt(y))) {
                if (num2.contains("X") || num2.contains("V") || num2.contains("I") || num2.contains("L")
                        || num2.contains("C") || num2.contains("D") || num2.contains("M")){
                    num2Type = Type.ROME;
                } else {
                    num2Type = Type.NON;
                }
            } else {
                num2Type = Type.ARABIC;
            }
        }

        if (num1Type == Type.ARABIC && num2Type == Type.ARABIC) {
            if(nums.contains("+")){
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                int sum = n1 + n2;
                System.out.println(sum);
            } else if (nums.contains("-")) {
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                int sum = n1 - n2;
                System.out.println(sum);
            } else if (nums.contains("/")){
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                int sum = n1 / n2;
                System.out.println(sum);
            } else if (nums.contains("*")){
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                int sum = n1 * n2;
                System.out.println(sum);
            } else {
                System.out.println("Операция не определена, напишите выражение!");
            }
        } else if (num1Type == Type.ROME && num2Type == Type.ROME) {
            toInteger str1 = new toInteger();
            int res1 = str1.convertToInt(num1);

            toInteger str2 = new toInteger();
            int res2 = str2.convertToInt(num2);

            if(nums.contains("+")){
                int sum = res1 + res2;
                toRome.intToRoman(sum);
            } else if(nums.contains("-")){
                int sum = res1 - res2;
                toRome.intToRoman(sum);
            } else if(nums.contains("/")){
                int sum = res1 / res2;
                toRome.intToRoman(sum);
            } else if(nums.contains("*")){
                int sum = res1 * res2;
                toRome.intToRoman(sum);
            } else {
                System.out.println("Операция не определена, напишите выражение!");
            }
        } else if (num1Type == Type.NON && num2Type == Type.NON){
            System.out.println("ОШИБКА");
        } else {
            System.out.println("ОШИБКА");
        }
    }
}
