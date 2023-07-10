package com.flight.booking.system.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Configuration
public class Kafkaconfig {

    private static final String TOPIC_NAME = "myTopic";
    private static final String BOOTSTRAP_SERVER = "localhost:9092";
    private static final String KAFKA_PATH = "D:/ApacheKafka/kafka_2.12-3.4.0/bin/windows";
    private static final String ZOOKEEPER_SERVER = "zookeeper-server-start.bat..\\..\\config\\zookeeper.properties";
    private static final String KAFKA_SERVER = "kafka-server-start.bat ..\\..\\config\\server.properties";
    private static final Logger logger = LoggerFactory.getLogger(Kafkaconfig.class);

    @Bean
    public void startServer() throws IOException, InterruptedException {
        logger.info("Starting Kafka Server");
        try {
            changeDirectory(KAFKA_PATH);
            // Start ZooKeeper server
            executeCommand(ZOOKEEPER_SERVER);
            // Change Directory
            changeDirectory(KAFKA_PATH);
            // Start Kafka server
            executeCommand(KAFKA_SERVER);
        } catch (IOException | InterruptedException e) {
            logger.error("Server Not Started!!" + e.getMessage());
            e.printStackTrace();
        }
        logger.info("Kafka server started successfully and topic created.");
    }


    private static void changeDirectory(String path) throws IOException, InterruptedException {
        logger.info("Change Directory : " + path);
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "cd /d " + path);
        Process process = processBuilder.start();
        process.waitFor();
    }

    private static boolean executeCommand(String command) throws IOException, InterruptedException {
        logger.info("Execute Command : " + command);
        ProcessBuilder processbuilder = new ProcessBuilder("cmd.exe", "/c", command);
        processbuilder.redirectErrorStream(true);
        Process process = processbuilder.start();
        int processWait = process.waitFor();
        if (processWait == 0)
            return true;
        else
            return false;
    }

    private static boolean checkTopicExists(String topicName) throws IOException, InterruptedException {
        String command = "kafka-topics.bat --bootstrap-server " + BOOTSTRAP_SERVER + " --list";
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
        Process process = processBuilder.start();

        // Read the output of the command
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(topicName)) {
                return true; // Topic exists
            }
        }
        process.waitFor();
        return false; // Topic does not exist
    }


}
