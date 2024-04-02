package com.example.quizapp;

public class Question {
    String question;
    String correctAnswer;
    String answer2;
    String answer3;
    String answer4;

    public Question(String q, String ca, String a2, String a3, String a4){
        this.question = q;
        this.correctAnswer = ca;
        this.answer2= a2;
        this.answer3= a3;
        this.answer4= a4;
    }

    public String getQuestion(){
        return this.question;
    }
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
    public String getAnswer2(){
        return this.answer2;
    }
    public String getAnswer3(){
        return this.answer3;
    }
    public String getAnswer4(){
        return this.answer4;
    }
}
