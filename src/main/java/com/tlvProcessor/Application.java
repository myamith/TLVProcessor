package com.tlvProcessor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Amith
 *
 */
import com.tlvProcessor.process.Process;;

public class Application {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		mainRun(args);
	}
	
	public static ArrayList<String> mainRun(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		ArrayList<String> listedResult = new ArrayList<String>();
		for (String arg : args) {
			for (int i = 0; i < arg.length();) {
				String processor = arg.substring(i, i = i + 6);
				i = i + 1; // to bypass "-"
				int dataLength = Integer.parseInt(arg.substring(i, i = i + 4));
				i = i + 1; // to bypass "-"
				String data = arg.substring(i, i = i + dataLength);
				Process processData = new Process(processor, data, dataLength);
				System.out.println(processData.getResult());
				listedResult.add(processData.getResult());
			}
		}
		return listedResult;
	}

}
