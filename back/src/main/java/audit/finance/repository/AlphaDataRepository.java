package audit.finance.repository;

import audit.finance.entity.AlphaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlphaDataRepository extends JpaRepository<AlphaData,Integer> {
    @Query("select data from alphaData data where data.symbol = ?1")
    List<AlphaData> findBySymbol(String stockKey);


}
