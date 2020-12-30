package de.bsi.demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import de.bsi.demo.model.ItemAsRecord;

@RestController
public final class PostItemController extends ItemController {
	
	// Record as input parameter of createItem method. Here it is same way as for any other POJO class.
	@PostMapping
	public ResponseEntity<ItemAsRecord> createItem(@Valid @RequestBody ItemAsRecord item) {
		items.add(item);
		return ResponseEntity.ok(item);
	}
	
	@PostMapping("/{type}")
	public ResponseEntity<ItemAsRecord> addPredefinedItem(@PathVariable String type) {
		ItemAsRecord item = selectItemByType(type);
		items.add(item);
		return ResponseEntity.ok(item);
	}
	
	private ItemAsRecord typeB = new ItemAsRecord(1, "Ball", "Field");  
	private ItemAsRecord typeC = new ItemAsRecord(2, "Shoes", "House");
	
	private ItemAsRecord selectItemByType(String type) {		
		// New switch expression comes with Java 14.
		ItemAsRecord result = switch (type) {
			case "a", "A", "b", "B" -> this.typeB;
			case "c", "C" -> {
				logger.info("Type C is handled as default case.");
				yield this.typeC;
			}
			default -> this.typeC;
		};
		logger.info("Selected item is {}", result);
		return result;
	}
}
