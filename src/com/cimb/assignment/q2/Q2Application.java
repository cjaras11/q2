package com.cimb.assignment.q2;

import java.util.Scanner;

public class Q2Application {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Get Version 1 input from console.
		System.out.println("Please enter Version 1.");
		String version1 = scanner.nextLine();
		
		// Get Version 2 input from console.
		System.out.println("Please enter Version 2.");
		String version2 = scanner.nextLine();
		
		scanner.close();
		
		try {
			new Q2Application().process(version1, version2);
		} catch (Exception e) {
			
		}

	}
	
	private void process(String version1, String version2) throws Exception {
		
		// Validate data.
		validateData(version1, version2);
			
	}
	
	/**
	 * Validate data before process.
	 * @param version1
	 * @param version2
	 * @throws Exception
	 */
	private void validateData(String version1, String version2) throws Exception {
		
		boolean isValidVersion1 = true;
		boolean isValidVersion2 = true;
		
		// Validate Version 1 pattern.
		if (!isValidVersionPattern(version1)) {
			System.out.println("Version 1 is invalid");
			isValidVersion1 = false;
		}
		
		// Validate Version 2 pattern.
		if (!isValidVersionPattern(version2)) {
			System.out.println("Version 2 is invalid");
			isValidVersion2 = false;
		}
		
		// If Version 1 or Version 2 invalid, end process.
		if (!isValidVersion1 || !isValidVersion2) throw new Exception("Invalid Data.");
		
	}
	
	/**
	 * Validate Data Pattern
	 * @param data
	 * @return true if data is valid, otherwise false;
	 */
	private boolean isValidVersionPattern(String data) {
		return data.matches("[0-9]+(\\.[0-9]+)*");
	}

}
