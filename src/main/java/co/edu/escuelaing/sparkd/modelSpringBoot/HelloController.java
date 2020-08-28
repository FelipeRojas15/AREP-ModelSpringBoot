/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.sparkd.modelSpringBoot;

/**
 *
 * @author rojas
 */
public class HelloController {

	@RequestMapping("/hola")
	static public String hola() {
		return "Greetings from Model Spring Boot!";
	}
}
