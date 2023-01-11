package audit.finance.api;

import audit.finance.entity.Finance;
import lombok.AllArgsConstructor;
import audit.finance.repository.FinanceEntityRepository;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("finance")
@AllArgsConstructor
public class FinanceAPI {

    private final FinanceEntityRepository financeEntityRepository;

    @GetMapping("/stocks")
    public List<Finance> getAll() {
        return financeEntityRepository.findAll();
    }

    @GetMapping("/stocks/key={stockKey}")
    public List<Finance> findByStockKey(@PathVariable("stockKey") String stockKey) {
        return financeEntityRepository.findByStockKey(stockKey);
    }

    @GetMapping("/stocks/date={dateTarget}")
    public List<Finance> findByDateTarget(@PathVariable("dateTarget") String dateTarget) {
        Date date = new Date();
        try {
            date = DateUtils.parseDate(dateTarget, "YYYY-MM-DD");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return financeEntityRepository.findByDateTarget(date);
    }

    @GetMapping("/stocks/dateFrom={dateFrom}&dateTo={dateTo}")
    public List<Finance> findByBetween(@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo) {
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = DateUtils.parseDate(dateFrom, "YYYY-MM-DD");
            date2 = DateUtils.parseDate(dateTo, "YYYY-MM-DD");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return financeEntityRepository.findByBetween(date1, date2);
    }
}
