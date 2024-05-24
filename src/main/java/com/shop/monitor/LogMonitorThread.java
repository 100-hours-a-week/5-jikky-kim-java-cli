package com.shop.monitor;

import com.shop.shared.SharedResource;
import com.shop.utils.Constants;

public class LogMonitorThread extends Thread {
    private final SharedResource sharedResource;

    public LogMonitorThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sharedResource.waitForLogUpdate();
                System.out.println(Constants.LOG_EMPTY);
                System.out.println(Constants.LOG_UPDATE_NOTIFY);
                System.out.println(Constants.LOG_EMPTY);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
