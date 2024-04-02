package com.example.quizapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ResultController {
    @FXML
    private Button playAgain;
    @FXML
    public Label remark, marks, marksText, correctText, wrongText;

    @FXML
    public ProgressIndicator correct_progress, wrong_progress;

    int correct;
    int wrong;

    @FXML
    private void initialize() {
        correct = QuizController.correct;
        wrong = QuizController.wrong;

        correctText.setText("Correct Answers : " + correct);
        wrongText.setText("Incorrect Answers : " + String.valueOf(QuizController.wrong));

        marks.setText(correct + "/10");
        float correctF = (float) correct/10;
        correct_progress.setProgress(correctF);
        float wrongF = (float) wrong/10;
        wrong_progress.setProgress(wrongF);
        marksText.setText(correct + " Marks Scored");

        if (correct<2) {
            remark.setText("Oh no..! You have failed the quiz. Check your results here.");
        } else if (correct>=2 && correct<5) {
            remark.setText("Oops..! You have scored less marks. A bit more improvement might help you to get better results Check your results here.");
        } else if (correct>=5 && correct<=7) {
            remark.setText("Good job .  Check your results here.");
        } else if (correct==8 || correct==9) {
            remark.setText("Congratulations! you got to score good marks. Check you results here.");
        } else if (correct==10) {
            remark.setText("Congratulations! You have passed the quiz with full marks. Check your results here.");
        }

        // play again button
        playAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    thisstage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    scene.setFill(Color.TRANSPARENT);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



}
