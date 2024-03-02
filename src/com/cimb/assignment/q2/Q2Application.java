package com.cimb.assignment.q2;

import java.util.Scanner;

public class Q2Application {
	
	private final static String VERSION_SEPARATOR = "\\.";

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
			e.printStackTrace();
		}

	}
	
	private void process(String version1, String version2) throws Exception {
		
		// Validate data.
		validateData(version1, version2);
		
		// Compare Version 1 and Version 2.
		System.out.println("Result is " + compareVersion(version1, version2));
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
		
		// Validate Version 1 length.
		if (!isValidLength(version1)) {
			System.out.println("Version 1 length must be between 1 and 500");
			isValidVersion1 = false;
		}
		
		// Validate Version 2 length.
		if (!isValidLength(version2)) {
			System.out.println("Version 2 length must be between 1 and 500");
			isValidVersion1 = false;
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
	
	/**
	 * 
	 * @param version1
	 * @param version2
	 * @return -1 if Version 1 < Version 2, 1 if Version 1 > Version 2, otherwise 0
	 */
	private int compareVersion(String version1, String version2) {
		
		// Split Version 1 and Version 2 into array by dot.
		String[] version1s = version1.split(VERSION_SEPARATOR);
		String[] version2s = version2.split(VERSION_SEPARATOR);
		
		int maxIndex = getMaxIndex(version1s, version2s);
		
		// Loop Versions array member by maxIndex variable.
		for (int i = 0; i < maxIndex; i++) {
			
			// Default revision value is 0.
			int revisionVersion1 = 0;
			int revisionVersion2 = 0;
			
			// Set revision value if exists.
			if (i < version1s.length) revisionVersion1 = Integer.parseInt(version1s[i]);
			if (i < version2s.length) revisionVersion2 = Integer.parseInt(version2s[i]);
			
			// Compare by revision.
			if (revisionVersion1 < revisionVersion2) return -1;
			if (revisionVersion1 > revisionVersion2) return 1;
		}
		
		return 0;
	}
	
	private int getMaxIndex(String[] version1s, String[] version2s) {
		
		// If version1s length more than or equal version2s length, return version1s length.
		if (version1s.length >= version2s.length) return version1s.length;
		
		// return version2s length by assume version2s length is more than version1s length.
		return version2s.length;
	}
	
	/**
	 * Check Version length.
	 * @param data
	 * @return true if length is between 1 - 500
	 */
	private boolean isValidLength(String data) {
		if (data != null && data.length() >= 1 && data.length() <= 500) return true;
		return false;
	}

}
