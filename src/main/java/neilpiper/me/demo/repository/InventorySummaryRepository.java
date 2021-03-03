package neilpiper.me.demo.repository;

import neilpiper.me.demo.domain.InventorySummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/** Repository interface for the InventorySummary Resource.
 *
 * @author neilpiper
 *
 */
@Repository
public interface InventorySummaryRepository extends JpaRepository<InventorySummary, Long> {



}
