package practice.algorithms.fastslowpointer;

class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
       for(int i=0;i<arr.length;i++){
           int slow = i;
           int fast = i;
           boolean isForward = arr[i] >0;
           do{
                slow = nextIndex(arr,isForward,slow);
                fast = nextIndex(arr,isForward,fast);
                if(fast != -1)
                    fast = nextIndex(arr,isForward,fast);
           }while(slow != -1 && fast != -1 && fast != slow);

           if(fast != -1 && fast == slow)
               return true;
       }


        return false;
    }
    public static int nextIndex(int[] arr, boolean isForward, int current){
        boolean direction = arr[current]>0;

        if(isForward != direction)
            return -1;

        int nextIndex = (current + arr[current])%arr.length;

        if(nextIndex < 0)
            nextIndex += arr.length;

        if(current == nextIndex)
            return -1;

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}