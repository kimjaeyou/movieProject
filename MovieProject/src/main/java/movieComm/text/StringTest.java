package movieComm.text;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Component;

@Component
public class StringTest {

	public static double Levenshtein(String a, String b) {
		
		String arrA[];
		
		int maxLen = a.length() > b.length() ? a.length() : b.length();
		
		LevenshteinDistance ld = new LevenshteinDistance();
		
		double result = 0;
		double temp = ld.apply(a, b);
		result = (maxLen - temp) / maxLen; 
		
		
		if(result < 0.6) {
			arrA=a.split(" ");
			if(arrA.length>1) a=arrA[1]+" "+arrA[0];
			temp = ld.apply(a, b);
			result = (maxLen - temp) / maxLen; 
		}
		
		return result;
		
	}
}