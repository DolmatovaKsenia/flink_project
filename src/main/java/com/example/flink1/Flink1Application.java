package com.example.flink1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import io.minio.MinioClient;
import io.minio.messages.Bucket;
import io.minio.errors.MinioException;

import java.util.List;

@SpringBootApplication
public class Flink1Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Flink1Application.class, args);
        MinioClient minioClient = demo();
        try {
            List<Bucket> bList = minioClient.listBuckets();
            System.out.println("Connection success, buckets size: " + bList.size());
        } catch (MinioException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(1, 2, 3, 4, 5).print();
        env.execute("Flink Application");
    }

    public static MinioClient demo() {
        return MinioClient.builder()
                .endpoint("http://minio:9000")
                .credentials("fantasticdrogon", "Dolmatova171204")
                .build();
    }

}
