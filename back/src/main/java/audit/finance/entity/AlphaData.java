package audit.finance.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "alphaData")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlphaData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "dateTime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "open")
    private  double open;
    @Column(name = "high")
    private  double high;
    @Column(name = "low")
    private  double low;
    @Column(name = "close")
    private  double close;
    @Column(name = "volume")
    private  long volume;

}

