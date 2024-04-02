package com.example.quizapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizController {

    @FXML
    public Label question;

    @FXML
    public Button opt1, opt2, opt3, opt4; // 4 button for options.
    static int counter = 0; //counter of number of the question.
    static int correct = 0; // count the correct answer.
    static int wrong = 0; // count the wrong answer.

    @FXML
    private void initialize() {loadQuestions();}

    private void loadQuestions() {
        List<String> answers = new ArrayList<>();
        answers.add(arr[counter].getCorrectAnswer());
        answers.add(arr[counter].getAnswer2());
        answers.add(arr[counter].getAnswer3());
        answers.add(arr[counter].getAnswer4());
        question.setText(arr[counter].getQuestion());
            Collections.shuffle(answers); // answers show randomly.
            opt1.setText(answers.get(0));
            opt2.setText(answers.get(1));
            opt3.setText(answers.get(2));
            opt4.setText(answers.get(3));
    }
    boolean checkAnswer(String answer) { //checking correct answer
        if (answer.equals(arr[counter].getCorrectAnswer())) return true;
            return false;
    }
    @FXML //getting the chosen answer
    public void optClicked(ActionEvent event) {
        final Button source = (Button) event.getSource();
        lastQuestion(source.getText(), event);
    }
    /*
      dealing with the last question,
      adding +1 to "correct" if the answer is correct, else add +1 to "wrong",
      if it is the last question we will load the result stage.
     */
    public void lastQuestion(String s, ActionEvent event){
        if (checkAnswer(s)) {
            correct++;
        } else {
            wrong++;
        }
        if (counter == arr.length-1) {
            counter=0;
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
                correct=0;
                wrong=0;
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }
    Question q1 = new Question("1. How many consonants are there in the English alphabet?", "21","20","19","22");
    Question q2 = new Question("2. Who invented the Light bulb?", "Thomas Alva Edison","Alexander Fleming","Charles Babbage","Albert Einstein");
    Question q3 = new Question("3. In the Solar System, farthest planet from the Sun is", "Neptune","Jupiter","Saturn","Uranus");
    Question q4 = new Question("4. Largest moon in the Solar System?", "Ganymede","Titan","Moon","Europa");
    Question q5 = new Question("5. Which of these is 'not' a property of metal?", "Non Ductile","Good Conduction","Malleable","Sonourous");
    Question q6 = new Question("6. Who discovered Pasteurisation?", "Louis Pasteur","Alexander Fleming","Simon Pasteur","William Pasteur");
    Question q7 = new Question("7. Hydrochloric acid (HCl) is produced by -?", "Stomach","Small Intestine","Liver","Oesophagus");
    Question q8 = new Question("8. The fastest animal in the world is -", "Cheetah","Lion","Black buck","Quarter Horse");
    Question q9 = new Question("9. Complementary colour of Red is -", "Green","Blue","Pink","Yellow");
    Question q10 = new Question("10. World Environment Day is on -", "5th June","15th June","25th June","5th July");
    Question[] arr = new Question[]{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

}

