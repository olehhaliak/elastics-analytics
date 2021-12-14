- ![](https://drive.google.com/uc?export=view&id=10zv76IKs4-JlYCr4qQvbZiqaiPoBoNus)  
# elastics-analytics 
 Coursework title: **"Аналітика поведінки користувачів вебсайту за допомогою БД Elasticsearch"**  
 Related links:

 [Report](https://docs.google.com/document/d/1Alim5a0gJNq8PDN6R6xfl3EfEyBn0xHE/edit?usp=sharing&ouid=109657445850621992282&rtpof=true&sd=true)

## Concept
1. Information about client is gathered and sent via js script
2. Spring application receives this info, extract additional data from some values and persist it in Elasticsearch
3. Elasticsearch provides analytics based on collected data
4. Analytics from Elasticsearch is visualized using Kibana

## 1. Client data collection
 Via js script the following data is gathered:
 - current page
 - previous page
 - history legth of browsing current website
 - locales used
 - userAgent (will be used lately)
 - screen size
 - client time
 - timezone
 and sent to data collecting service
## 2. Spring data transofming
 - Collecting service retrieves client data
 - Based on request IP  via [apicagent.com](https://www.apicagent.com/) API, we get following information:
   - approximate geolocation 
   - country
   - region within country
   - city
 - Based on ***`userAgent`*** field via [ip-api.com](https://ip-api.com/) API we retreive data about system:
   - device type
   - operating system name and version
   - browser name and version 
## 3. Preparing analitics with Elasticsearch
   To store all collected data, I have createad elasticsearch index [***`analytics`***](https://github.com/olehhaliak/elastics-analytics/blob/master/kibana-resources/indexes/analytics-index.json)

## 4. Visualization with Kibana
In kibana we have 4 dashboard created:  
### Activity dashboard
- Shows statistic of visiting your site over last perion:  
- ![](https://drive.google.com/uc?export=view&id=10zv76IKs4-JlYCr4qQvbZiqaiPoBoNus)  

### Foreigners dashboard
- Shows information about foreign users (those who are not from Ukraine):
- ![](https://drive.google.com/uc?export=view&id=18FvshTUkuLpdyYrYt9HXeLZ8CWv70r_W)  

### Ukrainians dashboard
- Shows statistic about users from Ukraine:
- ![](https://drive.google.com/uc?export=view&id=1EyswYdhbfp-MU1Yiljosi473R-26PzUk)

### Usage statistics dashboard
- Shows statistic that is most relevant for developers:
- ![](https://drive.google.com/uc?export=view&id=1fW-Otm9uLAPOmz9cdAsP31dT5YJFwj7D)
