import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

public class prg {
    private List<Question> quizQuestions;
    private int currentQuestionIndex;
    private int userScore;
    private Timer timer;

    public prg() {
        this.quizQuestions = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.userScore = 0;

        quizQuestions.add(new Question("What is the capital of France?",
                List.of("A. Berlin", "B. Paris", "C. Madrid", "D. Rome"), 1));
        quizQuestions.add(new Question("Which programming language is used for Android app development?",
                List.of("A. Java", "B. Python", "C. C++", "D. Ruby"), 0));

    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz Program!");
        timer = new Timer();
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < quizQuestions.size()) {
            Question currentQuestion = quizQuestions.get(currentQuestionIndex);
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestionText());
            for (String option : currentQuestion.getOptions()) {
                System.out.println(option);
            }

            startTimer();
            getUserAnswer();
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        int timeLimitInSeconds = 10; // Adjust the time limit as needed
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                stopTimer();
                currentQuestionIndex++;
                displayNextQuestion();
            }
        }, timeLimitInSeconds * 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private void getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = null;

        try {
            System.out.print("Enter your answer (A, B, C, or D): ");
            userAnswer = scanner.nextLine().toUpperCase();
            if (!userAnswer.matches("[A-D]")) {
                throw new IllegalArgumentException("Invalid input. Please enter A, B, C, or D.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            getUserAnswer();
        }

        stopTimer();

        Question currentQuestion = quizQuestions.get(currentQuestionIndex);
        if (userAnswer.equals(getOptionLetter(currentQuestion.getCorrectOptionIndex()))) {
            System.out.println("Correct!");
            userScore++;
        } else {
            System.out.println(
                    "Incorrect. The correct answer was: " + getOptionLetter(currentQuestion.getCorrectOptionIndex()));
        }

        currentQuestionIndex++;
        displayNextQuestion();
    }

    private String getOptionLetter(int optionIndex) {
        return String.valueOf((char) ('A' + optionIndex));
    }

    private void endQuiz() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your final score: " + userScore + "/" + quizQuestions.size());

        System.exit(0);
    }

    public static void main(String[] args) {
        prg p = new prg();
        p.startQuiz();
    }
}
