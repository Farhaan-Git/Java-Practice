public class Bitmanipulation {
    public static byte get(int pos,int data){
        int bitmask = 1<<pos;
        int val = bitmask & data;
        if(val==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int set(int pos,int data){
        int bitmask = 1<<pos;
        int val = bitmask| data;
        return val;
    }
    public static int clear(int pos,int data){
        int bitmask = 1<<pos;
        int val = ~bitmask & data;
        return val;
    }
    public static int update(int pos, int data, byte updateTo){
        if(updateTo==0){
            return Bitmanipulation.clear(pos, data);
        }
        else{
            return Bitmanipulation.set(pos, data);
        }
    }
    public static void main(String[] args) {
        // byte val=Bitmanipulation.get(2, 3);
        // int val = Bitmanipulation.set(3, 5);
        int val = Bitmanipulation.clear(0, 1);
        System.out.println(val);
    }
}
