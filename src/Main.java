import java.util.Scanner;

public class Main {
    public static Type CheckIsValue(String num){
        Type type = Type.ARABIC;
        for(int i = 0; i < num.length(); i++) {
            if(!Character.isDigit(num.charAt(i))) {
                if (num.contains("X") || num.contains("V") || num.contains("I") || num.contains("L")
                        || num.contains("C") || num.contains("D") || num.contains("M")){
                    type = Type.ROME;
                }else {
                    type = Type.NON;
                }
            } else{
                type = Type.ARABIC;
            }
        }
        return type;
    }

    public static String calc(String nums)throws Exception{

        String[] a = nums.split("[\\+\\-\\*\\/]");

        String num1;
        String num2;

        if(a.length > 2 || a.length == 1){
            throw new Exception();
        }
        else{
            num1 = a[0];
            num2 = a[1];
        }

        Type num1Type = CheckIsValue(num1);
        Type num2Type = CheckIsValue(num2);

        if (num1Type == Type.ARABIC && num2Type == Type.ARABIC) {
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            if((n1 >= 1 && n1 <= 10) && (n2 >= 1 && n2 <= 10)){
                if(nums.contains("+")){
                    int sum = n1 + n2;
                    System.out.println(sum);
                } else if (nums.contains("-")) {
                    int sum = n1 - n2;
                    System.out.println(sum);
                } else if (nums.contains("/")){
                    int sum = n1 / n2;
                    System.out.println(sum);
                } else if (nums.contains("*")){
                    int sum = n1 * n2;
                    System.out.println(sum);
                } else {
                    throw new Exception();
                }
            }else{
                throw new Exception();
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
                throw new Exception();
            }
        } else if (num1Type == Type.NON && num2Type == Type.NON){
            throw new Exception();
        } else {
            throw new Exception();
        }
        return num1;
    }
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        String nums = scanner.nextLine();
        calc(nums);
    }
}
