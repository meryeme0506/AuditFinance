package audit.finance.service;

import audit.finance.entity.Stock;
import lombok.AllArgsConstructor;
import audit.finance.repository.StockEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockService {
    private final StockEntityRepository stockEntityRepository;


    public List<Stock> findAll() {
        return stockEntityRepository.findAll();
    }

    public Optional<Stock> findById(Integer id){
        return stockEntityRepository.findById(id);
    }

    public List<Stock> findByStockKey(String stockKey){
        return stockEntityRepository.findByStockKey(stockKey);
    }

    public List<Stock> findByDateTarget(Date dateTarget){
        return stockEntityRepository.findByDateTarget(dateTarget);
    }

    public List<Stock> findByBetween(Date dateFrom, Date dateTo){
        return stockEntityRepository.findByBetween(dateFrom,dateTo);
    }


}
