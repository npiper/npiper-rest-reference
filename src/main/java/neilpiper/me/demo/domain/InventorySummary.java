package neilpiper.me.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/** JPA Domain class to represent an InventorySummary Resource.
 *
 * @author neilpiper
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InventorySummary implements java.io.Serializable {

  /**
   * Default serial version ID.
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @Getter @Setter private Long id;

  // private Date reportStart;
  // private Duration reportDuration;

  // private Date beginDateTime;

  // private Date creationDateTime;

  // private String contentOwner;

  // private String structureTypeCode;

  // private String notes;

  @Getter @Setter private String inventoryLocation;

}
