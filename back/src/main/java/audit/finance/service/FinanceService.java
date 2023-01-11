package audit.finance.service;

import audit.finance.entity.Finance;
import lombok.AllArgsConstructor;
import audit.finance.repository.FinanceEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FinanceService {
    private final FinanceEntityRepository financeEntityRepository;


    public List<Finance> findAll() {
        return financeEntityRepository.findAll();
    }

    public Optional<Finance> findById(Integer id){
        return financeEntityRepository.findById(id);
    }

    public List<Finance> findByStockKey(String stockKey){
        return financeEntityRepository.findByStockKey(stockKey);
    }

    public List<Finance> findByDateTarget(Date dateTarget){
        return financeEntityRepository.findByDateTarget(dateTarget);
    }

    public List<Finance> findByBetween(Date dateFrom, Date dateTo){
        return financeEntityRepository.findByBetween(dateFrom,dateTo);
    }


}
