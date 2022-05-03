package Class7_h;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Homework7 {
	public static void main(String[] args) {
		Q7_1 Q7_Ex = new Q7_Ex();
		Q7_Ex.run();
	}
}


interface Q7Action {
	public void initMenuData();
	public void searchOrder();
	public void createMenu();
}

class Q7_Ex extends Q7_1 {
	
	public void initMenuData() {
		//更改Menu項目
		menuDate.put( 1, new Menu("紅茶", "500", "700", "129.8", "186.1", "錫蘭紅茶，產地康提 (Kandy)", 30, 35));
		menuDate.put( 2, new Menu("薰衣草奶茶", "500", "700", "320", "407", "產地法國",  45, 55));
		menuDate.put( 3, new Menu("綠茶", "500", "700", "115", "211", "產地台灣 三峽", 30, 35));
		menuDate.put( 4, new Menu("青茶", "500", "700", "0", "0", "產地日本", 25, 30));
		menuDate.put( 5, new Menu("高山茶", "500", "700", "10", "14", "產地台灣原始森林台地", 30, 35));
		menuDate.put( 6, new Menu("水果茶", "500", "700", "290", "382", "產地台灣", 55, 70));
	}
	
	@Override
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

	@Override
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
	Map<Integer, orderData> orderMap = new LinkedHashMap<Integer, orderData>() ;
	Map<Integer, sweetRange> sweetMap = new LinkedHashMap<Integer, sweetRange>() ;
	Map<Integer, IceRange> IceMap = new LinkedHashMap<Integer, IceRange>() ;
	Map<Integer, capType> capMap = new LinkedHashMap<Integer, capType>() ;
	int orderRow = 0;
	
	Scanner scanner = new Scanner(System.in);
	
	public void run() {
		initMenuData();
		initSweetMap();
		initIceMap();
		initCapMap();
		createMenu();
	}
	
	public void initMenuData() {
		menuDate.put( 1, new Menu("白玉歐蕾", "500", "700", "395", "443", new menuDesc().getDrinkDesc1(), 50, 60));
		menuDate.put( 2, new Menu("胭脂多多", "500", "700", "320", "407", new menuDesc().getDrinkDesc2(), 45, 55));
		menuDate.put( 3, new Menu("雪藏紅茶", "500", "700", "287", "377", new menuDesc().getDrinkDesc3(), 50, 60));
		menuDate.put( 4, new Menu("春梅冰茶", "500", "700", "257", "356", new menuDesc().getDrinkDesc4(), 40, 50));
		menuDate.put( 5, new Menu("冷露歐蕾", "500", "700", "221", "307", new menuDesc().getDrinkDesc5(), 45, 55));
		menuDate.put( 6, new Menu("熟成歐蕾", "500", "700", "258", "311", new menuDesc().getDrinkDesc6(), 45, 55));
		menuDate.put( 7, new Menu("雪花冷露", "500", "700", "176", "247", new menuDesc().getDrinkDesc7(), 30, 35));
		menuDate.put( 8, new Menu("熟成冷露", "500", "700", "155", "211", new menuDesc().getDrinkDesc8(), 30, 35));
		menuDate.put( 9, new Menu("春芽冷露", "500", "700", "135", "211", new menuDesc().getDrinkDesc9(), 30, 35));
		menuDate.put(10, new Menu("熟成紅茶", "500", "700", "180", "200", new menuDesc().getDrinkDesc10(), 30, 35));
		menuDate.put(11, new Menu("麗春紅茶", "500", "700", "180", "200", new menuDesc().getDrinkDesc11(), 30, 35));
		menuDate.put(12, new Menu("胭脂紅茶", "500", "700", "180", "200", new menuDesc().getDrinkDesc12(), 40, 45));
		menuDate.put(13, new Menu("太妃紅茶", "500", "700", "161", "182", new menuDesc().getDrinkDesc13(), 35, 40));
		menuDate.put(14, new Menu("春芽綠茶", "500", "700", "160", "180", new menuDesc().getDrinkDesc14(), 30, 35));
		menuDate.put(15, new Menu("熟成檸果", "500", "700", "168", "300", new menuDesc().getDrinkDesc15(), 55, 65));
	}
	
	public void initSweetMap() {
		sweetMap.put(1, new sweetRange("無糖"));
		sweetMap.put(2, new sweetRange("一分糖"));
		sweetMap.put(3, new sweetRange("二分糖"));
		sweetMap.put(4, new sweetRange("微糖"));
		sweetMap.put(5, new sweetRange("半糖"));
		sweetMap.put(6, new sweetRange("少糖"));
		sweetMap.put(7, new sweetRange("正常糖"));
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
		capMap.put(1, new capType("大", 700));
		capMap.put(2, new capType("中", 500));
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
		orderMap.put( orderRow, new orderData( 
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
		if (num == 0) {
			return ;
		}

		System.out.print("請輸入餐點容量\t(");
		for (int key : capMap.keySet()) {
			System.out.print(key + "." + capMap.get(key).getCapNm() + "\t");
		}
		System.out.print(" 0:退出 ) :" );
		cap = scanner.nextInt();
		if (cap == 0) {
			return ;
		}
		
		System.out.print("請輸入甜度\t(" );
		for (int key : sweetMap.keySet()) {
			System.out.print(key + "." + sweetMap.get(key).getSweetDesc() + "\t");
		}
		System.out.print(" 0:退出 ) :" );
		swe = scanner.nextInt();
		if (swe == 0) {
			return ;
		}

		System.out.print("請輸入冰度\t(" );
		for (int key : IceMap.keySet()) {
			System.out.print(key + "." + IceMap.get(key).getIceDesc() + "\t");
		}
		System.out.print(" 0:退出 ) :" );
		ice = scanner.nextInt();
		if (ice == 0) {
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

class orderData {
	String orderId, orderCustNm ;
	int orderMenuId, orderCap, orderSwe, orderIce, orderAmt;
	
	public orderData(String orderId, String orderCustNm, int orderMenuId, int orderCap, int orderSwe, int orderIce,
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

class sweetRange {
	String sweetDesc;

	public sweetRange(String sweetDesc) {
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

class capType {
	String capNm;
	int cap;
	
	public capType(String capNm, int cap) {
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

class menuDesc {
	private String drinkDesc1  = "台灣手搖飲不可或缺的經典——珍珠鮮奶茶。軟嫩嚼感的白玉珍珠，恰似摩登女子的珍珠首飾，以奢華感獨領風潮。與熟成歐蕾完美結合，口感厚實而層次豐富，是一場難以忘懷的味覺饗宴。";
	private String drinkDesc2  = "以粉色水蜜桃呼應擁有美妙歌聲的「胖丁」角色，蜜桃韻味為基底的胭脂紅茶，加入酸甜滋味恰如其分的養樂多，勾起甜而不膩的兒時回憶，伴隨著玫瑰與茉莉花香的恬淡，如同陶醉沈浸於純淨的音符之中，如初而美好。";
	private String drinkDesc3  = "白雪融於紅茶中而蔓延，厚實的茶韻與冰淇淋的奶甜相互交織，逐漸化開成香濃醇和的奶茶。綿綿情意浸潤於唇齒之間，響起一首苦情男女的老歌，花落紅塵的情感交雜，勾人心魂的萬千情愫。";
	private String drinkDesc4  = "春梅與冬瓜的相遇，好比舅舅的古著襯衫與耀金項鍊，花漾點綴的70年代感。純熟煉製的冬瓜，配上鮮酸柔滑的梅子，將酸甜爽口的滋味層層堆疊，懷舊風情令人醉心。";
	private String drinkDesc5  = "冬瓜與濃醇鮮奶一絲一著、輕巧地流露於唇齒間，雅緻的氣味宛如裁縫女子手中的針線，絲絲入扣地編織交纏，飲啜之間伴隨期盼歸來的情感，一股熟悉的奶香與甜香。";
	private String drinkDesc6  = "渲染漸變的茶色，猶如街頭嬉皮風趣的男子，口中恣意地哼著音階。濃郁的紅茶香，本是味覺記憶中的絕品，與溫順甘醇的鮮奶兩相平衡，為奶茶的底蘊更添一股味蕾衝擊，絲滑細膩使人覺醒。";
	private String drinkDesc7  = "出於精煉的冬瓜，經歲月的火侯，成就獨有的韻味及香氣，彷彿古厝裡安然自得、望著懷舊時鐘的老奶奶，一會兒迎著藺草扇起的微風、配著收音機，享受溫煦的午後人生。";
	private String drinkDesc8  = "冬瓜與紅茶的極致特調，慢火入味的冬瓜香氣將清沁滑順的紅茶帶入另一種層次。回憶起於雨煙橋下抽著煙斗、曾經年少的阿公，在舊識中迂迴的嫵媚，作為生活與樸實的調和劑。";
	private String drinkDesc9  = "春芽冷露是一股耐人尋味的質感，如同愛好茶酒和詩詞的阿伯。冬瓜陳年的尾韻，於茶葉清甜圓潤的餘韻下回甘，兩者所釋放的渾厚香氣，尋尋覓覓使人意猶未盡，適合與文學一同啜飲。";
	private String drinkDesc10 = "木質帶熟果香調的風味，流露熟齡男子的沈穩氣息，低調而迷人。嚴選自斯里蘭卡產區之茶葉，帶有濃郁果香及醇厚桂圓香氣；與肉類料理一同品嚐，得以化解舌尖上所殘留的油膩感。";
	private String drinkDesc11 = "淡雅輕盈的花香調，可比嬌豔欲滴的罌粟紅花，散發名門閨秀的氣質，優雅而令人傾心。取自罕見的斯里蘭卡中高海拔產區茶葉，帶清爽孤傲的花香；搭配海鮮料理享用，為中和腥羶味的首選。";
	private String drinkDesc12 = "恬淡的果香調與一抹蜜桃風味，伴隨玫瑰與茉莉花香的情蜜纏綿，好似唇抹胭脂的綺麗女子。清新的紅茶如髮簪鑲嵌的金絲紋理，將60年代華洋集於一身的氛圍，化為迷人的戀舊意識。";
	private String drinkDesc13 = "咖啡與紅茶的絕妙搭配—— 鮮明風味於口中融合暈染，描繪出復古情懷的文青少女，在Cafe裡敲著打字機、傳來紙張與墨水帶的振振聲響。咖啡豆的淬煉注入紅茶的芬芳，淡柔飄散的麥香，所謂「復刻經典」。";
	private String drinkDesc14 = "縱身綠叢、提筆描繪的青山少年，在春滿四溢的山林中擁抱自然、探索枝芽於舌尖的渴望。萃取自台灣綠茶，蘊含繁茂枝葉所飽存的風土，初嚐甘甜圓潤與低苦澀，青翠欲滴即不絕於口。";
	private String drinkDesc15 = "如同愛情小品中的少女，帶著初戀的羞澀與心上人赴約，配上酸甜濃郁的檸檬蛋糕，在靦腆的午後時光綻放少女情懷。整顆新鮮檸檬浸漬於茶中，輕盈爽口而純淨，不多不少7分糖，甜意、情意剛剛好。";
	
	public String getDrinkDesc1() {
		return drinkDesc1;
	}
	public String getDrinkDesc2() {
		return drinkDesc2;
	}
	public String getDrinkDesc3() {
		return drinkDesc3;
	}
	public String getDrinkDesc4() {
		return drinkDesc4;
	}
	public String getDrinkDesc5() {
		return drinkDesc5;
	}
	public String getDrinkDesc6() {
		return drinkDesc6;
	}
	public String getDrinkDesc7() {
		return drinkDesc7;
	}
	public String getDrinkDesc8() {
		return drinkDesc8;
	}
	public String getDrinkDesc9() {
		return drinkDesc9;
	}
	public String getDrinkDesc10() {
		return drinkDesc10;
	}
	public String getDrinkDesc11() {
		return drinkDesc11;
	}
	public String getDrinkDesc12() {
		return drinkDesc12;
	}
	public String getDrinkDesc13() {
		return drinkDesc13;
	}
	public String getDrinkDesc14() {
		return drinkDesc14;
	}
	public String getDrinkDesc15() {
		return drinkDesc15;
	}
	
	
}
