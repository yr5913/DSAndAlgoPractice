package v2.myPractice;

public class CountAndSay {

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        return say(countAndSay(n-1));
    }

    public String say(String val) {
        char[] chars = val.toCharArray();
        StringBuilder sb = new StringBuilder();
        char prev = 'a';
        int count = 0;
        for (char current : chars) {

            if (prev != current) {
                if (count != 0) {
                    sb.append(count);
                    sb.append(prev);
                }
                prev = current;
                count = 1;
            } else {
                count++;
            }
        }
        if (count != 0) {
            sb.append(count);
            sb.append(prev);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new CountAndSay().countAndSay(4);
    }
}
