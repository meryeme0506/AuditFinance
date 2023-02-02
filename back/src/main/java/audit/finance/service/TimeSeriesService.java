package audit.finance.service;

import audit.finance.entity.AlphaData;
import audit.finance.entity.TimeSerie;
import audit.finance.entity.TimeSeries;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Objects;

public class TimeSeriesService {

    public static Object gestTimeSeries(String symbol) {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol="+symbol+"&apikey=1XDCVS7DM3C1XE20";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TimeSeries> response = restTemplate.getForEntity(url, TimeSeries.class);
        TimeSeries res = response.getBody();
        HashMap<String, TimeSerie> serie = Objects.requireNonNull(res).getSerie();
        TimeSerie t = serie.get("2023-02-01");
        System.out.println(t);
        return res.serie.values();
    }

    public static void main(String[] args) {
        gestTimeSeries("IBM");
        

    }
}
