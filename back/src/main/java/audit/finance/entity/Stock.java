package audit.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(generator = "finance_id_sequence")
    private Integer id;
    @Column(name = "stock_key")
    private String stockKey;
    @Column(name = "date_target")
    private Date dateTarget;
    



}
