package practice.algorithms.twopointers;

public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        int i1=str1.length()-1,i2= str2.length()-1;
        while(i1 >=0 || i2 >=0 ){
            i1=findValidIndex(str1,i1);
            i2=findValidIndex(str2,i2);
            if(i1 <0 && i2 <0)
                return true;
            if(i1 <0 || i2<0)
                return false;

            if(str1.charAt(i1) != str2.charAt(i2))
                return false;

            i1--;
            i2--;
        }
        return true;
    }

    private static int findValidIndex(String str1, int i1) {
        int backspace=0;
        while(i1 >= 0) {
            if (str1.charAt(i1) == '#')
                backspace++;
            else if (backspace > 0)
                backspace--;
            else
                break;
            i1--;
        }
        return i1;
    }

    public static void main(String[] args) {
        System.out.println(compare("xy#z","xzz#")==true);
        System.out.println(compare("xy#z","xyz#")==false);
        System.out.println(compare("xp#","xyz##")==true);
        System.out.println(compare("xywrrmp","xywrrmu#p") == true);
    }
}
