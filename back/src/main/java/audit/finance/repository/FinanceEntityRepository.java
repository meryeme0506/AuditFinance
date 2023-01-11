package audit.finance.repository;

import audit.finance.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FinanceEntityRepository extends JpaRepository<Finance,Integer> {

    @Query("select f from Finance f")
    List<Finance> findAll();

    @Query("select f from finance f  where f.id = ?1")
    Optional<Finance> findById(Integer id);

    @Query("select f from finance f  where f.stock_key = ?1")
    List<Finance> findByStockKey(String stockKey);

    @Query("select f from finance f  where f.date_target = ?1")
    List<Finance> findByDateTarget(Date dateTarget);

    @Query("select f from finance f where f.date_target >= ?1 and f.date_target <= ?2")
    List<Finance> findByBetween(Date dateFrom, Date dateTo);

    @Query(value="select stock_key, count(stock_key) from finance groub by count(stock_key) DESC")
    Optional<Finance> findMostSearchedStock();







}
