package zerobase.stockdividend.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.stockdividend.model.Dividend;
import zerobase.stockdividend.persist.entity.DividendEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface DividendRepository extends JpaRepository<DividendEntity,Long> {

    List<DividendEntity> findAllByCompanyId(Long companyId);
    boolean existsByCompanyIdAndDate(Long companyId, LocalDateTime localDateTime);
}
