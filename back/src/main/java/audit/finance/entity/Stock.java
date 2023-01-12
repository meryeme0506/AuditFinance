package audit.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(generator = "finance_id_sequence")
    private Integer id;

    @Column(name = "stock_key")
    private String stockKey;

    @Column(name = "date_target")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date dateTarget;

    public Stock() {
    }

    public Stock(Integer id, String stockKey, Date dateTarget) {
        this.id = id;
        this.stockKey = stockKey;
        this.dateTarget = dateTarget;
    }

    public Integer getId() {
        return id;
    }

    public String getStockKey() {
        return stockKey;
    }

    public Date getDateTarget() {
        return dateTarget;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStockKey(String stockKey) {
        this.stockKey = stockKey;
    }

    public void setDateTarget(Date dateTarget) {
        this.dateTarget = dateTarget;
    }

}
