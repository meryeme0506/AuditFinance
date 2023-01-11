package audit.finance.api;

import audit.finance.entity.Finance;
import lombok.AllArgsConstructor;
import audit.finance.api.dto.FinanceRequestDto;
import audit.finance.repository.FinanceEntityRepository;

import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;


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
        Date date = new Date();
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
             date = Date.parse(dateTarget, formatter);
        }
        return financeEntityRepository.findByDateTarget(dateTarget);
    }

    @GetMapping("/stocks/dateFrom={dateFrom}&dateTo={dateTo}")
    public List<Finance> findByBetween(@PathVariable("dateFrom")){
        return financeEntityRepository.findByBetween();
    }
    