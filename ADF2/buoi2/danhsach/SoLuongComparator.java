package buoi2.danhsach;

import java.util.Comparator;
import java.util.Map;

public class SoLuongComparator implements Comparator<String> {
	Map<String, Integer> dsMap;

	public SoLuongComparator(Map<String, Integer> dsMap) {
		super();
		this.dsMap = dsMap;
	}

	@Override
	public int compare(String key1, String key2) {
		// TODO Auto-generated method stub
		Integer value1=dsMap.get(key1);
		Integer value2=dsMap.get(key2);
		int sosanhsoluong=value2.compareTo(value1);
		if(sosanhsoluong==0) return-1;
		return sosanhsoluong;
	}
	
	


}
