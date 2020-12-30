package de.bsi.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import de.bsi.demo.model.ItemAsRecord;

@RestController
public final class GetItemController extends ItemController {

	@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String getAllItems() {
		// Text block feature has been introduced in Java 13 and improved in later releases.
		String html = """
				<!DOCTYPE HTML>
				<html>
					<head>
						<meta charset="utf-8" />
						<title>Text Block feature demo</title>
					</head>
					<body>
						<h1>%d items have been created with following names:</h1>
						<h1>%s</h1>
					</body>
				</html>
				""";
		String itemNames = getAllItemNamesAsOneString();
		// formatted method is new since Java 15 - same as: 
		// String.format(html, items.size(), itemNames)
		return html.formatted(items.size(), itemNames);
	}
	
	private String getAllItemNamesAsOneString() {
		String itemNames = "";
		for (Object unknownType : items) {
			// Pattern matching for instanceof since Java 14
			if (unknownType instanceof ItemAsRecord item)
				itemNames += item.name() + " ";
		}
		return itemNames;
	}
	
}
