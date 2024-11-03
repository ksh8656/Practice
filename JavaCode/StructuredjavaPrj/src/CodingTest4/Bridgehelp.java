package CodingTest4;

public class Bridgehelp {
	
	static long Combination(int n,int m) {
		long result = 1;
		if(m>n)
			return 0;
		else {		
		for(int i=0; i<m; i++) {
			result = result*(n-i)/(i+1);
		}
	  }
		return result;
  }
}
