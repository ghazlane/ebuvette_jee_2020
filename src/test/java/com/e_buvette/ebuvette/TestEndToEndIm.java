package com.e_buvette.ebuvette;

import java.util.List;

import org.definitylabs.flue2ent.Website;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEndToEndIm {

	public static void main(String[] args) {

//		initialisation des drivers
		WebDriver driver = new ChromeDriver(); // get web driver
		String url = "localhost:8080/client";
		Website website = Website.with(driver).visit(url);

//		Test sur le titre 
		String header = website.at(TestEndToEnd.class).title().text();
		if (website.at(TestEndToEnd.class).title().isDisplayed()) {
			System.out.println("Titre bien affiche");
		} else {
			System.out.println("Titre n'est pas affiché");
		}
// Le titre affichées est le suivant
		System.out.println("Le titre affichees est : " + header);

		System.out.println("La liste des images affiches est : \n");
		List<String> images = website.at(TestEndToEnd.class).images();
		for (String string : images) {
			System.out.println(string);
		}

		System.out.println("La taille des images : 200px;");
//		List<String> widthImages = website.at(TestEndToEnd.class).widthImages();
//		for (String string : widthImages) {
//			System.out.println(string);
//		}

		String panelGridWidth = driver.findElement(By.id("panelgrid")).getCssValue("width");
		String panelFridheight = driver.findElement(By.id("panelgrid")).getCssValue("height");
		System.out.println("La taille du panel Grid est : (" + panelGridWidth + "," + panelFridheight + ")");
		if (panelGridWidth.equals("950px")) {
			System.out.println("Le panel Grid a bie ete affiché");
		} else
			System.out.println("Le panel Grid mal affiché");

	}

}
