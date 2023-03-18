package com.example.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.TopicPartition;

@Component
public class MessageConsumer {
	
	@KafkaListener(id = "listenerOne", topicPartitions = { @TopicPartition(topic = "thread-topic", partitions = { "0" }) })
    public void listenPartition0(ConsumerRecord<?, ?> record) {
        System.out.println("Listener One, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + record);
    }
 
    @KafkaListener(id = "listenerTwo", topicPartitions = { @TopicPartition(topic = "thread-topic", partitions = { "1" }) })
    public void listenPartition1(ConsumerRecord<?, ?> record) {
        System.out.println("Listener Two, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + record);
    }
 
    @KafkaListener(id = "listenerThree", topicPartitions = { @TopicPartition(topic = "thread-topic", partitions = { "2" }) })
    public void listenPartition2(ConsumerRecord<?, ?> record) {
        System.out.println("Listener Three, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + record);
    }
}

