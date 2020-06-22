package com.e_buvette.ebuvette;

import java.util.List;

import org.definitylabs.flue2ent.element.FindElementBy;
import org.definitylabs.flue2ent.element.WebElementWrapper;

public interface TestEndToEnd {

	@FindElementBy(tagName = "h1")
	WebElementWrapper title();

	@FindElementBy(className = "img-fluid", andGetAttribute = "src")
	List<String> images();

	@FindElementBy(tagName = "h1", css = "color")
	List<String> colroTitle();

}
