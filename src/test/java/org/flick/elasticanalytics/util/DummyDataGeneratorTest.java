package org.flick.elasticanalytics.util;

import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.flick.elasticanalytics.service.ElasticsearchService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@ContextConfiguration(classes = {
//        DummyDataGenerator.class,
//        ObjectMapper.class,
//        LocationServiceImpl.class,
//        LocationClientImpl.class,
//        LocationMapperImpl.class,
//        ElasticsearchService.class,
//        AnalyticsRecordRepository.class,
//        ElasticsearchOperations.class
//
//})

class DummyDataGeneratorTest {
    @Autowired
    DummyDataGenerator dummyDataGenerator;
    @Autowired
    ElasticsearchService service;

    @Test
    void populateWithDummyData() {
        for (int i = 0; i < 2000; i++) {
            try {
                AnalyticsRecord record = dummyDataGenerator.generateRandomizedRecord();
               // System.out.println(record);
                service.saveAnalyticsRecord(dummyDataGenerator.generateRandomizedRecord());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void getRandLocale() {
        for (int i = 0; i < 100; i++) {
            System.out.println(DummyDataGenerator.getRandLocale());
        }
    }

    @Test
    void getRandHistory() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(DummyDataGenerator.getRandHistoryLength());
        }
        list = list.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
    }

    @Test
    void getRandomizedRecord() throws IOException {
        for (int i = 0; i < 100; i++) {
            System.out.println(dummyDataGenerator.generateRandomizedRecord());
        }
    }

    @Test
    void getRandPlatform() throws IOException {
        for (int i = 0; i < 100; i++) {
            System.out.println(dummyDataGenerator.getRandPlatform());
        }
    }

    @Test
    void getRandCustomTime() {
        Set<AnalyticsRecord.ClientTime> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(DummyDataGenerator.getRandClientTime());
        }

        set.stream()
                .sorted(Comparator.comparingInt(t -> t.getTimestamp().getHours()))
                .forEach(System.out::println);
    }

    @Test
    void getRandRefferer() {
        int[] count = new int[8];
        for (int i = 0; i < 100; i++) {
            String dummyRef = DummyDataGenerator.getRandReferer();
            for (int j = 0; j < 8; j++) {
                if (dummyRef.equals(DummyDataGenerator.DUMMY_PAGES[j])) {
                    count[j]++;
                    break;
                }
            }
            System.out.println(dummyRef);
        }
        System.out.println(Arrays.toString(count));
    }

    @Test
    void getRandPageTest() {
        int[] count = new int[8];
        for (int i = 0; i < 100; i++) {
            String dummyPage = DummyDataGenerator.getRandPage();
            for (int j = 0; j < 8; j++) {
                if (dummyPage.equals(DummyDataGenerator.DUMMY_PAGES[j])) {
                    count[j]++;
                    break;
                }
            }
            System.out.println(dummyPage);
        }
        System.out.println(Arrays.toString(count));
    }
}