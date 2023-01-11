package audit.finance.service;

import audit.finance.entity.Finance;
import lombok.AllArgsConstructor;
import audit.finance.repository.FinanceEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FinanceService {
    private final FinanceEntityRepository financeEntityRepository;


    public List<Finance> findAll() {
        return financeEntityRepository.findAll();
    }

    public Finance save(Finance finance) {
        return financeEntityRepository.save(finance);
    }
}
