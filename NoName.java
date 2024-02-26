public class NoName {
    public static void main(String[] args) {
        // String arr = getReverse("Farhaan");
        // System.out.println(arr);
        String str = "Farrhan";
        char[] ch = str.toCharArray();
        for(int i =0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
        str = ch.toString();
        System.out.println(str);

        }
//     reverse invidual works of a sentence using stack.
// (a word is completed if a empty space is encountered)
    public static String getReverseSentence(String str){
        String rev="";
        for(int i =0;i<str.length();i++){

        }

        return rev;
    }
    public static String getReverse(String str){
        char[] rev=str.toCharArray();
        System.out.println(rev.toString());
        int j=str.length()-1;
        int i=0;
        while(i<j){
            // rev[i]=rev[i]^rev[j];
            char temp = rev[i];
            rev[i++]=rev[j];
            rev[j--]=temp;
        }
        // str.valueOf
        // System.out.println(rev.toString());
        return rev.toString();
    }
}
