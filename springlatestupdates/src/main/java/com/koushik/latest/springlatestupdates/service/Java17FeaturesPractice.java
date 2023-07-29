package com.koushik.latest.springlatestupdates.service;

import com.koushik.latest.springlatestupdates.dto.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class Java17FeaturesPractice {

    private final String fileName = "exapmle.txt";

    @Value("${spring.application.name}")
    private String appName;

    public String getServiceResponse() throws FileNotFoundException {
        log.info("Entered into the service method for app name {}", appName);
        var num = 10;
        var name = "koushik";
        var longnum = 134.5;
        var doublenum = 134.5f;
        var place = new DataCleanupService();
        place.executeDataFromDBCleanup();
        String player = "kohli";
        switch (player) {
            case "kohli", "Virat", "run machine" -> System.out.println("Best batsman in the world!!");
            case "Gill" -> System.out.println("Junior of kohli");
            case "Rohit" -> System.out.println("Hit man ");
            case "dhoni" -> System.out.println("Always my caption");
            default -> System.out.println("For all players");
        }
        Customer cust = new Customer(10, "koushik", "addanki", 8465046879L);
        System.out.println(cust.name());
        String jsonString = """
                {
                    "name": "DISCOUNT_APPLIED",
                    "enabled": true,
                    "strategy": null
                }
                """;
        System.out.println(jsonString);
        String jsonOldString = "{\n" +
                "    \"name\": \"DISCOUNT_APPLIED\",\n" +
                "    \"enabled\": true,\n" +
                "    \"strategy\": null\n" +
                "}";
        List<String> list = List.of("koushik", "Sai", "Addanki");
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));


        List<Integer> listNum = List.of(20, 40, 40, 80, 77);
        listNum.add(40);
        listNum.stream().forEach(System.out::println);

        //Meaning full null pointer exception is also introduced.

        return "Sample returning!!!";
    }
}
