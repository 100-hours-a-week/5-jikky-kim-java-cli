package com.shop.shared;

public class SharedResource {
    private boolean logUpdated = false;

    public synchronized void updateLog() {
        logUpdated = true;
        // wait() 상태에서 대기 중인 스레드 중 하나를 깨움
        notify();
    }

    public synchronized void waitForLogUpdate() throws InterruptedException {
        while (!logUpdated) {
            // logUpdated가 true가 될 때까지 대기
            wait();
        }
        // logUpdated 상태를 리셋
        logUpdated = false;
    }
}
