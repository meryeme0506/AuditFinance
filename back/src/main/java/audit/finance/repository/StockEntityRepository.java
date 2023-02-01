package audit.finance.repository;

import audit.finance.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockEntityRepository extends JpaRepository<Stock,Integer> {



    Optional<Stock> findById(Integer  id);

    List<Stock> findByStockKey(String stockKey);

    List<Stock> findByDateTarget(Date dateTarget);

    List<Stock> findByBetween(Date dateFrom, Date dateTo);
    @Query(value = "select count( stock_key ) AS f FROM stock GROUP BY stock_key ORDER BY f DESC ", nativeQuery = true)
    Optional<Stock> findMostSearchedStock();







}
