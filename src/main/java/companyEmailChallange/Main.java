package companyEmailChallange;

import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        SolutionJava solution = new SolutionJava();
        System.out.println(solution.solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
    }
}

class SolutionJava {
    public String solution(String S, String C) {
        if (Objects.equals(S, "")) return "";
        String companyName;
        String separator = "; ";
        String[] names = S.split(separator);
        StringBuilder result = new StringBuilder();
        HashSet<String> userNamesBank = new HashSet<>();
        companyName = limitToEightLetter(C).toLowerCase();

        for (String name : names) {
            result.append(name).append(" ");
            String userName = generateEmailUserName(name);
            int nameCounter = 1;
            String tempUserName = userName;

            while (userNamesBank.contains(tempUserName)) {
                tempUserName = tempUserName.replace(Integer.toString(nameCounter), "");
                nameCounter++;
                tempUserName = tempUserName + nameCounter;
            }
            userName = tempUserName;
            userNamesBank.add(userName);

            result.append("<").append(userName).append("@").append(companyName).append(".com>").append(separator);
        }
        return result.toString();
    }

    private String generateEmailUserName(String name) {
        String[] singleName = name.split(" ");
        int size = singleName.length;
        singleName[size - 1] = singleName[size - 1].replace("-", "");

        limitToEightLetter(singleName[size - 1]);

        if (size == 3) {
            return singleName[0].toLowerCase() + singleName[2].toLowerCase().replace(" ", ".");
        } else {
            return singleName[0].toLowerCase() + singleName[1].toLowerCase().replace(" ", ".");
        }
    }

    private String limitToEightLetter(String string) {
        if (string.length() > 8) {
            return string.substring(0, 8);
        } else {
            return string;
        }
    }
}