package practice.algorithms.recursion;
/*
* print the instructions
* */
public class TowerOfHanoi {

    public static void toh(int n, char from, char to,char aux){
        if(n == 0)
            return;
        toh(n-1,from,aux,to);
        System.out.println(String.format("Disk %d from rod %c to rod %c",n,from,to));
        toh(n-1,aux,to,from);
    }

    public static void main(String[] args) {
        toh(4,'A','C','B');
    }
}
