package v2.myPractice;

import java.util.HashSet;

public class UniqueEmails {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            int index = emails[i].indexOf('@');
            String mail = emails[i].substring(0, index);
            int plusIndex = mail.indexOf('+');
            if (plusIndex != -1) {
                mail = mail.substring(0, plusIndex);
            }
            StringBuilder sb = new StringBuilder();
            char[] mailCharArray = mail.toCharArray();
            for (int k = 0; k < mailCharArray.length; k++) {
                if (mailCharArray[i] != '.') {
                    sb.append(mailCharArray[i]);
                }
            }
            sb.append(emails[i].substring(index));
            hashSet.add(sb.toString());
        }
        return hashSet.size();
    }
}
