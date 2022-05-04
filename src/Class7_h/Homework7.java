package Class7_h;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Homework7 {
	public static void main(String[] args) {
		Q7_1 Q7_Ex = new Q7_Ex();
		Q7_Ex.Run();
		
	}
}


interface Q7Action {
	public void initMenuData();
	public void searchOrder();
	public void createMenu();
}

class Q7_Ex extends Q7_1  {

	public void initMenuData() {
		super.initMenuData();
		//更改Menu項目
		menuDate.put( 7, new Menu("仙草凍紅茶", "500", "700", "150", "258", "手工仙草，錫蘭紅茶，產地康提 (Kandy)", 55, 65));
		menuDate.put( 8, new Menu("仙草凍乃茶", "500", "700", "353", "475", "手工仙草，奶茶產地法國", 60, 70));
	}
	
	public void searchOrder() {
		//更改熱量計算方式
		String custNm;
		System.out.print("請輸入顧客姓名:");
		custNm = scanner.next();
		System.out.println("訂單號\t" + "顧客姓名\t" + "品名\t" + "容量\t" + "甜度\t" + "冰度\t" + "熱量\t" + "商品價格\t" );
		for (int key : orderMap.keySet()) {
			if (orderMap.get(key).getOrderCustNm().equals(custNm)) {
				System.out.println( orderMap.get(key).getOrderId() + "\t" + 
									orderMap.get(key).getOrderCustNm() + "\t" + 
									menuDate.get(orderMap.get(key).getOrderMenuId()).getName()   + "\t" + 
									capMap.get(orderMap.get(key).getOrderCap()).getCapNm()  + "\t" + 
									sweetMap.get(orderMap.get(key).getOrderSwe()).getSweetDesc() + "\t" + 
									IceMap.get(orderMap.get(key).getOrderIce()).getIceDesc()  + "\t" + 
									( Double.parseDouble( capMap.get(orderMap.get(key).getOrderCap()).getCapNm().equals("大") ? 
											menuDate.get(orderMap.get(key).getOrderMenuId()).getBigHeat():
												menuDate.get(orderMap.get(key).getOrderMenuId()).getMediuHeat()	) * orderMap.get(key).getOrderSwe() / 10 ) + "\t" + 
									orderMap.get(key).getOrderAmt());

			}
		}
		System.out.println();
	}

	public void createMenu() {
		String LoopYn = "Y", chooseType = null;
		
		while ( !LoopYn.equalsIgnoreCase("N") ) {
			System.out.print("請選擇執行功能 (1. 成立訂單  2.查詢訂單):" );
			chooseType = scanner.next();
			
			switch (chooseType) {
				case "1":
					showMenu();
					orderMenu();
					break;
				case "2":
					searchOrderLoop();
					break;
			}
			System.out.print("是否繼續執行 (Y: 是  N :否):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
			System.out.println();
		}
		System.out.print("結束!" );
	}
	
	//更改重新查詢機制
	public void searchOrderLoop() {
		String LoopYn = "Y";
		while ( !LoopYn.equalsIgnoreCase("N") ) {
			searchOrder();
			System.out.print("是否繼續查詢 (Y: 是  N :否):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
			System.out.println();
		}
	}


}


abstract class Q7_1 implements Q7Action{
	
	//Menu初始化
	Map<Integer, Menu> menuDate = new LinkedHashMap<Integer, Menu>() ;
	Map<Integer, OrderData> orderMap = new LinkedHashMap<Integer, OrderData>() ;
	Map<Integer, SweetRange> sweetMap = new LinkedHashMap<Integer, SweetRange>() ;
	Map<Integer, IceRange> IceMap = new LinkedHashMap<Integer, IceRange>() ;
	Map<Integer, CapType> capMap = new LinkedHashMap<Integer, CapType>() ;
	int orderRow = 0;
	
	Scanner scanner = new Scanner(System.in);
	
	public void Run() {
		initMenuData();
		initSweetMap();
		initIceMap();
		initCapMap();
		createMenu();
	}
	
	public void initMenuData() {
		menuDate.put( 1, new Menu("紅茶", "500", "700", "129.8", "186.1", "錫蘭紅茶，產地康提 (Kandy)", 30, 35));
		menuDate.put( 2, new Menu("薰衣草奶茶", "500", "700", "320", "407", "產地法國",  45, 55));
		menuDate.put( 3, new Menu("綠茶", "500", "700", "115", "211", "產地台灣 三峽", 30, 35));
		menuDate.put( 4, new Menu("青茶", "500", "700", "0", "0", "產地日本", 25, 30));
		menuDate.put( 5, new Menu("高山茶", "500", "700", "10", "14", "產地台灣原始森林台地", 30, 35));
		menuDate.put( 6, new Menu("水果茶", "500", "700", "290", "382", "產地台灣", 55, 70));
	}
	
	public void initSweetMap() {
		sweetMap.put(1, new SweetRange("無糖"));
		sweetMap.put(2, new SweetRange("一分糖"));
		sweetMap.put(3, new SweetRange("二分糖"));
		sweetMap.put(4, new SweetRange("微糖"));
		sweetMap.put(5, new SweetRange("半糖"));
		sweetMap.put(6, new SweetRange("少糖"));
		sweetMap.put(7, new SweetRange("正常糖"));
	}
	
	public void initIceMap() {
		IceMap.put(1, new IceRange("熱"));
		IceMap.put(2, new IceRange("溫"));
		IceMap.put(3, new IceRange("常溫"));
		IceMap.put(4, new IceRange("完全去冰"));
		IceMap.put(5, new IceRange("去冰"));
		IceMap.put(6, new IceRange("微冰"));
		IceMap.put(7, new IceRange("少冰"));
		IceMap.put(8, new IceRange("正常冰"));
	}
	
	public void initCapMap() {
		capMap.put(1, new CapType("大", 700));
		capMap.put(2, new CapType("中", 500));
	}
	
	public void showMenu() {
		System.out.print("\t名稱 " + "\t" + "價格  \t" + "中" + "/" + "大");
		System.out.print("\t\t");
		System.out.print("\t名稱 " + "\t" + "價格  \t" + "中" + "/" + "大");
		System.out.print("\t\t");
		System.out.print("\t名稱 " + "\t" + "價格  \t" + "中" + "/" + "大");
		System.out.println();
		
		for ( int key : menuDate.keySet()){
			System.out.print(key + "\t" + menuDate.get(key).getName() + "\t" + 
					"price: " + menuDate.get(key).getMediuPrice() + "/" + menuDate.get(key).getBigPrice());
			
			if (key % 3 == 0)  {
				System.out.println();
			}else {
				System.out.print("\t\t");
			}
		}
		System.out.println();
	}
	
	public void createOrder(String orderId, String custNm, int num, int cap, int swe, int ice) {
		orderMap.put( orderRow, new OrderData( 
				String.format("0000%s", String.valueOf(orderRow) ),
				custNm, num, cap, swe, ice, 
				( capMap.get(cap).getCapNm().equals("大") ? menuDate.get(num).getBigPrice() : menuDate.get(num).getMediuPrice()) ) );
	}
	
	public void createMenu() {
		String LoopYn = "Y", chooseType = null;
		
		while ( !LoopYn.equalsIgnoreCase("N") ) {
			System.out.print("請選擇執行功能 (1. 成立訂單  2.查詢訂單):" );
			chooseType = scanner.next();
			
			switch (chooseType) {
				case "1":
					showMenu();
					orderMenu();
					break;
				case "2":
					searchOrder();
					break;
			}
			System.out.print("是否繼續執行 (Y: 是  N :否):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
			System.out.println();
		}
		System.out.print("結束!" );
	}
	
	public void orderMenu() {
		int num, ice, swe, cap;
		String custNm;

		System.out.print("請輸入顧客姓名( 0:退出 ):");
		custNm = scanner.next();
		if (custNm.equals("0")) {
			return ;
		}
		
		System.out.print("請輸入餐點序號( 0:退出 ):");
		num = scanner.nextInt();
		if ( !checkArgument(num, menuDate) ) {
			return ;
		}

		System.out.print("請輸入餐點杯量\t(");
		for (int key : capMap.keySet()) {
			System.out.print(key + "." + capMap.get(key).getCapNm() + "\t");
		}
		System.out.print(" 0:退出 ) :" );
		cap = scanner.nextInt();
		if ( !checkArgument(cap, capMap) ) {
			return ;
		}
		
		System.out.print("請輸入甜度\t(" );
		for (int key : sweetMap.keySet()) {
			System.out.print(key + "." + sweetMap.get(key).getSweetDesc() + "\t");
		}
		System.out.print(" 0:退出 ) :" );
		swe = scanner.nextInt();
		if ( !checkArgument(swe, sweetMap) ) {
			return ;
		}

		System.out.print("請輸入冰度\t(" );
		for (int key : IceMap.keySet()) {
			System.out.print(key + "." + IceMap.get(key).getIceDesc() + "\t");
		}
		System.out.print(" 0:退出 ) :" );
		ice = scanner.nextInt();
		if ( !checkArgument(ice, IceMap) ) {
			return ;
		}

		orderRow ++;
		createOrder(String.format("0000%s", String.valueOf(orderRow)), custNm, num, cap, swe, ice);
		
	    System.out.printf("您點選的餐點為: %s, %s, %s, %s, $%d !", 
	    			menuDate.get(num).getName(),  
	    			capMap.get(cap).getCapNm(), 
	    			sweetMap.get(swe).getSweetDesc() , 
	    			IceMap.get(ice).getIceDesc() ,  
	    			( capMap.get(cap).getCapNm().equals("大") ? menuDate.get(num).getBigPrice() : menuDate.get(num).getMediuPrice()) ) ;
		System.out.println();
		System.out.println();
		

		
	}
	
	public boolean checkArgument(int argu, Map<Integer, ?> asMap) {
		if (argu == 0) {
			System.out.println("回上一層");
			return false;
		}else if (argu > asMap.size()) {
			System.out.println("找不到品項，請重新執行");
			return false;
		}
		return true;
	}
	
	public void searchOrder() {
		String custNm;
		System.out.print("請輸入顧客姓名:");
		custNm = scanner.next();
		System.out.println("訂單號\t" + "顧客姓名\t" + "品名\t" + "容量\t" + "甜度\t" + "冰度\t" + "熱量\t" + "商品價格\t" );
		for (int key : orderMap.keySet()) {
			if (orderMap.get(key).getOrderCustNm().equals(custNm)) {
				System.out.println( orderMap.get(key).getOrderId() + "\t" + 
									orderMap.get(key).getOrderCustNm() + "\t" + 
									menuDate.get(orderMap.get(key).getOrderMenuId()).getName()   + "\t" + 
									capMap.get(orderMap.get(key).getOrderCap()).getCapNm()  + "\t" + 
									sweetMap.get(orderMap.get(key).getOrderSwe()).getSweetDesc() + "\t" + 
									IceMap.get(orderMap.get(key).getOrderIce()).getIceDesc()  + "\t" + 
									( capMap.get(orderMap.get(key).getOrderCap()).getCapNm().equals("大") ? 
											menuDate.get(orderMap.get(key).getOrderMenuId()).getBigHeat():
												menuDate.get(orderMap.get(key).getOrderMenuId()).getMediuHeat()	) + "\t" + 
									orderMap.get(key).getOrderAmt());

			}
		}
		System.out.println();
	}
}

class Menu {
	String name, mediuCap, bigCap, mediuHeat, bigHeat, desc;
	int mediuPrice, bigPrice;
	
	public Menu(String name, String mediuCap, String bigCap, String mediuHeat, String bigHeat, String desc,
			int mediuPrice, int bigPrice) {
		super();
		this.name = name;
		this.mediuCap = mediuCap;
		this.bigCap = bigCap;
		this.mediuHeat = mediuHeat;
		this.bigHeat = bigHeat;
		this.desc = desc;
		this.mediuPrice = mediuPrice;
		this.bigPrice = bigPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMediuCap() {
		return mediuCap;
	}
	public void setMediuCap(String mediuCap) {
		this.mediuCap = mediuCap;
	}
	public String getBigCap() {
		return bigCap;
	}
	public void setBigCap(String bigCap) {
		this.bigCap = bigCap;
	}
	public String getMediuHeat() {
		return mediuHeat;
	}
	public void setMediuHeat(String mediuHeat) {
		this.mediuHeat = mediuHeat;
	}
	public String getBigHeat() {
		return bigHeat;
	}
	public void setBigHeat(String bigHeat) {
		this.bigHeat = bigHeat;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getMediuPrice() {
		return mediuPrice;
	}
	public void setMediuPrice(int mediuPrice) {
		this.mediuPrice = mediuPrice;
	}
	public int getBigPrice() {
		return bigPrice;
	}
	public void setBigPrice(int bigPrice) {
		this.bigPrice = bigPrice;
	}
	
	
}

class OrderData {
	String orderId, orderCustNm ;
	int orderMenuId, orderCap, orderSwe, orderIce, orderAmt;
	
	public OrderData(String orderId, String orderCustNm, int orderMenuId, int orderCap, int orderSwe, int orderIce,
			int orderAmt) {
		super();
		this.orderId = orderId;
		this.orderCustNm = orderCustNm;
		this.orderMenuId = orderMenuId;
		this.orderCap = orderCap;
		this.orderSwe = orderSwe;
		this.orderIce = orderIce;
		this.orderAmt = orderAmt;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderCustNm() {
		return orderCustNm;
	}
	public void setOrderCustNm(String orderCustNm) {
		this.orderCustNm = orderCustNm;
	}
	public int getOrderMenuId() {
		return orderMenuId;
	}
	public void setOrderMenuId(int orderMenuId) {
		this.orderMenuId = orderMenuId;
	}
	public int getOrderCap() {
		return orderCap;
	}
	public void setOrderCap(int orderCap) {
		this.orderCap = orderCap;
	}
	public int getOrderSwe() {
		return orderSwe;
	}
	public void setOrderSwe(int orderSwe) {
		this.orderSwe = orderSwe;
	}
	public int getOrderIce() {
		return orderIce;
	}
	public void setOrderIce(int orderIce) {
		this.orderIce = orderIce;
	}
	public int getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(int orderAmt) {
		this.orderAmt = orderAmt;
	}
	
	
}

class SweetRange {
	String sweetDesc;

	public SweetRange(String sweetDesc) {
		super();
		this.sweetDesc = sweetDesc;
	}

	public String getSweetDesc() {
		return sweetDesc;
	}

	public void setSweetDesc(String sweetDesc) {
		this.sweetDesc = sweetDesc;
	}
}

class IceRange{
	String IceDesc;

	public IceRange(String iceDesc) {
		super();
		IceDesc = iceDesc;
	}

	public String getIceDesc() {
		return IceDesc;
	}

	public void setIceDesc(String iceDesc) {
		IceDesc = iceDesc;
	}
}

class CapType {
	String capNm;
	int cap;
	
	public CapType(String capNm, int cap) {
		super();
		this.capNm = capNm;
		this.cap = cap;
	}
	public String getCapNm() {
		return capNm;
	}
	public void setCapNm(String capNm) {
		this.capNm = capNm;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	
}
