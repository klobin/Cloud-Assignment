package com.assignment.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@EnableAutoConfiguration
public class RestController {

	Set<Integer> generatedNumbers = new HashSet<Integer>();
	int lastUsedNumber = 1000000000;

	@GetMapping("/getNumber/")
	public String getNumber() {
		while (generatedNumbers.contains(lastUsedNumber)) {
			++lastUsedNumber;
		}
		generatedNumbers.add(lastUsedNumber);
		return "Allocated Number is " + lastUsedNumber;
	}

	@GetMapping("/assignNumber/number")
	public String checkAssignedNumber(@RequestParam Integer cellNumber) {
		if (!isValid(cellNumber)) {
			return "Mobile number entered is not valid.";
		}

		if (generatedNumbers.contains(cellNumber)) {
			while (generatedNumbers.contains(cellNumber)) {
				lastUsedNumber = +1;
			}
			return "Allocated Number is " + lastUsedNumber;
		}

		return "You have been allocated the " + cellNumber;

	}

	private boolean isValid(Integer cellNumber) {
		return String.valueOf(cellNumber).length() == 10;
	}

}
