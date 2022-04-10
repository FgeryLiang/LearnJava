package Class6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
	Map<String, String> treeMap = new HashMap<String, String>();
	// LinkedHashMap<String, String> treeMap = new LinkedHashMap<String, String>();
	// Map<String, String> treeMap = new TreeMap<String, String>();

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

class Q6_2{
	LinkedList<String> arraylistId = new LinkedList<String>();
	LinkedList<String> arraylistName = new LinkedList<String>();
//	ArrayList<String> arraylistId = new ArrayList<String>();
//	ArrayList<String> arraylistName = new ArrayList<String>();
	
	
	public void run() {
		

		System.out.println("6-2   -----------------");
		initArraylist();
		
		modifyData( getIndex("C1"), "紅色" );
		System.out.println("第一題(List):");
		printData();
		System.out.println();

		System.out.println("第二題(RemoveAndAddList):");
		removeTag(getIndex("C2"));
		addTag("C4", "天天");
		printData();
		System.out.println();
	}
	
	public void initArraylist() {
		arraylistId.add("C1");
		arraylistId.add("C2");
		arraylistId.add("C3");
		
		arraylistName.add("藍色");
		arraylistName.add("香菇");
		arraylistName.add("小草");
	}
	
	public int getIndex(String listValue) {
		for (int index = 0; index < arraylistId.size(); index++) {
			if (listValue == arraylistId.get(index)) {
				return index;
			}
		}
		return -1;
	}
	
	public void removeTag(int index ) {
		arraylistId.remove(index);
		arraylistName.remove(index);
	}
	
	public void addTag(String id, String data) {
		arraylistId.add(id);
		arraylistName.add(data);//加入
	}
	
	public void modifyData(int index, String value) {
		arraylistName.remove(index);
		arraylistName.add(index, value);//覆蓋
	}
	
	public void printData() {
		for (int index = 0; index < arraylistId.size(); index ++) {
			System.out.println("key:" + arraylistId.get(index) + " , value: " + arraylistName.get(index));
		}
	}
	
}

class Q6_3{
//	TreeSet<String> lotto = new TreeSet<String>();
	TreeSet<Integer> treeSet = new TreeSet<Integer>();
	
	public void run() {
		System.out.println("6-3   -----------------");
		genNumber();
		System.out.println();
	}
	
	public int getNum() {
		return ( (int) (Math.random() * ( 49 -1 + 1)) + 1 );
	}
	
	public void setNum() {
		
		while( treeSet.size() <= 6){
			treeSet.add(getNum());
		}
	}
	
	public void genNumber() {
		
		for(int i = 1; i <= 10; i ++){
			setNum();
			System.out.println("第" + i + "組:\t" +  SetStringRemoveBrackets( treeSet.toString() ) ); 
			treeSet.clear();
		}
	}
	
	public String SetStringRemoveBrackets(String treeSetStr) {
		return ( treeSetStr.replace('[', ' ').replace(']', ' ') );
	}
}


class Q6_4{

	Map<String, String> custNameMap = new TreeMap<String, String >(); //會員名單
	Map<String, String> orderCustMap = new TreeMap<String, String >();//訂單所屬會員
	Map<String, String> orderDescMap = new TreeMap<String, String >();//訂單內容
	Map<String, Integer> orderAmtMap = new TreeMap<String, Integer>();//訂單金額
	Map<String, Integer> custSumCostMap = new TreeMap<String, Integer >();//會員花費金額
	Map<String, Integer> custOrderCountMap = new TreeMap<String, Integer >();//會員訂單數

	public void run() {
		initMap();
		System.out.println("6-4   -----------------");
//		System.out.println("1.用會員編號查詢會員買的商品，請輸入會員編號:");
//		getCustOrderlist(inputPara());
		
		System.out.println("1.用會員編號查詢會員買的商品");
		getCustOrderlist();
		System.out.println();
		
		System.out.println("2.算出每位會員的平均每筆消費金額");
		getCustAvgCost();
		System.out.println();
		
		System.out.println("3.依照消費總金額高到低排序");
		setSortDesc();
		System.out.println();
		
		System.out.println("4.依照消費總金額低到高排序");
		printCustSumCost(custSumCostMap);
		System.out.println();
		
	}
	
	public void initMap() {
		setCustNameMap(custNameMap);
		setOrderCustMap(orderCustMap);
		setOrderDescMap(orderDescMap);
		setOrderAmtMap(orderAmtMap);
	}

//	public String inputPara() {
//		Scanner scanner = new Scanner(System.in);
//		return scanner.next();
//	}

	public void setCustNameMap(Map<String, String> custNameMap) {
		custNameMap.put("C1", "小Q");
		custNameMap.put("C2", "小咪");
		custNameMap.put("C3", "查理");
	}

	public void setOrderCustMap(Map<String, String> orderCustMap) {
		orderCustMap.put("O001", "C1");
		orderCustMap.put("O002", "C1");
		orderCustMap.put("O003", "C2");
		orderCustMap.put("O004", "C2");
		orderCustMap.put("O005", "C3");
	}

	public void setOrderDescMap(Map<String, String> orderDescMap) {
		orderDescMap.put("O001", "衣服");
		orderDescMap.put("O002", "3C");
		orderDescMap.put("O003", "遊戲");
		orderDescMap.put("O004", "保養品");
		orderDescMap.put("O005", "攝影機");
	}

	public void setOrderAmtMap(Map<String, Integer> orderAmtMap) {
		orderAmtMap.put("O001", 789);
		orderAmtMap.put("O002", 1999);
		orderAmtMap.put("O003", 1899);
		orderAmtMap.put("O004", 3300);
		orderAmtMap.put("O005", 14999);
	}
	
	public String getOrderNo(int index) {
		return String.format("O00%s", Integer.toString(index));
	}
	
	public String getOrderCustMap(int index) {
		return orderCustMap.get( getOrderNo(index)  );
	}
	
	public String getCustNameMap(String custNo) {
		return custNameMap.get(custNo);
	}
	
	public String getOrderDescMap(int index) {
		return orderDescMap.get( getOrderNo(index)  );
	}
	
	public int getOrderAmtMap(int index) {
		return orderAmtMap.get( getOrderNo(index)  );
	}
	
//	public void getCustOrderlist(String custNo) {
//		for(int index = 1; index <= orderCustMap.size(); index ++) {
//			if ( getOrderCustMap(index).equals(custNo) ) {
//				System.out.println(custNo + "\t" + getCustNameMap(custNo) + "\t" + getOrderNo(index) + "\t" + 
//						getOrderDescMap(index) + "\t" + getOrderAmtMap(index));
//			}
//		}
//	}
	
	public void getCustOrderlist() {
		String custNo = null;
		for(int index = 1; index <= orderCustMap.size(); index ++) {
			custNo = getOrderCustMap(index);
			System.out.println(custNo + "\t" + getCustNameMap(custNo) + "\t" + getOrderNo(index) + "\t" +
					getOrderDescMap(index) + "\t" + getOrderAmtMap(index));
		}
	}
	public void getCustSumAvgCost() {
		//加總 & 紀錄筆數
		for ( int index = 1; index <= orderAmtMap.size(); index ++) {
			if ( !( custSumCostMap.get(getOrderCustMap(index)) == null) ) {
				custSumCostMap.put(getOrderCustMap(index), ( getOrderAmtMap(index) + custSumCostMap.get(getOrderCustMap(index))) );
				custOrderCountMap.put(getOrderCustMap(index), custOrderCountMap.get(getOrderCustMap(index)) + 1);
				continue;
			}
			custSumCostMap.put(getOrderCustMap(index), getOrderAmtMap(index));
			custOrderCountMap.put(getOrderCustMap(index), 1);
		}
	}
	public void getCustAvgCost() {
		getCustSumAvgCost();
		for (String key : custSumCostMap.keySet()) {	
			System.out.println("編號:" + key + " , 姓名: " + getCustNameMap(key) + ", 平均消費金額: " + 
					( custSumCostMap.get(key) / custOrderCountMap.get(key))  );
		}
	}
	public void printCustSumCost(Map<String, Integer> asMap){
		for (String key : asMap.keySet()) {	
			System.out.println("編號:" + key + " , 姓名: " + getCustNameMap(key) + ", 總消費金額: " + asMap.get(key)  );
		}
	}
	
	public void setSortDesc() {
		LinkedHashMap<String, Integer> custSortCostMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> custSumCostCloneMap = new TreeMap<String, Integer >(custSumCostMap);
		String temp;
		for (String key1 : custSumCostCloneMap.keySet()) {
			temp = null;
			for (String key2 : custSumCostCloneMap.keySet()) {
				if( custSumCostCloneMap.get(key1) <= custSumCostCloneMap.get(key2) && custSumCostCloneMap.get(key2) != 0) {
					temp = key2;
				}
			}
			if (!temp.equals(null)){
				custSortCostMap.put(temp, custSumCostCloneMap.get(temp));
				custSumCostCloneMap.put(temp, 0);// 排序過的補0
			}
		}
		printCustSumCost(custSortCostMap);
	}
}

class Q6_5{
	
	ArrayList<String> custNoList = new ArrayList<String>();//會員名單ID
	ArrayList<String> custNameList = new ArrayList<String>();//會員名單姓名
	LinkedList<Integer> custSumCostList = new LinkedList<Integer>();//會員花費金額
	LinkedList<Integer> custOrderCountList = new LinkedList<Integer>();//會員訂單數
	
	ArrayList<String> orderNoList = new ArrayList<String>();//訂單編號
	ArrayList<String> orderCustNoList = new ArrayList<String>();//訂購者
	ArrayList<String> orderDescList = new ArrayList<String>();//訂單內容
	ArrayList<Integer> orderAmtList = new ArrayList<Integer>();//訂單金額

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
		setSortDesc();
		System.out.println();
		
		System.out.println("4.依照消費總金額低到高排序");
		printCustSumCost(custSumCostList);
		System.out.println();
	}
	
	public void initList() {
		setCustNameIdList(custNoList);
		setCustNameList(custNameList);
		setOrderNoList(orderNoList);
		setOrderCustNoList(orderCustNoList);
		setOrderDescList(orderDescList);
		setOrderAmtList(orderAmtList);
	}
	
	public void setCustNameIdList(ArrayList<String> custNameIdList) {
		custNameIdList.add("C1");
		custNameIdList.add("C2");
		custNameIdList.add("C3");
	}
	
	public void setCustNameList(ArrayList<String> custNameList) {
		custNameList.add("小Q");
		custNameList.add("小咪");
		custNameList.add("查理");
	}
	
	public void setOrderNoList(ArrayList<String> orderNoList) {
		orderNoList.add("O001");
		orderNoList.add("O002");
		orderNoList.add("O003");
		orderNoList.add("O004");
		orderNoList.add("O005");
	}
	
	public void setOrderCustNoList(ArrayList<String> orderCustNoList) {
		orderCustNoList.add("C1");
		orderCustNoList.add("C1");
		orderCustNoList.add("C2");
		orderCustNoList.add("C2");
		orderCustNoList.add("C3");
	}
	
	public void setOrderDescList(ArrayList<String> orderDescList) {
		orderDescList.add("衣服");
		orderDescList.add("3C");
		orderDescList.add("遊戲");
		orderDescList.add("保養品");
		orderDescList.add("攝影機");
	}
	
	public void setOrderAmtList(ArrayList<Integer> orderAmtList) {
		orderAmtList.add(789);
		orderAmtList.add(1999);
		orderAmtList.add(1899);
		orderAmtList.add(3300);
		orderAmtList.add(14999);
	}
	
	
	public int getCustNoIndex(String CustValue){
		for ( int custIndex = 0; custIndex < custNoList.size(); custIndex ++){
			if (custNoList.get(custIndex).equals(CustValue) ){
				return custIndex;
			}
		}
		return -1;
	}
	
	public String getCustNameList(int index){
		return custNameList.get(index);
	}
	
	public String getOrderCustNoList(int index){
		return orderCustNoList.get(index);
	}
	
	public String getOrderNoList(int index){
		return orderNoList.get(index);
	}
	
	public String getOrderDescList(int index){
		return orderDescList.get(index);
	}
	
	public int getOrderAmtList(int index){
		return orderAmtList.get(index);
	}
	
	public void getCustOrderDet() {
		for(int index = 0; index < orderCustNoList.size(); index ++) {
			System.out.println(getOrderCustNoList(index) + "\t" + getCustNameList(getCustNoIndex(orderCustNoList.get(index))) + "\t" + getOrderNoList(index) + "\t" +
					getOrderDescList(index) + "\t" + getOrderAmtList(index));
		}
	}
	
	public void setCustSumCostList(int index, int setAmt){
		if (index == custSumCostList.size() -1) {
			custSumCostList.remove(index);
		}
		custSumCostList.add(index, setAmt);		
	}
	
	public void setCustOrderCountList(int index, int orgCount){
		if (index == custOrderCountList.size() -1) {
			custOrderCountList.remove(index);
		}
		custOrderCountList.add(index, orgCount);	
	}
	
	public int getCustSumCostList(int cusIndex){
		return custSumCostList.get(cusIndex);
	}
	
	public int getCustOrderCountList(int cusIndex){
		return custOrderCountList.get(cusIndex);
	}
	
	public void getCustSumAvgCost() {
		//加總 & 紀錄筆數
		int cusIndex, setAmt, setCount;
		for ( int index = 0; index < orderAmtList.size(); index ++) {
			cusIndex = getCustNoIndex(getOrderCustNoList(index));
			if ( cusIndex == custSumCostList.size() -1 ) {
				setAmt = getOrderAmtList ( index ) + getCustSumCostList(cusIndex);
				setCount = getCustOrderCountList(cusIndex) +1;
	
				setCustSumCostList(cusIndex, setAmt);
				setCustOrderCountList(cusIndex, setCount);
				continue;
			}
			setCustSumCostList(cusIndex, getOrderAmtList ( index ));
			setCustOrderCountList(cusIndex, 1);
		}
	}
	
	public void getCustAvgCost() {
		getCustSumAvgCost();
		for ( int cusIndex = 0; cusIndex < custSumCostList.size(); cusIndex ++) {
			System.out.println("編號:" + custNoList.get(cusIndex) + " , 姓名: " + getCustNameList(cusIndex) + ", 平均消費金額: " +
					getCustSumCostList(cusIndex) / getCustOrderCountList(cusIndex) );
		}
	}
	
	public void printCustSumCost( LinkedList<Integer> asList){
		for (int cusIndex = 0; cusIndex < asList.size(); cusIndex ++){
			System.out.println("編號:" + custNoList.get(cusIndex) + " , 姓名: " + getCustNameList(cusIndex) + ", 總消費金額: " + asList.get(cusIndex)  );
		}
	}
	
	public void setSortDesc() {

		LinkedList<Integer> custSortCostList = new LinkedList<Integer>();
		LinkedList<Integer> custSumCostCloneList = new LinkedList<Integer>(custSumCostList);

		int temp;
		for (int cusIndex = 0; cusIndex < custSumCostCloneList.size(); cusIndex ++){
			temp = 99;
			for (int cusIndex2 = 0; cusIndex2 < custSumCostCloneList.size(); cusIndex2 ++){
				
				if ( custSumCostCloneList.get(cusIndex) <= custSumCostCloneList.get(cusIndex2) && custSumCostCloneList.get(cusIndex2) != 0) {
					temp = cusIndex2;
				}
			}
			if(temp != 99){
				custSortCostList.add( custSumCostCloneList.get(temp) );
				custSumCostCloneList.remove(temp);
				custSumCostCloneList.add(temp, 0);
				
			}
		}
		printCustSumCost(custSortCostList);
	}
	
	
}