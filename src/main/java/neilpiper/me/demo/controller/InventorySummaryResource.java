package neilpiper.me.demo.controller;

import java.net.URI;
import java.util.List;
import neilpiper.me.demo.domain.InventorySummary;
import neilpiper.me.demo.repository.InventorySummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Rest API for the InventorySummary Resource.
 *
 * @author neilpiper
 *
 */
@RestController
public class InventorySummaryResource {

  @Autowired
  private InventorySummaryRepository inventoryRepository;

  /**
   * Get a summary by ID.
   *
   * @param depotId ID for the depot
   * @param summaryId ID for the summary.
   * @return
   */
  @GetMapping("/depot/{depotId}/inventory_summaries/{summaryId}")
  public ResponseEntity<InventorySummary> getSummaryById(@PathVariable String depotId,
      @PathVariable String summaryId) {

    try {
      InventorySummary summary = inventoryRepository.getOne(Long.parseLong(summaryId));
      return ResponseEntity.ok(summary);
    } catch (javax.persistence.EntityNotFoundException nfe) {
      return ResponseEntity.notFound().build();
    }


  }

  /**
   * Retrieve a list of Inventory Summaries.
   *
   * @param depotId ID of the depot
   * @return List of Inventory summaries.
   */
  // @ApiOperation(value = "Find Depot Inventory Summaries",
  // notes = "Get a list of the Inventory Summaries for the depot.")
  // @RequestMapping(value = "/depot/{depotId}/inventory_summaries", method = RequestMethod.GET)
  @GetMapping("/depot/{depotId}/inventory_summaries")
  public List<InventorySummary> retrieveInventorySummaries(@PathVariable String depotId) {
    return inventoryRepository.findAll();
  }

  /**
   * Delete an Inventory summary from the Depot.
   *
   * @param depotId ID of the depot
   * @param summaryId ID of the inventory summary.
   */
  @DeleteMapping("/depot/{depotId}/inventory_summaries/{summaryId}")
  public void deleteStudent(@PathVariable long depotId, @PathVariable long summaryId) {

    inventoryRepository.deleteById(Long.valueOf(summaryId));

  }

  /**
   * Create a new Inventory Summary.
   *
   * @param summary Summary information body.
   * @param depotId ID of depot to add to.
   * @return
   */
  @PostMapping("/depot/{depotId}/inventory_summaries")
  public ResponseEntity<Object> createStudent(@RequestBody InventorySummary summary,
      @PathVariable long depotId) {

    InventorySummary savedSummary = inventoryRepository.save(summary);

    // Return a location with the new Id
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedSummary.getId()).toUri();

    return ResponseEntity.created(location).build();

  }

  /**
   * Update an existing inventory summary.
   *
   * @param summary Summary details.
   * @param depotId Depot ID.
   * @param summaryId ID of the summary.
   * @return
   */
  @PutMapping("/depot/{depotId}/inventory_summaries/{summaryId}")
  public ResponseEntity<Object> updateInventorySummary(@RequestBody InventorySummary summary,
      @PathVariable long depotId, @PathVariable long summaryId) {

    InventorySummary summaryOptional = inventoryRepository.getOne(Long.valueOf(summaryId));

    if (summaryOptional == null) {
      return ResponseEntity.notFound().build();
    }

    summary.setId(summaryId);

    inventoryRepository.save(summaryOptional);

    return ResponseEntity.noContent().build();
  }



}
