package audit.finance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSerie{
    @JsonProperty("1. open")
    float open;
    @JsonProperty("2. high")
    float high;
    @JsonProperty("3. low")
    float low;
    @JsonProperty("4. close")
    float close;
    @JsonProperty("5. volume")
    float volume;

}
