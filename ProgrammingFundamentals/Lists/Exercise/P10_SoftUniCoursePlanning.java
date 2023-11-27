package ProgrammingFundamentals.Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> topics = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")) {

            String[] inputArgs = input.split(":");
            String command = inputArgs[0];

            if (command.equals("Add")) {
                //Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
                String topicToAdd = inputArgs[1];

                if (!topics.contains(topicToAdd)) {
                    topics.add(topicToAdd);
                }
            } else if (command.equals("Insert")) {
                //Insert:{lessonTitle}:{index} - insert the lesson to the given index, if it does not exist
                String topicToInsert = inputArgs[1];
                int index = Integer.parseInt(inputArgs[2]);

                if (!topics.contains(topicToInsert)) {
                    topics.add(index, topicToInsert);
                }
            } else if (command.equals("Remove")) {
                //Remove:{lessonTitle} - remove the lesson, if it exists
                String topicToRemove = inputArgs[1];
                String exerciseToRemove = topicToRemove + "-Exercise";

                topics.remove(topicToRemove);
                topics.remove(exerciseToRemove);
            } else if (command.equals("Swap")) {
                //Swap:{lessonTitle}:{lessonTitle} - change the place of the two lessons, if they exist
                String topic1 = inputArgs[1];
                String topic2 = inputArgs[2];
                String exerciseTopic1 = topic1 + "-Exercise";
                String exerciseTopic2 = topic2 + "-Exercise";

                if (topics.contains(topic1) && topics.contains(topic2)) {
                    int indexOfTopic1 = topics.indexOf(topic1);
                    int indexOfTopic2 = topics.indexOf(topic2);

                    topics.set(indexOfTopic1, topic2);
                    topics.set(indexOfTopic2, topic1);

                    if (topics.contains(exerciseTopic1)) {
                        topics.remove(exerciseTopic1);

                        int currentIndexOfTopic1 =  topics.indexOf(topic1);
                        topics.add(currentIndexOfTopic1 + 1, exerciseTopic1);
                    } else if (topics.contains(exerciseTopic2)) {
                        topics.remove(exerciseTopic2);

                        int currentIndexOfTopic2 =  topics.indexOf(topic2);
                        topics.add(currentIndexOfTopic2 + 1, exerciseTopic2);
                    }
                }
            } else if (command.equals("Exercise")) {
                //Exercise:{lessonTitle} - add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already, in the following format: "{lessonTitle}-Exercise".
                // If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.

                String topicToAddExercise = inputArgs[1];
                String exercise = topicToAddExercise + "-Exercise";

                if (topics.contains(topicToAddExercise) && !topics.contains(exercise)) {
                    int topicIndex = topics.indexOf(topicToAddExercise);

                    topics.add(topicIndex + 1, exercise);
                } else if (!topics.contains(topicToAddExercise)) {
                    topics.add(topicToAddExercise);
                    topics.add(exercise);
                }
            }


            input = scanner.nextLine();
        }

        int position = 1;
        for (String currentTopic : topics) {
            System.out.printf("%d.%s\n", position, currentTopic);
            position++;
        }
    }
}
