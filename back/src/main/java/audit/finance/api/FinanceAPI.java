package audit.finance.api;

import audit.finance.entity.Finance;
import lombok.AllArgsConstructor;
import audit.finance.repository.FinanceEntityRepository;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("finance")
@AllArgsConstructor
public class FinanceAPI {

    private final FinanceEntityRepository financeEntityRepository;

    @GetMapping("/stocks")
    public List<Finance> getAll(){
        return financeEntityRepository.findAll();
    }

    @GetMapping("/stocks/key={stockKey}")
    public List<Finance> findByStockKey(@PathVariable("stockKey") String stockKey){
        return financeEntityRepository.findByStockKey(stockKey);
    }

    @GetMapping("/stocks/date={dateTarget}")
    public List<Finance> findByDateTarget(@PathVariable("dateTarget") String dateTarget){
        LocalDate localDate = null;
        Date date = new Date();
        try{
             localDate = LocalDate.parse(dateTarget, DateTimeFormatter.ISO_DATE);
             date=Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        }catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e);
        }
        return financeEntityRepository.findByDateTarget(date);
    }

    @GetMapping("/stocks/dateFrom={dateFrom}&dateTo={dateTo}")
    public List<Finance> findByBetween(@PathVariable("dateFrom") String dateFrom,@PathVariable("dateTo") String dateTo){
        return financeEntityRepository.findByBetween();
    }
