package com.tlvProcessor;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tlvProcessor.Application;
import com.tlvProcessor.process.Process;

/**
 * 
 */

/**
 * @author amkb
 *
 */
public class ApplicationTest {

	/**
	 * @throws java.lang.Exception
	 */
	String processor;
	String data;
	String dataLength;
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testUPPRCS() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String args[] = {"UPPRCS-0005-abcde"};
		ArrayList<String> result = new ArrayList<String>();
		result.add("UPPRCS-ABCDE");
		assertEquals(result,Application.mainRun(args));
	}
	
	@Test
	public void testREPLCE() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String args[] = {"REPLCE-0003-123"};
		ArrayList<String> result = new ArrayList<String>();
		result.add("REPLCE-THIS STRING");
		assertEquals(result,Application.mainRun(args));
	}
	
	@Test
	public void testUPPRCSRestLength() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String args[] = {"UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z"};
		ArrayList<String> result = new ArrayList<String>();
		result.add("UPPRCS-ABCDEFGH");
		result.add("REPLCE-THIS STRING");
		result.add("REPLCE-THIS STRING");
		assertEquals(result,Application.mainRun(args));
	}
	
	@Test
	public void testUPPRCSInvalid() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String args[] = {"TAG001-0012-abcdefgh1234"};
		ArrayList<String> result = new ArrayList<String>();
		result.add("Type not valid");
		assertEquals(result,Application.mainRun(args));
	}
	
	@Test
	public void testUPPRCSNumbers() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String args[] = {"UPPRCS-0004-1234"};
		ArrayList<String> result = new ArrayList<String>();
		result.add("UPPRCS-1234");
		assertEquals(result,Application.mainRun(args));
	}
	
}
