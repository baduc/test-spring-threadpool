package com.bidi.vnpt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.bidi.vnpt.executor.Consumer;
import com.bidi.vnpt.executor.Message;
import com.bidi.vnpt.executor.Producer;

@SpringBootApplication
//@EnableScheduling
public class TestSchedulerApplication implements ApplicationRunner{
	BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
	
	@Autowired
    ThreadPoolTaskExecutor threadPool;
	
	public static void main(String[] args) {
		SpringApplication.run(TestSchedulerApplication.class, args);
//		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//        //starting producer to produce messages in queue
//        new Thread(producer).start();
//        //starting consumer to consume messages from queue
//        new Thread(consumer).start();
//        System.out.println("Producer and Consumer has been started");
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		threadPool.execute(new Producer(queue));
		threadPool.execute(new Consumer(queue));
		
	}
}
