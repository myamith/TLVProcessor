/**
 * 
 */
package com.tlvProcessor.process;

import java.io.IOException;

import com.tlvProcessor.util.GetProperties;

/**
 * @author Amith
 *
 */
public class Process {

	private String result;
	private String processor;
	private String data;
	private int dataLength;

	public Process(String processor, String data, int dataLength) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		this.processor = processor;
		this.data = data;
		this.dataLength = dataLength;
		run();
	}
	
	private void run() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		GetProperties processorType = new GetProperties();
		String processorClass = processorType.getPropValues(processor);
		if (processorClass == null)
		{
			setResult("Type not valid");
		}
		else{
			Processor resolvedProcessor = (Processor) Class.forName(processorClass).newInstance();
			setResult(processor+"-"+resolvedProcessor.process(data,dataLength));
		}
	}

//	private void getPocessorAndData() {
//		// TODO Auto-generated method stub
//		
////		String[] TLVData = inputData.split("-");
////		data =  TLVData[TLVData.length-1];
////		processor = TLVData[0];
////		dataLength = Integer.parseInt(TLVData[1]);
//	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
