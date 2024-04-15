package com.example.ntu.examlist;

public class Exam {
    String examContent, examDay, examName;

    public Exam(String examContent, String examDay, String examName) {
        this.examContent = examContent;
        this.examDay = examDay;
        this.examName = examName;
    }

    public String getExamContent() {
        return examContent;
    }

    public void setExamContent(String examContent) {
        this.examContent = examContent;
    }

    public String getExamDay() {
        return examDay;
    }

    public void setExamDay(String examDay) {
        this.examDay = examDay;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
