package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeConverterImpl implements TimeConverter {

	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);
	
	@Override
	public String convertTime(String aTime) {
	StringBuffer generatedTime = new StringBuffer();
	String[] splits = aTime.split(":");
	
	LOG.debug("Time got in parts: " + splits[0] + " " + splits[1] + " " + splits[2]);
	generatedTime.append(getSeconds(Integer.parseInt(splits[2]))+ "\n");
	generatedTime.append(getHours(Integer.parseInt(splits[0])) + "\n");
	generatedTime.append(getMinutes(Integer.parseInt(splits[1])));
	
	LOG.debug("--- Berlin Clock Time ---\n" + generatedTime); 
	return generatedTime.toString();
	
	}
	
	
	private String getSeconds(int parseInt) {
		return parseInt%2==0?"Y":"O";
	}


	private String getMinutes(int parseInt) {
		StringBuffer hoursConstant = new StringBuffer();
		int quotient = parseInt/5;
		int remainder = parseInt%5;
		hoursConstant.append(generateString(quotient,11)).append("\n").append(generateString(remainder,4,"Y"));
		return hoursConstant.toString();
	}

	private String getHours(int parseInt) {
		StringBuffer hoursConstant = new StringBuffer();
		int quotient = parseInt/5;
		int remainder = parseInt%5;
		hoursConstant.append(generateString(quotient,4,"R")).append("\n").append(generateString(remainder,4,"R"));
		return hoursConstant.toString();
	}

	public String generateString(int yInt , int total)
	{ String s = "";
	  int counter = 1;
		for(int i = 0 ; i < yInt ; i++)
		{
			if(counter==3){s+="R";counter=0;}else{s+="Y";};
			counter++;
		}
		for(int i=yInt ; i<total ; i++)
		{
			s = s+"O";
		}
		
		return s;
	}
	
	public String generateString(int yInt , int total,String c)
	{ 	String s = "";
	  	for(int i = 0 ; i < yInt ; i++)
		{s+=c;}
		for(int i=yInt ; i<total ; i++)
		{s = s+"O";}
		return s;
	}


}
