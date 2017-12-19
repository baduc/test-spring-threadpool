package com.bidi.vnpt;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixRateScheduler {

	@Scheduled(fixedRate = 5000)
	public void run() throws InterruptedException {
		System.out.println("Fix rate scheduler is running at " + new Date());
		Thread.sleep(3000);
	}
}
