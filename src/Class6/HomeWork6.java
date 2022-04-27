package Class6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class HomeWork6 {
	public static void main(String[] args) {

		Q6_1 test_6_1 = new Q6_1();
		test_6_1.run();
		Q6_2 test_6_2 = new Q6_2();
		test_6_2.run();
		Q6_3 test_6_3 = new Q6_3();
		test_6_3.run();
		Q6_4 test_6_4 = new Q6_4();
		test_6_4.run();
		Q6_5 test_6_5 = new Q6_5();
		test_6_5.run();
	}
}

class Q6_1 {
	LinkedHashMap<String, String> treeMap = new LinkedHashMap<String, String>();

	public void run() {

		System.out.println("6-1   -----------------");
		initTreeMap();
		putName("C1", "紅色");
		System.out.println("第一題(Map):");
		printMap();

		System.out.println();

		System.out.println("第二題(RemoveAndPutMap):");
		deleteMap("C2");
		putName("C4", "天天");
		printMap();

		System.out.println();
	}

	public void initTreeMap() {
		treeMap.put("C1", "藍色");
		treeMap.put("C2", "香菇");
		treeMap.put("C3", "小草");
	}

	public void putName(String key, String value) {
		treeMap.put(key, value);
	}

	public void printMap() {
		for (String key : treeMap.keySet()) {
			System.out.println("key:" + key + " , value: " + treeMap.get(key));
		}
	}

	public void deleteMap(String key) {
		treeMap.remove(key);
	}
}

class Q6_2 {
	String [] desc = {"id", "name"};
	ArrayList<Object> arraylist = new ArrayList<Object>();

	public void run() {

		System.out.println("6-2   -----------------");
		initArraylist();

		modifyData("C1", "紅色");
		System.out.println("第一題(List):");
		printData();
		System.out.println();

		System.out.println("第二題(RemoveAndAddList):");
		removeTag("C2");
		addTag("C4", "天天");
		printData();
		System.out.println();
	}

	public void initArraylist() {
		arraylist.add(setObjectList("C1", "藍色"));
		arraylist.add(setObjectList("C2", "香菇"));
		arraylist.add(setObjectList("C3", "小草"));
	}

	public ArrayList<Object> setObjectList(String value1, String value2) {
		ArrayList<Object> sinNminf = new ArrayList<Object>();
		sinNminf.add(value1);
		sinNminf.add(value2);
		return sinNminf;
	}

	public void removeTag(String id) {
		for (int index = 0; index < arraylist.size(); index++) {

			ArrayList<String> tempSinInfoc = new ArrayList<String>();
			tempSinInfoc = (ArrayList<String>) (arraylist.get(index));

			for (int index2 = 0; index2 < tempSinInfoc.size(); index2 ++) {
				if( desc[index2].equals("id") ) {
					if ( tempSinInfoc.get(index2).equals(id) ) {
						continue;
					}else{
						break;
					}
				}
				arraylist.remove(index);
				
			}
		}
	}

	public void addTag(String id, String name) {
		arraylist.add(setObjectList(id, name));// 加入
	}

	public void modifyData(String id, String name) {

		for (int index = 0; index < arraylist.size(); index++) {

			ArrayList<String> tempSinInfoc = new ArrayList<String>();
			tempSinInfoc = (ArrayList<String>) (arraylist.get(index));

			for (int index2 = 0; index2 < tempSinInfoc.size(); index2 ++) {
				if( desc[index2].equals("id") ) {
					if ( tempSinInfoc.get(index2).equals(id) ) {
						continue;
					}else{
						break;
					}
				}
				arraylist.remove(index);
				arraylist.add(setObjectList(id, name));// 覆蓋
				
			}
		}
	}

	public void printData() {
		for (int index = 0; index < arraylist.size(); index++) {
			ArrayList<String> tempSinInfoc = new ArrayList<String>();
			tempSinInfoc = (ArrayList<String>) (arraylist.get(index));
			for (int index2 = 0; index2 < tempSinInfoc.size(); index2 ++){
				if( desc[index2].equals("id") ){
					System.out.print("key:" + tempSinInfoc.get(index2) + "\t");
				}else if(desc[index2].equals("name")){
					System.out.print("value:" + tempSinInfoc.get(index2) + "\t");
				}
			}
			System.out.println();
		}
	}

}

class Q6_3 {
	TreeSet<Integer> treeSet = new TreeSet<Integer>();

	public void run() {
		System.out.println("6-3   -----------------");
		genNumber();
		System.out.println();
	}

	public int getNum() {
		return ((int) (Math.random() * (49 - 1 + 1)) + 1);
	}

	public void setNum() {

		while (treeSet.size() <= 6) {
			treeSet.add(getNum());
		}
	}

	public void genNumber() {

		for (int i = 1; i <= 10; i++) {
			setNum();
			System.out.println("第" + i + "組:\t" + SetStringRemoveBrackets(treeSet.toString()));
			treeSet.clear();
		}
	}

	public String SetStringRemoveBrackets(String treeSetStr) {
		return (treeSetStr.replace('[', ' ').replace(']', ' '));
	}
}

class Q6_4 {

	String[] orderDesc = { "訂單", "旅客", "訂購內容", "金額" };
	String[] custDesc = { "id", "name", "count", "sumPrice" };
	Map<String, Object> custNameMap = new TreeMap<String, Object>(); // 會員
	Map<String, Object> orderInfoMap = new TreeMap<String, Object>(); // 訂單

	public void run() {
		initMap();
		System.out.println("6-4   -----------------");

		System.out.println("1.用會員編號查詢會員買的商品");
		getCustOrderlist();
		System.out.println();

		System.out.println("2.算出每位會員的平均每筆消費金額");
		getCustAvgCost();
		System.out.println();

		System.out.println("3.依照消費總金額高到低排序");
		sort("Desc");
		System.out.println();

		System.out.println("4.依照消費總金額低到高排序");
		sort("Asc");
		System.out.println();

	}

	public void initMap() {
		setOrderInfoMap(orderInfoMap);
		setCustNameMap(custNameMap);
	}

	public ArrayList<Object> setSinOrderInfo(String value1, String value2, String value3, int value4) {
		ArrayList<Object> sinOrderInfo = new ArrayList<Object>();
		sinOrderInfo.add(value1);
		sinOrderInfo.add(value2);
		sinOrderInfo.add(value3);
		sinOrderInfo.add(value4);
		return sinOrderInfo;
	}

	public ArrayList<Object> setSinCustInfo(String value1, String value2, int value3, double value4) {
		ArrayList<Object> sinCustInfo = new ArrayList<Object>();
		sinCustInfo.add(value1);
		sinCustInfo.add(value2);
		int[] setOrder = getSumAmtandCustOrderCOunt(value1);

		sinCustInfo.add(setOrder[0]);
		sinCustInfo.add(setOrder[1]);

		return sinCustInfo;
	}

	public int[] getSumAmtandCustOrderCOunt(String custNo) {
		int cnt = 0, sum = 0;
		for (int index = 1; index <= orderInfoMap.size(); index++) {
			ArrayList<?> sinOrderInfoc = new ArrayList<String>();
			sinOrderInfoc = (ArrayList<?>) (orderInfoMap.get(getOrderNo(index)));

			for (int index2 = 0; index2 < sinOrderInfoc.size(); index2++) {
				if ((orderDesc[index2].equals("旅客") && !((sinOrderInfoc.get(index2)).equals(custNo)))) {
					break;
				}

				if (orderDesc[index2].equals("金額")) {
					cnt += 1;
					sum += (int) sinOrderInfoc.get(index2);
				}
			}
		}

		int[] rtnorder = { cnt, sum };
		return rtnorder;
	}

	public void setCustNameMap(Map<String, Object> custNameMap) {
		custNameMap.put("C1", setSinCustInfo("C1", "小Q", 0, 0));
		custNameMap.put("C2", setSinCustInfo("C2", "小咪", 0, 0));
		custNameMap.put("C3", setSinCustInfo("C3", "查理", 0, 0));
	}

	public void setOrderInfoMap(Map<String, Object> orderInfoMap) {
		orderInfoMap.put("O001", setSinOrderInfo("O001", "C1", "衣服", 789));
		orderInfoMap.put("O002", setSinOrderInfo("O002", "C1", "3C", 1999));
		orderInfoMap.put("O003", setSinOrderInfo("O003", "C2", "遊戲", 1899));
		orderInfoMap.put("O004", setSinOrderInfo("O004", "C2", "保養品", 3300));
		orderInfoMap.put("O005", setSinOrderInfo("O005", "C3", "攝影機", 14999));
	}

	public String getOrderNo(int index) {
		return String.format("O00%s", Integer.toString(index));
	}

	public String getCustNameMap(String custNo) {
		ArrayList<?> sinCustInfoc = new ArrayList<String>();
		sinCustInfoc = (ArrayList<?>) (custNameMap.get(custNo));

		for (int index = 0; index <= sinCustInfoc.size(); index++) {
			if (custDesc[index].equals("name")) {
				return (String) sinCustInfoc.get(index);
			}
		}
		return "";
	}

	public void getCustOrderlist() {
		for (int index = 1; index <= orderInfoMap.size(); index++) {
			ArrayList<?> sinOrderInfoc = new ArrayList<String>();
			sinOrderInfoc = (ArrayList<?>) (orderInfoMap.get(getOrderNo(index)));

			for (int index2 = 0; index2 < sinOrderInfoc.size(); index2++) {
				System.out.print(sinOrderInfoc.get(index2) + "\t");

				if (orderDesc[index2].equals("旅客")) {
					System.out.print(getCustNameMap((String) sinOrderInfoc.get(index2)) + "\t");
				}
			}
			System.out.println();

		}
	}

	public void getCustAvgCost() {
		int count = 0, sum = 0;
		for (String key : custNameMap.keySet()) {
			count = 0;
			sum = 0;
			ArrayList<?> sinCustInfoc = new ArrayList<String>();
			sinCustInfoc = (ArrayList<?>) (custNameMap.get(key));

			for (int index = 0; index < sinCustInfoc.size(); index++) {
				if (custDesc[index].equals("count")) {
					count = (int) sinCustInfoc.get(index);
				} else if (custDesc[index].equals("sumPrice")) {
					sum = (int) sinCustInfoc.get(index);
				}
			}

			System.out.println(
					"編號:" + key + " , 姓名: " + getCustNameMap(key) + ", 平均消費金額: " + ((float) sum / (float) count));
		}
	}

	public void printCustSumCost(Map<String, Integer> asMap) {
		for (String key : asMap.keySet()) {
			System.out.println("編號:" + key + " , 姓名: " + getCustNameMap(key) + ", 總消費金額: " + asMap.get(key));
		}
	}

	public void sort(String type) {
		Map<String, Integer> custSumCostMap = new LinkedHashMap<String, Integer>();
		int tempPrice = 0;
		String tarKey = null;

		for (String key : custNameMap.keySet()) {
			ArrayList<?> sinCustInfoc = new ArrayList<String>();
			sinCustInfoc = (ArrayList<?>) (custNameMap.get(key));

			for (int index = 0; index < sinCustInfoc.size(); index++) {
				if (custDesc[index].equals("sumPrice") && (int) sinCustInfoc.get(index) > tempPrice) {
					tempPrice = (int) sinCustInfoc.get(index);
					tarKey = key;
				}
			}
			custSumCostMap.put(tarKey, tempPrice);
		}

		custSumCostMap = setSort(custSumCostMap, type);
		printCustSumCost(custSumCostMap);
	}

	public Map<String, Integer> setSort(Map<String, Integer> asMap, String type) {
		Map<String, Integer> setSortSumCostMap = new LinkedHashMap<String, Integer>();
		String temp;
		for (String key1 : asMap.keySet()) {
			temp = null;
			for (String key2 : asMap.keySet()) {
				if ((asMap.get(key1) <= asMap.get(key2) && asMap.get(key2) != 0 && type == "Desc")
						|| (asMap.get(key1) >= asMap.get(key2) && asMap.get(key2) != 0 && type == "Asc")) {
					temp = key2;
				}
			}
			if (!temp.equals(null)) {
				setSortSumCostMap.put(temp, asMap.get(temp));
				asMap.put(temp, 0);// 排序過的補0
			}
		}

		return setSortSumCostMap;
	}
}

class Q6_5 {

	String[] orderDesc = { "訂單", "旅客", "訂購內容", "金額" };
	String[] custDesc = { "id", "name", "count", "sumPrice" };
	ArrayList<Object> custInfoList = new ArrayList<Object>();// 會員名單ID
	ArrayList<Object> orderInfoList = new ArrayList<Object>();// 會員名單姓名

	public void run() {
		initList();
		System.out.println("6-5   -----------------");

		System.out.println("1.用會員編號查詢會員買的商品");
		getCustOrderDet();
		System.out.println();

		System.out.println("2.算出每位會員的平均每筆消費金額");
		getCustAvgCost();
		System.out.println();
		
		System.out.println("3.依照消費總金額高到低排序");
		sort("Desc");
		System.out.println();
		
		System.out.println("4.依照消費總金額低到高排序");
		sort("Asc");
		System.out.println();
	}

	public void initList() {
		setOrderInfoList(orderInfoList);
		setCustInfoList(custInfoList);
	}

	public void setCustInfoList(List<Object> custNameMap) {
		custInfoList.add(setSinCustInfo("C1", "小Q", 0, 0));
		custInfoList.add(setSinCustInfo("C2", "小咪", 0, 0));
		custInfoList.add(setSinCustInfo("C3", "查理", 0, 0));
	}

	public void setOrderInfoList(List<Object> orderInfoMap) {
		orderInfoList.add(setSinOrderInfo("O001", "C1", "衣服", 789));
		orderInfoList.add(setSinOrderInfo("O002", "C1", "3C", 1999));
		orderInfoList.add(setSinOrderInfo("O003", "C2", "遊戲", 1899));
		orderInfoList.add(setSinOrderInfo("O004", "C2", "保養品", 3300));
		orderInfoList.add(setSinOrderInfo("O005", "C3", "攝影機", 14999));
	}

	public String getCustNameList(String custNo) {

		for (int index = 0; index < custInfoList.size(); index++) {
			ArrayList<?> sinCustInfoc = new ArrayList<String>();
			sinCustInfoc = (ArrayList<?>) (custInfoList.get(index));

			for (int index2 = 0; index2 < sinCustInfoc.size(); index2++) {

				if (custDesc[index2].equals("id") && sinCustInfoc.get(index2) != custNo) {
					break;
				}
				if (custDesc[index2].equals("name")) {
					return (String) sinCustInfoc.get(index2);
				}
			}
		}

		return "";
	}

	public String getOrderNo(int index) {
		return String.format("O00%s", Integer.toString(index));
	}

	public ArrayList<Object> setSinOrderInfo(String value1, String value2, String value3, int value4) {
		ArrayList<Object> sinOrderInfo = new ArrayList<Object>();
		sinOrderInfo.add(value1);
		sinOrderInfo.add(value2);
		sinOrderInfo.add(value3);
		sinOrderInfo.add(value4);
		return sinOrderInfo;
	}

	public ArrayList<Object> setSinCustInfo(String value1, String value2, int value3, double value4) {
		ArrayList<Object> sinCustInfo = new ArrayList<Object>();
		sinCustInfo.add(value1);
		sinCustInfo.add(value2);
		int[] setOrder = getSumAmtandCustOrderCount(value1);

		sinCustInfo.add(setOrder[0]);
		sinCustInfo.add(setOrder[1]);

		return sinCustInfo;
	}

	public int[] getSumAmtandCustOrderCount(String custNo) {
		int cnt = 0, sum = 0;
		for (int index = 0; index < orderInfoList.size(); index++) {
			ArrayList<?> sinOrderInfoc = new ArrayList<String>();
			sinOrderInfoc = (ArrayList<?>) (orderInfoList.get(index));

			for (int index2 = 0; index2 < sinOrderInfoc.size(); index2++) {
				if ((orderDesc[index2].equals("旅客") && !((sinOrderInfoc.get(index2)).equals(custNo)))) {
					break;
				}

				if (orderDesc[index2].equals("金額")) {
					cnt += 1;
					sum += (int) sinOrderInfoc.get(index2);
				}
			}
		}

		int[] rtnorder = { cnt, sum };
		return rtnorder;
	}

	public void getCustOrderDet() {
		for (int index = 0; index < orderInfoList.size(); index++) {
			ArrayList<?> sinOrderInfoc = new ArrayList<String>();
			sinOrderInfoc = (ArrayList<?>) (orderInfoList.get(index));

			for (int index2 = 0; index2 < sinOrderInfoc.size(); index2++) {
				System.out.print(sinOrderInfoc.get(index2) + "\t");
				if (orderDesc[index2].equals("旅客")) {
					System.out.print(getCustNameList((String) sinOrderInfoc.get(index2)) + "\t");
				}
			}
			System.out.println();
		}
	}

	public void getCustAvgCost() {
		int count = 0, sum = 0;
		String id = null;
		for (int index = 0; index < custInfoList.size(); index++) {
			count = 0;
			sum = 0;
			ArrayList<?> sinCustInfoc = new ArrayList<String>();
			sinCustInfoc = (ArrayList<?>) (custInfoList.get(index));

			for (int index2 = 0; index2 < sinCustInfoc.size(); index2++) {
				if (custDesc[index2].equals("count")) {
					count = (int) sinCustInfoc.get(index2);
				} else if (custDesc[index2].equals("sumPrice")) {
					sum = (int) sinCustInfoc.get(index2);
				} else if (custDesc[index2].equals("id")) {
					id = (String) sinCustInfoc.get(index2);
				}
			}
			System.out.println("編號:" + id + " , 姓名: " + getCustNameList(id) + ", 平均消費金額: " + ((float) sum / (float) count));
		}
	}
	
	public ArrayList<Integer> setSortObject(int index, int sumPrice) {
		ArrayList<Integer> custSinSumCostList = new ArrayList<Integer>();
		custSinSumCostList.add(index);
		custSinSumCostList.add(sumPrice);
		return custSinSumCostList;
	}
	
	public String getCustNoList(int index) {

		for (int index1 = 0; index1 < custInfoList.size(); index1 ++) {
			
			if (index1 != index) {
				continue;
			}
			ArrayList<?> sinCustInfoc = new ArrayList<String>();
			sinCustInfoc = (ArrayList<?>) (custInfoList.get(index1));
			
			for (int index2 = 0; index2 < sinCustInfoc.size(); index2++) {
				
				if (custDesc[index2].equals("id")) {
					return (String) sinCustInfoc.get(index2);
				}
			}
		}

		return "";
	}
	
	public void printCustSumCost(ArrayList<Object> asList, String[] asSortName ) {

		for (int index = 0; index < asList.size(); index++) {
			
			ArrayList<Integer> tempSinInfoc = new ArrayList<Integer>();
			tempSinInfoc = (ArrayList<Integer>) (asList.get(index));
			
			for (int index2 = 0; index2 < tempSinInfoc.size(); index2 ++) {
				if (asSortName[index2].equals("index")) {
					System.out.print("編號:" + getCustNoList(tempSinInfoc.get(index2)) + 
									 " , 姓名: " + getCustNameList(getCustNoList(tempSinInfoc.get(index2))) );
					
				}else if(asSortName[index2].equals("price")) {
					System.out.println(", 總消費金額:" + tempSinInfoc.get(index2) + "\t");
				}
				
			}
		}

	}
	
	public void sort(String type) {
		ArrayList<Object> custSumCostList = new ArrayList<Object>();
		int tempPrice = 0;
		int tarIndex = 0;

		for (int index = 0; index < custInfoList.size(); index ++) {
			ArrayList<?> sinCustInfoc = new ArrayList<String>();
			sinCustInfoc = (ArrayList<?>) (custInfoList.get(index));

			for (int index2 = 0; index2 < sinCustInfoc.size(); index2 ++) {
				if (custDesc[index2].equals("sumPrice") && (int) sinCustInfoc.get(index2) > tempPrice) {
					tempPrice = (int) sinCustInfoc.get(index2);
					tarIndex = index;
				}
			}
			custSumCostList.add(setSortObject(tarIndex, tempPrice));
		}
		
		String [] sortName = {"index", "price"};
		custSumCostList = setSort(custSumCostList, sortName, type);
		printCustSumCost(custSumCostList, sortName);
	}

	public ArrayList<Object> setSort(ArrayList<Object> asList, String[] asSortName, String type) {
		ArrayList<Object> setSortSumCostList = new ArrayList<Object>();
		ArrayList<Integer> sinInxfoc = new ArrayList<Integer>();
		ArrayList<Integer> sinPriceInfoc = new ArrayList<Integer>();
		
		//拆分
		for (int asIndex = 0; asIndex < asList.size(); asIndex++) {

			ArrayList<Integer> tempSinInfoc = new ArrayList<Integer>();
			tempSinInfoc = (ArrayList<Integer>) (asList.get(asIndex));
			
			for (int index = 0; index < tempSinInfoc.size(); index ++) {
				if( asSortName[index].equals("index") ) {
					sinInxfoc.add(tempSinInfoc.get(index));
				}else if (asSortName[index].equals("price")){
					sinPriceInfoc.add(tempSinInfoc.get(index));
				}
			}
		}
			
		//排序後組裝成 object
		int temp;

		for (int index = 0; index < sinPriceInfoc.size(); index ++) {
			temp = 99;
			for (int index2 = 0; index2 < sinPriceInfoc.size(); index2 ++) {
				if (( sinPriceInfoc.get(index) <= sinPriceInfoc.get(index2) && sinPriceInfoc.get(index2) != 0 && type == "Desc")
						|| (sinPriceInfoc.get(index) >= sinPriceInfoc.get(index2) && sinPriceInfoc.get(index2) != 0 && type == "Asc")) {
					temp = index2;
				}
				
			}

			if(temp != 99){
				setSortSumCostList.add( setSortObject( sinInxfoc.get(temp), sinPriceInfoc.get(temp)) );
				sinPriceInfoc.remove(temp);
				sinPriceInfoc.add(temp, 0);
			}
		}
	
		return setSortSumCostList;
	}

}