package ProgrammingFundamentals.RegularMidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03_ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chatLogger = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String command = input.split(" ")[0];

            if (command.equals("Chat")) {
                String msgToAdd = input.split(" ")[1];
                chatLogger.add(msgToAdd);
            } else if (command.equals("Delete")) {
                String msgToDelete = input.split(" ")[1];
                chatLogger.remove(msgToDelete);
            } else if (command.equals("Edit")) {
                String msgToEdit = input.split(" ")[1];
                String editedMsg = input.split(" ")[2];

                if (chatLogger.contains(msgToEdit)) {
                    int idxOfMsgToEdit = chatLogger.indexOf(msgToEdit);
                    chatLogger.set(idxOfMsgToEdit, editedMsg);
                }
            } else if (command.equals("Pin")) {
                String pinnedMsg = input.split(" ")[1];
                if (chatLogger.contains(pinnedMsg)) {
                    chatLogger.remove(pinnedMsg);
                    chatLogger.add(pinnedMsg);
                }
            } else if (command.equals("Spam")) {
                String[] allSpamMsg = input.split(" ");

                for (int i = 1; i <= allSpamMsg.length - 1; i++) {
                    String currentMsg = allSpamMsg[i];

                    chatLogger.add(currentMsg);
                }
            }
        }

        for (String currentMsg : chatLogger) {
            System.out.println(currentMsg);
        }
    }
}
