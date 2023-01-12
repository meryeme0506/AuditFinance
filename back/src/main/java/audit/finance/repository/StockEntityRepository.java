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


    @Query("select s from stock s where s.id = ?1")
    Optional<Stock> findById(Integer  id);

    @Query("select s from stock s where s.stock_key = ?1")
    List<Stock> findByStockKey(String stockKey);

    @Query("select s from stock f  where s.date_target = ?1")
    List<Stock> findByDateTarget(Date dateTarget);

    @Query("select s from stock s where s.date_target >= ?1 and s.date_target <= ?2")
    List<Stock> findByBetween(Date dateFrom, Date dateTo);

    @Query(value="select s from stock s group by count(stock_key) DESC")
    Optional<Stock> findMostSearchedStock();







}
