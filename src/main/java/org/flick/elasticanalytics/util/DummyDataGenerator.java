package org.flick.elasticanalytics.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.geo.GeoPoint;
import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.flick.elasticanalytics.model.Location;
import org.flick.elasticanalytics.model.Platform;
import org.flick.elasticanalytics.service.LocationService;
import org.flick.elasticanalytics.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Lazy
@Slf4j
public class DummyDataGenerator {
    @Autowired
    ObjectMapper mapper;

    //@Autowired
   // LocationService service;

    public DummyDataGenerator() {

    }

    static Random random = new Random();
    public static final String[] DUMMY_PAGES = {
            "/main",
            "/categories",
            "/product",
            "/cart",
            "/profile",
            "/settings",
            "/purchase",
            "/sale"
    };

    private List<Platform> dummyPlatforms;

    private List<IpLocations> dummyILocations;

    synchronized private List<Platform> getDummyPlatforms() {
        if (dummyPlatforms == null) {
            dummyPlatforms = readDummyPlatformList();
        }
        return dummyPlatforms;
    }

    synchronized private List<IpLocations> getDummyILocations(){
        if (dummyILocations == null) {
            dummyILocations = readDummyLocationsList();
        }
        return dummyILocations;
    }
    IpLocations getRandIpLocation(){
        List<IpLocations> list = getDummyILocations();
        int rand = random.nextInt(list.size()-1);
        return list.get(rand);
    }
    public AnalyticsRecord generateRandomizedRecord() throws IOException {
        Platform platform = getRandPlatform();
        IpLocations location = getRandIpLocation();

        AnalyticsRecord record = AnalyticsRecord.builder()
                .page(getRandPage())                    //DONE
                .referer(getRandReferer())              //DONE
                .historyLength(getRandHistoryLength())  //DONE
                .locale(location.getLocale().toString())                //DONE
                .platform(platform)                     //DONE
                .layout(getRandLayout(platform.getDeviceType())) //DONE
                .clientTime(getRandClientTime())        //DONE
                .ip(location.getIp())
                .location(location.getLocation())
                .build();
        return record;
    }

    public static int getRandHistoryLength() {
        System.out.println(random.nextDouble());
        return (int) (1 / (0.02 * (Math.abs(0.84 + (random.nextDouble() * 33.0)))));
    }

    private static final String[] LOCALES = {
            "uk_UA", "ru_UA", "ru_BY", "be_BY", "pl_PL", "de_DE", "en_UK", "en_US", "pt_PT"
    };

    public static String getRandLocale() {
        int rand = random.nextInt(100);
        if (rand < 37) return LOCALES[0];
        if (rand < 64) return LOCALES[1];
        if (rand < 70) return LOCALES[2];
        if (rand < 74) return LOCALES[3];
        if (rand < 78) return LOCALES[4];
        if (rand < 82) return LOCALES[5];
        if (rand < 89) return LOCALES[6];
        if (rand < 98) return LOCALES[7];
        return LOCALES[8];
    }

    public Platform getRandPlatform() throws IOException {
        int rand = random.nextInt(getDummyPlatforms().size() - 1);
        return getDummyPlatforms().get(rand);
    }

    private static final int[][] DESKTOP_LAYOUTS = {
            {1920, 1080},//23%
            {1366, 768},//21%
            {1536, 864},//8%
            {1440, 900},//7%
            {1280, 720}//5%
    };

    private static final int[][] SMARTPHONE_LAYOUTS = {
            {360, 640},//18%
            {375, 667},//7%
            {414, 896},//7%
            {360, 780},//5%
            {375, 812}//5%
    };

    private static final int[][] TABLET_LAYOUTS = {
            {768, 1024},//40%
            {1280, 800},//6%
            {800, 1280},//6%
            {810, 1080},//5%
            {962, 601},//3%
    };

    private static AnalyticsRecord.Layout getRandLayout(String deviceType) {
        AnalyticsRecord.Layout layout = new AnalyticsRecord.Layout();
        if (deviceType == null) {
            return layout;
        }
        if (deviceType.equals("desktop")) {
            int rand = random.nextInt(64);
            if (rand < 23) {
                layout.setScreenWidth(DESKTOP_LAYOUTS[0][0]);
                layout.setScreenHeight(DESKTOP_LAYOUTS[0][1]);
            } else if (rand < 44) {
                layout.setScreenWidth(DESKTOP_LAYOUTS[1][0]);
                layout.setScreenHeight(DESKTOP_LAYOUTS[1][1]);
            } else if (rand < 52) {
                layout.setScreenWidth(DESKTOP_LAYOUTS[2][0]);
                layout.setScreenHeight(DESKTOP_LAYOUTS[2][1]);
            } else if (rand < 59) {
                layout.setScreenWidth(DESKTOP_LAYOUTS[3][0]);
                layout.setScreenHeight(DESKTOP_LAYOUTS[3][1]);
            } else {
                layout.setScreenWidth(DESKTOP_LAYOUTS[4][0]);
                layout.setScreenHeight(DESKTOP_LAYOUTS[4][1]);
            }
        } else if (deviceType.equals("smartphone")) {
            int rand = random.nextInt(42);
            if (rand < 18) {
                layout.setScreenWidth(SMARTPHONE_LAYOUTS[0][0]);
                layout.setScreenHeight(SMARTPHONE_LAYOUTS[0][1]);
            } else if (rand < 25) {
                layout.setScreenWidth(SMARTPHONE_LAYOUTS[1][0]);
                layout.setScreenHeight(SMARTPHONE_LAYOUTS[1][1]);
            } else if (rand < 32) {
                layout.setScreenWidth(SMARTPHONE_LAYOUTS[2][0]);
                layout.setScreenHeight(SMARTPHONE_LAYOUTS[2][1]);
            } else if (rand < 37) {
                layout.setScreenWidth(SMARTPHONE_LAYOUTS[3][0]);
                layout.setScreenHeight(SMARTPHONE_LAYOUTS[3][1]);
            } else {
                layout.setScreenWidth(SMARTPHONE_LAYOUTS[4][0]);
                layout.setScreenHeight(SMARTPHONE_LAYOUTS[4][1]);
            }
        } else {
            int rand = random.nextInt(60);
            if (rand < 40) {
                layout.setScreenWidth(TABLET_LAYOUTS[0][0]);
                layout.setScreenHeight(TABLET_LAYOUTS[0][1]);
            } else if (rand < 46) {
                layout.setScreenWidth(TABLET_LAYOUTS[1][0]);
                layout.setScreenHeight(TABLET_LAYOUTS[1][1]);
            } else if (rand < 52) {
                layout.setScreenWidth(TABLET_LAYOUTS[2][0]);
                layout.setScreenHeight(TABLET_LAYOUTS[2][1]);
            } else if (rand < 57) {
                layout.setScreenWidth(TABLET_LAYOUTS[3][0]);
                layout.setScreenHeight(TABLET_LAYOUTS[3][1]);
            } else {
                layout.setScreenWidth(TABLET_LAYOUTS[4][0]);
                layout.setScreenHeight(TABLET_LAYOUTS[4][1]);
            }
        }
        return layout;
    }

    public static final int HOURS_PROBABILITIES[] = new int[24];
    private static GregorianCalendar gregorianCalendar = new GregorianCalendar();

    static {    //complex logic for initializing HOURS_PROBABILITY
        Function<Integer, Integer> function = (x) -> {
            int y = (int) ((3 * (Math.sin(0.2618 * (x - 11))) + 2.75) * 10);
            return Math.max(y, 0);
        };
        HOURS_PROBABILITIES[0] = function.apply(0);
        for (int i = 1; i < 24; i++) {
            HOURS_PROBABILITIES[i] = HOURS_PROBABILITIES[i - 1] + function.apply(i);
        }
        System.out.println(Arrays.toString(HOURS_PROBABILITIES));
    }

    public static AnalyticsRecord.ClientTime getRandClientTime() {
        int hours = 44;
        int rand = random.nextInt(HOURS_PROBABILITIES[23]);
        for (int i = 0; i < 24; i++) {
            if (rand <= HOURS_PROBABILITIES[i]) {
                hours = i;
                break;
            }
        }

        Timestamp timestamp = Timestamp.valueOf(
                LocalDateTime.of(
                        LocalDateTime.now().getYear(),
                        11,// LocalDateTime.now().getMonthValue(),
                        30,//gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) - 1) + 1,
                        hours,
                        random.nextInt(60),
                        random.nextInt(60)));
        int timezone = random.nextInt(3);
        return new AnalyticsRecord.ClientTime(timestamp, timezone);
    }

    public static String getRandIp() {
        return null;
    }

    public static String getRandReferer() {
        int rand = random.nextInt(95);
        if (rand < 22) {
            return DUMMY_PAGES[0];
        }
        if (rand < 44) {
            return DUMMY_PAGES[1];
        }
        if (rand < 50) {
            return DUMMY_PAGES[2];
        }
        if (rand < 53) {
            return DUMMY_PAGES[3];
        }
        if (rand < 56) {
            return DUMMY_PAGES[6];
        }
        if (rand < 69) {
            return DUMMY_PAGES[7];
        }
        return "";
    }

    public static String getRandPage() {
        int rand = random.nextInt(90);
        if (rand < 15) {
            return DUMMY_PAGES[0];
        }
        if (rand < 22) {
            return DUMMY_PAGES[1];
        }
        if (rand < 62) {
            return DUMMY_PAGES[2];
        }
        if (rand < 67) {
            return DUMMY_PAGES[3];
        }
        if (rand < 69) {
            return DUMMY_PAGES[4];
        }
        if (rand < 71) {
            return DUMMY_PAGES[5];
        }
        if (rand < 76) {
            return DUMMY_PAGES[6];
        }
        return DUMMY_PAGES[7];
    }

    private List<IpLocations> readDummyLocationsList() {
        try {
            return mapper.readValue(
                    new File("src\\test\\resources\\dummy-data\\dummy-ip-locations.json"),
                    new TypeReference<List<IpLocations>>() {
                    }
            ).stream().map(l->{
                l.getLocation().setGeoPoint(new GeoPoint(l.getLocation().getLatitude(),l.getLocation().getLongitude()));
                return l;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read 'dummy-platforms' file");
        }
    }

    private List<Platform> readDummyPlatformList() {
        try {
            return mapper.readValue(
                    new File("src\\test\\resources\\dummy-data\\dummy-platforms.json"),
                    new TypeReference<List<Platform>>() {
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read 'dummy-platforms' file");
        }
    }

//    public void lab() throws IOException {
//        List<IpLocations> locations;
//        locations = mapper.readValue(new File("src\\test\\resources\\dummy-data\\dummy-ip-locations.json"),
//                new TypeReference<List<IpLocations>>() {});
//        Map<String, String> ipCoutry = new HashMap<>();
//        Scanner scn = new Scanner(new File("src\\test\\resources\\dummy-data\\dummy-locations-country.csv"));
//        while (scn.hasNext()) {
//            String s = scn.nextLine();
//            ipCoutry.put(s.substring(0, s.indexOf(',')), s.substring(s.indexOf(',') + 1));
//        }
//        locations = locations.stream().map(location->{
//            location.setLocale(getLangForCountry(ipCoutry.get(location.ip)));
//            return location;
//        }).collect(Collectors.toList());
//        locations.forEach(System.out::println);
//        System.out.println(locations.size());
//        //mapper.writeValue(new File("src\\test\\resources\\dummy-data\\dummy-ip-locations.json"), locations);
//    }

    Map<String, String> sameCodeLocales;
    Map<String, String> languageMap;

    public Locale getLangForCountry(String countryCode) {
        if (sameCodeLocales == null) {
            initLocales();
        }
        return new Locale(getLang(countryCode), countryCode);
    }

    private String getLang(String countryCode) {
        if (countryCode.equals("UA")) {
            int rand = random.nextInt(100);
            return rand < 64 ? "ua" : "ru";
        }
        if (countryCode.equals("BY")) {
            int rand = random.nextInt(100);
            return rand < 50 ? "by" : "ru";
        }
        if (countryCode.equals("DE")) return "de";
        if (countryCode.equals("PL")) return "pl";
        if (countryCode.equals("US")) return "en";
        if (countryCode.equals("GB")) return "en";
        if (countryCode.equals("FR")) return "fr";
        if (countryCode.equals("NL")) return "nl";
        if (countryCode.equals("IT")) return "it";
        if (countryCode.equals("RU")) return "ru";

        if (sameCodeLocales.containsKey(countryCode.toLowerCase(Locale.ROOT))) {
            countryCode.toLowerCase(Locale.ROOT);
        }
        return languageMap.get(countryCode);
    }

    private void initLocales() {
        sameCodeLocales = new HashMap<>();
        languageMap = new HashMap<>();
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            if (locale.getCountry().isBlank()) {
                sameCodeLocales.put(locale.getLanguage(), locale.getLanguage());
                continue;
            }
            if (!languageMap.containsKey(locale.getCountry())) {
                languageMap.put(locale.getCountry(), locale.getLanguage());
            }
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class IpLocations {
        String ip;
        Location location;
        Locale locale;
    }
}
