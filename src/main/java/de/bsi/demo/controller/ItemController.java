package de.bsi.demo.controller;

import java.util.*;

import org.slf4j.*;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/item")
public sealed abstract class ItemController permits PostItemController, GetItemController {

	protected Logger logger = LoggerFactory.getLogger(ItemController.class);
	protected static List<Object> items = new ArrayList<>();
	
}