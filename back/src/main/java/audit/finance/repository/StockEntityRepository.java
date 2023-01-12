package audit.finance.repository;

import audit.finance.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StockEntityRepository extends JpaRepository<Stock,Integer> {

    @Query("select f from stock f")
    List<Stock> findAll();

    @Query("select f from stock f  where f.id = ?1")
    Optional<Stock> findById(Integer id);

    @Query("select f from stock f  where f.stock_key = ?1")
    List<Stock> findByStockKey(String stockKey);

    @Query("select f from stock f  where f.date_target = ?1")
    List<Stock> findByDateTarget(Date dateTarget);

    @Query("select f from stock f where f.date_target >= ?1 and f.date_target <= ?2")
    List<Stock> findByBetween(Date dateFrom, Date dateTo);

    @Query(value="select stock_key, count(stock_key) from stock groub by count(stock_key) DESC")
    Optional<Stock> findMostSearchedStock();







}
