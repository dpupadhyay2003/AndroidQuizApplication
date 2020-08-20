package com.lambton.projectquiz;

public class QuestionList {

    private String[] question = {
            "What does HTML Stand for ?",       // Radio Button
            "What is the correct HTML tag for inserting a line break?", // Radio Button
            "Select All HTML Tags for Heading?",// CheckBox
            "What is the correct HTML for creating a hyperlink?",   // Button
            "Which of these tags are all <table> tags?",        // Button
            "What is the correct HTML for inserting an image?", //List View
            "How can you make a numbered list?",    // List View
            "Which is the correct CSS syntax?",     // CheckBox
    };

    private String[][] answers = {
            {"Hyperlinks and Text Markup Language", "Hyper Text Markup Language", "Home Tool Markup Language", "Hyper Tool Markdown Language"},
            {"<br>", "&nbsp;", "<break>", "<b>"},
            {"<head>", "<h1>", "<title>", "<h2>"},
            {"<a url='http://www.google.com'>google</a>", "<a name='http://www.google.com'>google</a>", "<a href='http://www.google.com'>google</a>", "<a>google</a>"},
            {"table><tr><tt>", "<thead><body><tr>", "<table><tr><td>", "<table><head><tfoot>"},
            {"<img href=\"image.gif\" alt=\"MyImage\">", "<image src=\"image.gif\" alt=\"MyImage\">", "<img src=\"image.gif\" alt=\"MyImage\">", "<img alt=\"MyImage\">image.gif</img>"},
            {"<list>", "<dl>", "<ul>", "<ol>"},
            {"#id1:{color:black}", "body:color=black;", "{body:color=black;}", "body {color: black;}"}
    };

    // Use to get question based on index
    public String getQuestion(int index){
        return question[index];
    }

    // Gets All the option
    public String[] getAnswers(int index){
        return answers[index];
    }

    // Use to get 1 particular option
    public String rightAnswer(int index, int option_no){
        return answers[index][option_no];
    }


}
