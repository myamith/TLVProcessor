/**
 * 
 */
package com.tlvProcessor.process;

/**
 * @author Amith
 *
 */
public class UpperCaseProcessor implements Processor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tlvProcessor.process.Processor#process(java.lang.String)
	 */
	public String process(String data, int dataLength) {
		// TODO Auto-generated method stub
		if (data.length() > dataLength)
			return data.toUpperCase().substring(0, dataLength);
		else
			return data.toUpperCase();
	}

}
