package audit.finance.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FinanceRequestDto {
    private Integer id;
    private Integer stock_key;
    private Date dateTarget;
}
