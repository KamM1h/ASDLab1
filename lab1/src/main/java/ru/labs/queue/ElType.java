package ru.labs.queue;

public class ElType {
    private String detailCode;
    private int timeForProcessing;

    ElType(String detailCode, int timeForProcessing){
        this.detailCode = detailCode;
        this.timeForProcessing = timeForProcessing;
    }


    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    public void setTimeForProcessing(int timeForProcessing) {
        this.timeForProcessing = timeForProcessing;
    }

    public int getTimeForProcessing() {
        return timeForProcessing;
    }

    public String getDetailCode() {
        return detailCode;
    }
}

