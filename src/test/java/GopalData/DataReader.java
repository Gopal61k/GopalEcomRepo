package GopalData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.jar.asm.TypeReference;

public class DataReader 
{
	public List<HashMap<String, String>> getDataReaderToMap() throws IOException  
	{
 		String jsonContent = FileUtils.readFileToString(new File("D:\\My Project-1993\\RahulSettyAcademy\\src\\test\\java\\GopalData\\purchaseOrder.json"));
	
	 ObjectMapper mapper=new ObjectMapper();
	 List<HashMap<String,String>> data= mapper.readValue(jsonContent, new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String,String>>> (){
	});
	 return data;
	 
	 
	}

}
