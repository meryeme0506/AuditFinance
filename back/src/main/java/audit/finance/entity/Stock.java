package audit.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
    @Id
    @GeneratedValue(generator = "finance_id_sequence")
    private Integer id;

    @Column(name = "stock_key")
    private String stockKey;

    @Column(name = "date_target")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date dateTarget;
}
