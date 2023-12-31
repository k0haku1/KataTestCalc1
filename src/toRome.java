public class toRome
{
    public static void intToRoman(int num) throws Exception
    {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1,3};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I","III"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        if(num >= 0){
            System.out.println(roman);
        }else {
            throw new Exception();
        }

    }
}

