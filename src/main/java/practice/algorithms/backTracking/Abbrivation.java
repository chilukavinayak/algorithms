package practice.algorithms.backTracking;

public class Abbrivation{
    public static void main(String[] args) {
        solve("pep");
    }
    public static void solve(String str){
        solve(str,"",0,0);
    }
    public static void solve(String str, String ans, int count,int index){

        if(index == str.length()){
            if(count == 0)
                System.out.println(ans);
            else
                System.out.println(ans+count);
            return;
        }

        //we make two recursive calls
        // including element
        if(count > 0){
            solve(str,ans+count+str.charAt(index),0,index+1);
        }
        else{
            solve(str,ans+str.charAt(index),0,index+1);
        }
        // excluding element
        solve(str,ans,count+1,index+1);

    }
}