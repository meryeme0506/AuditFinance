package audit.finance.api;

import audit.finance.entity.Stock;
import lombok.AllArgsConstructor;
import audit.finance.repository.StockEntityRepository;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("stock")
@AllArgsConstructor
public class StockAPI {

    private final StockEntityRepository stockEntityRepository;

    @GetMapping("/stocks")
    public List<Stock> getAll() {
        return stockEntityRepository.findAll();
    }

    @GetMapping("/stocks/key={stockKey}")
    public List<Stock> findByStockKey(@PathVariable("stockKey") String stockKey) {
        return stockEntityRepository.findByStockKey(stockKey);
    }

    @GetMapping("/stocks/date={dateTarget}")
    public List<Stock> findByDateTarget(@PathVariable("dateTarget") String dateTarget) {
        Date date = new Date();
        try {
            date = DateUtils.parseDate(dateTarget, "YYYY-MM-DD");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return stockEntityRepository.findByDateTarget(date);
    }

    @GetMapping("/stocks/dateFrom={dateFrom}&dateTo={dateTo}")
    public List<Stock> findByBetween(@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo) {
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = DateUtils.parseDate(dateFrom, "YYYY-MM-DD");
            date2 = DateUtils.parseDate(dateTo, "YYYY-MM-DD");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return stockEntityRepository.findByBetween(date1, date2);
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> saveStock(@RequestBody Stock stock){
       Stock stockCreated = stockEntityRepository.save(new Stock(stock.getId(),stock.getStockKey(),stock.getDateTarget()));
       return new ResponseEntity<>(stockCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/stocks/delete/id/{id}")
    public void delete(@PathVariable int id){
        Optional<Stock> stock = stockEntityRepository.findById(id);
        stockEntityRepository.delete(stock.orElse(null));
    }


}
