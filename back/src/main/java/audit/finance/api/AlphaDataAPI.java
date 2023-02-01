package audit.finance.api;

import audit.finance.entity.AlphaData;
import audit.finance.repository.AlphaDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("data")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AlphaDataAPI {
    private final AlphaDataRepository alphaDataRepository;

    @GetMapping("/data")
    public List<AlphaData> getAll()  {
        return alphaDataRepository.findAll();
    }

    @GetMapping("/data/key={stockKey}")
    public List<AlphaData> findByStockKey(@PathVariable("stockKey") String stockKey) {
        return alphaDataRepository.findBySymbol(stockKey);
    }
}
