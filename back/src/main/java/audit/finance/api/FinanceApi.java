package audit.finance.api;

import lombok.AllArgsConstructor;
import audit.finance.api.dto.FinanceRequestDto;
import audit.finance.entity.Finance;
import audit.finance.service.FinanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@AllArgsConstructor
public class FinanceApi {
    private final FinanceService bookService;

    @GetMapping()
    public List<Finance> getAll(){
        return bookService.findAll();
    }

    @PostMapping()
    public Finance save(@RequestBody FinanceRequestDto requestDto){
        Finance book = Finance.
                builder()
                .code(requestDto.getCode())
                .name(requestDto.getName())
                .build();
        return bookService.save(book);
    }


}
