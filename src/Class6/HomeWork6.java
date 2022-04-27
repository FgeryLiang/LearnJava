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
	LinkedHashMap<String, student> treeMap = new LinkedHashMap<String, student>();

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
		treeMap.put("C1", new student("C1", "藍色"));
		treeMap.put("C2", new student("C2", "香菇"));
		treeMap.put("C3", new student("C3", "小草"));
	}

	public void modName(String key, String value) {
		treeMap.get(key).setName(value);
	}
	
	public void putName(String key, String value) {
		treeMap.put(key, new student(key, value));
	}

	public void printMap() {
		for (String key : treeMap.keySet()) {
			System.out.println("key:" + treeMap.get(key).getId() + " , value: " + treeMap.get(key).getName());
		}
	}

	public void deleteMap(String key) {
		treeMap.remove(key);
	}
}

class Q6_2 {
	ArrayList<student> arraylist = new ArrayList<student>();

	public void run() {

		System.out.println("6-2   -----------------");
		initArraylist();

		modifyData("C1", "紅色");
		System.out.println("第一題(List):");
		printList();
		System.out.println();

		System.out.println("第二題(RemoveAndAddList):");
		removeTag("C2");
		addTag("C4", "天天");
		printList();
		System.out.println();
	}
	
	public void initArraylist() {
		arraylist.add(new student("C1", "藍色"));
		arraylist.add(new student("C2", "香菇"));
		arraylist.add(new student("C3", "小草"));
	}
	
	public void modifyData(String id, String mod_name) {
		for (int index = 0; index < arraylist.size(); index ++) {
			if (arraylist.get(index).getId().equals(id)) {
				arraylist.remove(index);
				arraylist.add(index, new student("C1", "紅色"));
			}
		}
	}
	
	public void printList() {
		for (int index = 0; index < arraylist.size(); index ++) {
			System.out.println("key:" + arraylist.get(index).getId() + ", value:" + arraylist.get(index).getName());
		}
	}
	
	public void removeTag(String id) {
		for (int index = 0; index < arraylist.size(); index ++) {
			if (arraylist.get(index).getId().equals(id)) {
				arraylist.remove(index);
				break;
			}
		}
	}
	
	public void addTag(String id, String name) {
		arraylist.add(new student(id, name));
	}

}

class student {
	String id;
	String name;
	
	public student(String id, String name) {
	    this.id = id;
	    this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
			ArrayList<Integer> asSet = new ArrayList<Integer>(treeSet);
			System.out.print("第" + i + "組:\t" );
			for (int index = 0; index < asSet.size(); index ++) {
				System.out.print(asSet.get(index) + "\t");
			}
			System.out.println();
			treeSet.clear();
		}
	}

	public String SetStringRemoveBrackets(String treeSetStr) {
		return (treeSetStr.replace('[', ' ').replace(']', ' '));
	}
}

class custInfo {
	String custNo, custNm;
	public custInfo ( String custNo, String custNm) {
	    this.custNo = custNo;
	    this.custNm = custNm;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustNm() {
		return custNm;
	}
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
}

class orderInfo {

	String orderNo, custNo, orderDesc;
	int amt;
	
	public orderInfo(String orderNo, String custNo, String orderDesc, int amt) {
	    this.orderNo = orderNo;
	    this.custNo = custNo;
	    this.orderDesc = orderDesc;
	    this.amt = amt;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}
}

class Q6_4 {

	Map<String, custInfo> custInfoMap = new TreeMap<String, custInfo>(); // 會員
	Map<String, orderInfo> orderInfoMap = new TreeMap<String, orderInfo>(); // 訂單

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
		setCustInfoMap(custInfoMap);
	}	

	public void setCustInfoMap(Map<String, custInfo> custNameMap) {
		custNameMap.put("C1", new custInfo("C1", "小Q"));
		custNameMap.put("C2",  new custInfo("C2", "小咪"));
		custNameMap.put("C3",  new custInfo("C3", "查理"));
	}

	public void setOrderInfoMap(Map<String, orderInfo> orderInfoMap) {
		orderInfoMap.put("O001", new orderInfo("O001", "C1", "衣服", 789));
		orderInfoMap.put("O002", new orderInfo("O002", "C1", "3C", 1999));
		orderInfoMap.put("O003", new orderInfo("O003", "C2", "遊戲", 1899));
		orderInfoMap.put("O004", new orderInfo("O004", "C2", "保養品", 3300));
		orderInfoMap.put("O005", new orderInfo("O005", "C3", "攝影機", 14999));
	}
	
	public void getCustOrderlist() {
		for ( String key: orderInfoMap.keySet()) {
			System.out.println(
							orderInfoMap.get(key).getOrderNo() + "\t" + 
							orderInfoMap.get(key).getCustNo() + "\t" + 
							getCustNm(orderInfoMap.get(key).getCustNo()) + "\t" + 
							orderInfoMap.get(key).getOrderDesc() + "\t" + 
							orderInfoMap.get(key).getAmt() );
		}
	}
	
	public String getCustNm(String custNo) {
		return custInfoMap.get(custNo).getCustNm();
	}
	
	public void getCustAvgCost() {

		for ( String key: custInfoMap.keySet()) {
			if (custInfoMap.get(key).getCustNo().equals(key)) {
				System.out.println( "編號:" + custInfoMap.get(key).getCustNo() + ", " + 
									"姓名:" + custInfoMap.get(key).getCustNm() + ", " + 
									"平均消費金額:" + (float) getSumCost(key) /  (float) getCustOrderCount(key) );
			}
		}
	}
	
	public int getSumCost(String custNo) {
		int rtnAmt = 0;
		for ( String key: orderInfoMap.keySet()) {
			if (orderInfoMap.get(key).getCustNo().equals(custNo)) {
				rtnAmt += orderInfoMap.get(key).getAmt();
			}
		}
		return rtnAmt;
	}
	
	public int getCustOrderCount(String custNo) {
		int rtnCount = 0;
		for ( String key: orderInfoMap.keySet()) {
			if (orderInfoMap.get(key).getCustNo().equals(custNo)) {
				rtnCount ++;
			}
		}
		return rtnCount;
		
	}
	
	public boolean checkSortFinally(ArrayList<String> asList, String key) {
		for (int index = 0; index < asList.size(); index ++) {
			if( asList.get(index).equals(key)) {
				return false;
			}
		}
		return true;
	}
	
	public void sort(String type) {
		ArrayList<String> setSortNo = new ArrayList<String>();
		String temp = null;
		int orderAmt1 = 0, orderAmt2 = 0;
		for (String key1: custInfoMap.keySet()) {
			temp = null;
			orderAmt1 = ( !checkSortFinally(setSortNo, key1) ? 0 : getSumCost(custInfoMap.get(key1).getCustNo()));
			
			for (String key2: custInfoMap.keySet()) {
				orderAmt2 = ( !checkSortFinally(setSortNo, key2) ? 0 : getSumCost(custInfoMap.get(key2).getCustNo()));
				if ( (orderAmt1 <= orderAmt2 && orderAmt2 != 0 && type.equals("Desc") )|| 
						(orderAmt1 >= orderAmt2 && orderAmt2 != 0 && type.equals("Asc") )) {
					temp = key2;
				}
			}
			if ( !temp.equals(null) ) {
				setSortNo.add(temp);
				System.out.println( "編號:" + custInfoMap.get(temp).getCustNo() + ", " + 
						"姓名:" + custInfoMap.get(temp).getCustNm() + ", " + 
						"總消費金額:" + getSumCost(custInfoMap.get(temp).getCustNo() ));
			}
		}
	}
}

class Q6_5 {

	ArrayList<custInfo> custInfoList = new ArrayList<custInfo>();// 會員名單ID
	ArrayList<orderInfo> orderInfoList = new ArrayList<orderInfo>();// 會員名單姓名

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
		setCustInfoList(custInfoList);
		setOrderInfoList(orderInfoList);
	}

	public void setCustInfoList(List<custInfo> custNameMap) {
		custInfoList.add(new custInfo("C1", "小Q"));
		custInfoList.add(new custInfo("C2", "小咪"));
		custInfoList.add(new custInfo("C3", "查理"));
	}

	public void setOrderInfoList(List<orderInfo> orderInfoMap) {
		orderInfoList.add(new orderInfo("O001", "C1", "衣服", 789));
		orderInfoList.add(new orderInfo("O002", "C1", "3C", 1999));
		orderInfoList.add(new orderInfo("O003", "C2", "遊戲", 1899));
		orderInfoList.add(new orderInfo("O004", "C2", "保養品", 3300));
		orderInfoList.add(new orderInfo("O005", "C3", "攝影機", 14999));
	}

	public void getCustOrderDet() {
		for (int index = 0; index < orderInfoList.size(); index++) {
			System.out.println(
					orderInfoList.get(index).getOrderNo() + "\t" + 
					orderInfoList.get(index).getCustNo() + "\t" + 
					getCustNm(orderInfoList.get(index).getCustNo()) + "\t" + 
					orderInfoList.get(index).getOrderDesc() + "\t" + 
					orderInfoList.get(index).getAmt() );
		}
	}
	
	public String getCustNm(String custNo){
		for (int index = 0; index < custInfoList.size(); index++) {
			if (custInfoList.get(index).getCustNo().equals(custNo)) {
				return custInfoList.get(index).getCustNm();
			}
		}
		return "";
		
	}
	
	public int getSumCost(String custNo) {
		int rtnAmt = 0;
		for (int index = 0; index < orderInfoList.size(); index++){
			if (orderInfoList.get(index).getCustNo().equals(custNo)){
				rtnAmt += orderInfoList.get(index).getAmt();
			}
		}
		return rtnAmt;
	}
	
	public int getCustOrderCount(String custNo) {
		int rtnCount = 0;
		for (int index = 0; index < orderInfoList.size(); index++){
			if (orderInfoList.get(index).getCustNo().equals(custNo)){
				rtnCount += 1;
			}
		}
		return rtnCount;
	}
	public void getCustAvgCost() {
		for (int index = 0; index < custInfoList.size(); index++){
			System.out.println( "編號:" + custInfoList.get(index).getCustNo() + ", " + 
					"姓名:" + custInfoList.get(index).getCustNm() + ", " + 
					"平均消費金額:" + (float) getSumCost(custInfoList.get(index).getCustNo()) /  (float) getCustOrderCount(custInfoList.get(index).getCustNo()) );
		}
	}
	
	public boolean checkSortFinally(ArrayList<String> asList, String key) {
		for (int index = 0; index < asList.size(); index ++) {
			if( asList.get(index).equals(key)) {
				return false;
			}
		}
		return true;
	}
	
	public void sort(String type){
		ArrayList<String> setSortList = new ArrayList<String>();
		int temp = 99, custAmt1 = 0, custAmt2 = 0;
		for (int index1 = 0; index1 < custInfoList.size(); index1 ++) {
			temp = 99;
			custAmt1 = ( !checkSortFinally(setSortList, custInfoList.get(index1).getCustNo()) ? 0 : getSumCost(custInfoList.get(index1).getCustNo()));
			for (int index2 = 0; index2 < custInfoList.size(); index2 ++){
				custAmt2 = ( !checkSortFinally(setSortList, custInfoList.get(index2).getCustNo()) ? 0 : getSumCost(custInfoList.get(index2).getCustNo()));
				if ( (custAmt1 <= custAmt2 && custAmt2 != 0 && type.equals("Desc") )|| 
						(custAmt1 >= custAmt2 && custAmt2 != 0 && type.equals("Asc") )) {
					temp = index2;
				}
			}
			
			if ( temp != 99 ) {
				setSortList.add(custInfoList.get(temp).getCustNo());
				System.out.println( "編號:" + custInfoList.get(temp).getCustNo() + ", " + 
						"姓名:" + custInfoList.get(temp).getCustNm() + ", " + 
						"總消費金額:" + getSumCost(custInfoList.get(temp).getCustNo() ));
			}
		}
	}

}