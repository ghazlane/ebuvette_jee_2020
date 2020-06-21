package com.e_buvette.ebuvette;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.e_buvette.ebuvette.controller.HomeController;

@SpringBootTest(classes=com.e_buvette.ebuvette.controller.HomeController.class)
public class ControllerTest {

	@Autowired
	private HomeController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
