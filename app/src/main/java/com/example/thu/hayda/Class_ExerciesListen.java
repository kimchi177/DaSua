package com.example.thu.hayda;

public class Class_ExerciesListen {
    public  String Answer_True,Answer_false, Answer_three,Status,ID,Result;

    public Class_ExerciesListen(String answer_True, String answer_false, String Status,String ID,String Result) {
        Answer_True = answer_True;
        Answer_false = answer_false;
        this.Status = Status;
        this.ID = ID;
        this.Result = Result;

    }


    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAnswer_three() {
        return Answer_three;
    }

    public void setAnswer_three(String answer_three) {
        Answer_three = answer_three;
    }

    public Class_ExerciesListen(String answer_True, String answer_false, String answer_three, String Status,String ID,String Result) {
        Answer_True = answer_True;
        Answer_false = answer_false;
        Answer_three = answer_three;
        this.Status = Status;
        this.ID = ID;
        this.Result = Result;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAnswer_True() {
        return Answer_True;
    }

    public void setAnswer_True(String answer_True) {
        Answer_True = answer_True;
    }

    public String getAnswer_false() {
        return Answer_false;
    }

    public void setAnswer_false(String answer_false) {
        Answer_false = answer_false;
    }
}
