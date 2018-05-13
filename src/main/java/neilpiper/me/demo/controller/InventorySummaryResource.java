package neilpiper.me.demo.controller;

import java.net.URI;
import java.util.List;
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
import neilpiper.me.demo.domain.InventorySummary;
import neilpiper.me.demo.repository.InventorySummaryRepository;

@RestController
public class InventorySummaryResource {

  @Autowired
  private InventorySummaryRepository inventoryRepository;

  @GetMapping("/depot/{depotId}/inventory_summaries/{summaryId}")
  public ResponseEntity<InventorySummary> getSummaryById(@PathVariable String depotId,
      @PathVariable String summaryId) {
    InventorySummary summary = inventoryRepository.findOne(Long.parseLong(summaryId));

    if (summary == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(summary);

  }


  // @ApiOperation(value = "Find Depot Inventory Summaries",
  // notes = "Get a list of the Inventory Summaries for the depot.")
  // @RequestMapping(value = "/depot/{depotId}/inventory_summaries", method = RequestMethod.GET)
  @GetMapping("/depot/{depotId}/inventory_summaries")
  public List<InventorySummary> retrieveInventorySummaries(@PathVariable String depotId) {
    return inventoryRepository.findAll();
  }

  @DeleteMapping("/depot/{depotId}/inventory_summaries/{summaryId}")
  public void deleteStudent(@PathVariable long depotId, @PathVariable long summaryId) {
    inventoryRepository.delete(summaryId);
  }

  @PostMapping("/depot/{depotId}/inventory_summaries")
  public ResponseEntity<Object> createStudent(@RequestBody InventorySummary summary,
      @PathVariable long depotId) {

    InventorySummary savedSummary = inventoryRepository.save(summary);

    // Return a location with the new Id
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedSummary.getId()).toUri();

    return ResponseEntity.created(location).build();

  }

  @PutMapping("/depot/{depotId}/inventory_summaries/{summaryId}")
  public ResponseEntity<Object> updateInventorySummary(@RequestBody InventorySummary summary,
      @PathVariable long depotId, @PathVariable long summaryId) {

    InventorySummary summaryOptional = inventoryRepository.findOne(summaryId);

    if (summaryOptional == null)
      return ResponseEntity.notFound().build();

    summary.setId(summaryId);

    inventoryRepository.save(summaryOptional);

    return ResponseEntity.noContent().build();
  }



}
