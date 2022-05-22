package Class7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class Homework7 {
	public static void main(String[] args) throws Exception {
		new ChoiceType().appStart();
	}
}


class ChoiceType {

	Q7_1 Q7_1 = new Q7_1();
	Scanner scanner = new Scanner(System.in);
	
	public void appStart() {
		Q7_1.init();
		inMenu();
	}
	
	public void inMenu() {
		String LoopYn = "Y", chooseType = null;
		int cusRow = 0;
		
		while ( !LoopYn.equalsIgnoreCase("N") ) {
			System.out.print("[主選單]請選擇執行功能 (1. 成立訂單  2.查詢訂單  3.飲料維護  4.飲料統計  5.點餐修改  0.結束 ):" );
			chooseType = scanner.next();
			
			if (chooseType.equals("0")){
				break;
			}

			switch (chooseType) {
				case "1":
					cusRow = Q7_1.newCustMap(cusRow);
					if ( cusRow != 0 ) {
						Q7_1.orderMenu(cusRow);
					}
					break;
				case "2":
					Q7_1.searchOrderLoop();
					break;
				case "3":
					new Q7_m().modifyMenu();
					break;
				case "4":
					new Q7_s().comSaleData();
					break;
				case "5":
					new Q7_o().changeCustOrder();
					break;
				default:
					System.out.print("輸入錯誤, 請重新輸入。" );
					break;		
			}
			System.out.print("[主選單]是否繼續執行 (Y: 是  N :否):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				continue;
			}
			System.out.println();
		}
		System.out.print("結束!" );
	}
}

//修改訂單
class Q7_o extends Q7_1 {
	
	String modifiedOrderNo = "X";
	int modifiedSeqno = 0, modifiedKey = 0;
	int orderCount = 0; //紀錄客人有幾張不同訂單
	String editType;
	
	public int checkRowCount(String orderNo, int seqno) {
		int row = 0;
		for ( int key : orderMap.keySet()) {
			if ( orderMap.get(key).getOrderId().equals(orderNo) && orderMap.get(key).getSeqno() == seqno) {
				row ++ ;
				if (  row == 1 ) {
					modifiedOrderNo = orderMap.get(key).getOrderId();
					modifiedSeqno = orderMap.get(key).getSeqno();
					modifiedKey = key;
				}else if ( row > 1) {
					modifiedOrderNo = "X";
					modifiedSeqno = 0;
					modifiedKey = 0;
				}
			}
		}
		
		if ( row == 0 ) {
			System.out.println("查詢不到相關訂單資料, 請重新查詢");
			return 0;
		}
		return row;
	}
	
	public int checkRowCount(String oneChar) {
		int row = 0;
		
		switch(oneChar.charAt(0)) {
		case 'O':
			orderCount = 1;
			for ( int key : orderMap.keySet()) {
				
				if ( orderMap.get(key).getOrderId().equals(oneChar)) {
					row ++ ;
					if (  row == 1 ) {
						modifiedOrderNo = orderMap.get(key).getOrderId();
						modifiedSeqno = orderMap.get(key).getSeqno();
						modifiedKey = key;
					}else if ( row > 1) {
						modifiedOrderNo = orderMap.get(key).getOrderId();
						modifiedSeqno = 0;
						modifiedKey = 0;
					}
				}
			}
			
			if ( row == 0 ) {
				System.out.println("查詢不到相關訂單資料, 請重新查詢");
				return 0;
			}
			
			break;
		default:

			String preOrderNo = null;
			for ( int key : orderMap.keySet()) {

				if ( !orderMap.get(key).getOrderId().equals(preOrderNo)) {
					preOrderNo = orderMap.get(key).getOrderId();
					orderCount++;
				}
				
				if ( custMap.get( getCustMapKey(orderMap.get(key).getCustId())).getCustNm().equals(oneChar) ) {
					row ++ ;
					if (  row == 1 ) {
						modifiedOrderNo = orderMap.get(key).getOrderId();
						modifiedSeqno = orderMap.get(key).getSeqno();
						modifiedKey = key;
					}else if ( row > 1) {
						modifiedOrderNo = "X";
						modifiedSeqno = 0;
						modifiedKey = 0;
					}
				}
			}
			if ( row == 0 ) {
				System.out.println("查詢不到顧客訂單資料, 請重新查詢");
				return 0;
			}
			
			if (orderCount == 1) {
				modifiedOrderNo = preOrderNo;
			}
			break;			
		}
		return row;
	}
	
	public int searchOrderBySeqno(String orderNo, int seqno) {
		int row = 0;
		for (int key : orderMap.keySet()) {
			if ( orderMap.get(key).getOrderId().equals(orderNo) && 
					String.valueOf(orderMap.get(key).getSeqno()).equals(String.valueOf(seqno))) {
				row ++;
				printSearchOrderData(key, getCustMapKey(orderMap.get(key).getCustId()));
			}
		}
		System.out.println();
		return row;
	}
	
	public void changeCustOrder() {
		
		while(true) {
			orderCount = 0;
			System.out.print("請輸入操作類別 ( 1.修改 2.刪除 0.退出):");
			editType = scanner.next();
			if ( editType.equals("0")) {
				break;
			}else if ( Integer.parseInt(editType) > 2){
				System.out.println("輸入錯誤，請重新輸入" );
				continue;
			}
			
			System.out.print("請輸入顧客姓名 或 訂單號 (0.退出):");
			String searchStr = scanner.next();
			
			if ( searchStr.equals("0")) {
				break;
			}
			if ( checkRowCount(searchStr) == 0) {
				continue;
			}
			if ( modifiedOrderNo.equals("X") ) {
				if ( searchStr.charAt(0) != 'O') {
					//多訂單
					if ( orderCount > 1 ) {
						if ( !getModifiedOrderNo(searchStr) ) {
							continue;
						}
					}else {
						//單訂單						
						getModifiedOrderSeqno(modifiedOrderNo);
						if ( !modifiedItem() ) {
							continue;
						}
					}
					if ( !modifiedItem() ) {
						continue;
					}
				}else {
					//單訂單
					getModifiedOrderSeqno(modifiedOrderNo);
					if ( !modifiedItem() ) {
						continue;
					}
				}
			}else {
				if ( modifiedSeqno == 0) {
					getModifiedOrderSeqno(modifiedOrderNo);
				}
				if ( !modifiedItem() ) {
					continue;
				}
			}
			
			System.out.print("是否繼續修改? (Y: 是  N :否):" );

			if ( ( scanner.next()).equalsIgnoreCase("N")) {
				break;
			}
		}
	}
	
	public int modfiedParaType(String asType) {
		int rtnRow = 0, rtnStatus;
		if (asType == "capMap") {
			rtnRow = getOrderInfo(capMap, "請輸入修改杯量\t(");
			rtnStatus = checkArgument(rtnRow, capMap);
			if ( rtnStatus == -1 || rtnStatus == 0 ) {
				return rtnStatus;
			}else {
				return rtnRow;
			}
		}else if (asType == "sweetMap") {
			rtnRow = getOrderInfo(sweetMap, "請輸修改入甜度\t(");
			rtnStatus = checkArgument(rtnRow, sweetMap) ;
			if ( rtnStatus == -1 || rtnStatus == 0 ) {
				return rtnStatus;
			}else {
				return rtnRow;
			}
		}else if (asType == "IceMap") {
			rtnRow = getOrderInfo(IceMap, "請輸入修改冰度\t(");
			rtnStatus = checkArgument(rtnRow, IceMap) ;
			if ( rtnStatus == -1 || rtnStatus == 0  ) {
				return rtnStatus;
			}else {
				return rtnRow;
			}
		}
		return rtnRow;
	}
		
	public int modifiedS1Para(int mMenuId) {
		int capType, sweType, IceType;
		String asOrgPrinStr, asPrintStr;
		
		if (mMenuId == 0) {
			return mMenuId;
		}else {
			asOrgPrinStr  = menuData.get( orderMap.get(modifiedKey).getOrderMenuId()).getName() + ", " ;
			asOrgPrinStr += capMap.get(orderMap.get(modifiedKey).getOrderCap()).getCapNm()  + ", " ;
			asOrgPrinStr += sweetMap.get(orderMap.get(modifiedKey).getOrderSwe()).getSweetNm()  + ", " ;
			asOrgPrinStr += IceMap.get(orderMap.get(modifiedKey).getOrderIce()).getIceNm() ;
		}

		capType = modfiedParaType("capMap");
		if ( capType == -1 || capType == 0) {
			return capType;
		}
		sweType = modfiedParaType("sweetMap");
		if ( sweType == -1 || sweType == 0) {
			return sweType;
		}
		IceType = modfiedParaType("IceMap");
		if ( IceType == -1 || IceType == 0) {
			return IceType;
		}
		
		asPrintStr  = menuData.get(mMenuId).getName() + ", " ;
		asPrintStr += capMap.get(capType).getCapNm()  + ", " ;
		asPrintStr += sweetMap.get(sweType).getSweetNm()  + ", " ;
		asPrintStr += IceMap.get(IceType).getIceNm() ;

		if ( modifiedFinallyCmfn(1, asOrgPrinStr, asPrintStr) ) {
			orderMap.get(modifiedKey).setOrderMenuId(mMenuId);
			orderMap.get(modifiedKey).setOrderCap(capType);
			orderMap.get(modifiedKey).setOrderSwe(sweType);
			orderMap.get(modifiedKey).setOrderIce(IceType);
		}
		return 1;
	}
	
	public boolean modifiedFinallyCmfn(int mOption, String asOrgPrint, String asPrintStr) {
		
		switch(mOption) {
		case 1:
			System.out.print("是否確定修改訂單 (" + orderMap.get(modifiedKey).getOrderId() + "), 訂單序號 (" + orderMap.get(modifiedKey).getSeqno() + 
					") , ( 原項目:" + asOrgPrint + " ) 更改為 ( " + asPrintStr + " ) " +
					"? (Y: 是  N :否):" );
			
			break;
		case 2:
			System.out.print("是否確定修改訂單 (" + orderMap.get(modifiedKey).getOrderId() + "), 訂單序號 (" + orderMap.get(modifiedKey).getSeqno() + 
					") , 容量 ( 原:" + asOrgPrint + " ml ) 更改為 ( " + asPrintStr + " ml ) " +
					"? (Y: 是  N :否):" );
			break;
		case 3:
			System.out.print("是否確定修改訂單 (" + orderMap.get(modifiedKey).getOrderId() + "), 訂單序號 (" + orderMap.get(modifiedKey).getSeqno() + 
					") , 甜度 ( 原:" + asOrgPrint + " ) 更改為 ( " + asPrintStr + " ) " +
					"? (Y: 是  N :否):" );
			break;
		case 4:
			System.out.print("是否確定修改訂單 (" + orderMap.get(modifiedKey).getOrderId() + "), 訂單序號 (" + orderMap.get(modifiedKey).getSeqno() + 
					") , 冰度 ( 原:" + asOrgPrint + " ) 更改為 ( " + asPrintStr + " ) " +
					"? (Y: 是  N :否):" );
			break;

		case 5:
			System.out.print("是否確定修改訂單 (" + orderMap.get(modifiedKey).getOrderId() + "), 客戶資訊 [ 原:" + asOrgPrint + " ] 更改為 [ " + asPrintStr + " ] " +
					"? (Y: 是  N :否):" );
			break;	
		}
		
		if ( ( scanner.next()).equalsIgnoreCase("Y")) {
			return true;
		}
		
		return false;
	}
	
	public void deleteOrder() {
		
		for ( int key : orderMap.keySet()) {
			if ( orderMap.get(key).getOrderId().equals(modifiedOrderNo) && orderMap.get(key).getSeqno() == modifiedSeqno) {
				orderMap.remove(key);
			}
		}
	}
	
	public void setCustInfo(int asType, String mCustStr) {
		for ( int cusKey : custMap.keySet()) {
			if ( custMap.get(cusKey).getCustId().equals( orderMap.get(modifiedKey).getCustId()) ) {
				if (asType == 1){
					if ( modifiedFinallyCmfn(5, custMap.get(cusKey).getCustNm(), mCustStr + "姓名") ) {
						custMap.get(cusKey).setCustNm(mCustStr);
					}
				}else if (asType == 2) {
					if ( modifiedFinallyCmfn(5, "聯絡資訊, " + custMap.get(cusKey).getCustTel() + "(電話)", "聯絡資訊, " + mCustStr + "(電話)") ) {
						custMap.get(cusKey).setCustTel(mCustStr);
					}
				}
			}
		}
	}
	
	public boolean modifiedCustInfo() {
		System.out.print("請選擇修改客戶聯絡資訊別 ( 1.姓名 2.電話  0.退出) :" );
		String mCustsType = scanner.next();
		String mStr;
		switch ( mCustsType ) {
		case "1":
			System.out.print("請輸入修改客戶姓名 (0.退出) :" );
			mStr = scanner.next();
			if ( mStr.equals("0") ) {
				return false;
			}
			setCustInfo(1, mStr);
			break;
		case "2":
			System.out.print("請輸入修改客戶聯絡資訊 (0.退出) :" );
			mStr = scanner.next();
			if ( mStr.equals("0") ) {
				return false;
			}
			setCustInfo(2, mStr);
			break;
		case "0":
			return false;
		default:
			System.out.println("輸入錯誤，請重新輸入" );
			return true;
		}
		return true;
	}
	
	public boolean modifiedItem() {
		int rtnStatus, mPtion;
		while(true) {
			switch(editType){
			case "1":
				try {
					searchOrderBySeqno(modifiedOrderNo, modifiedSeqno);
					System.out.print("請輸入修改訂單項目( 1.餐點 2.容量 3.甜度 4.冰度 5.客戶聯絡資訊 0.退出) :" );
					switch(scanner.nextInt()) {
					case 1:
						showMenu();	
//						System.out.print("請輸入修改餐點序號 (0.退出):" );
//						mPtion = scanner.nextInt();
//						if (checkArgument(mPtion, menuData) == -1 || checkArgument(mPtion, menuData) == 0) {
//							System.out.println("輸入錯誤，請重新輸入" );
//							break;
//						}

						mPtion = getSerialNumber();
						if ( checkArgument(mPtion, menuData) < 0) {
							System.out.println("輸入錯誤，請重新輸入" );
							break;
						}
						rtnStatus = modifiedS1Para(mPtion);
						if (rtnStatus == -1 || rtnStatus == 0 ) {
							System.out.println("輸入錯誤，請重新輸入" );
							break;
						}
						break;
					case 2:
						rtnStatus = modfiedParaType("capMap");
						if (rtnStatus == -1 || rtnStatus == 0) {
							System.out.println("輸入錯誤，請重新輸入" );
							break;
						}
	
						if ( modifiedFinallyCmfn(2, capMap.get(orderMap.get(modifiedKey).getOrderCap()).getCapNm(), capMap.get(rtnStatus).getCapNm() + "," + capMap.get(rtnStatus).getCap()) ) {
							orderMap.get(modifiedKey).setOrderCap(rtnStatus);
						}
						
						break;
					case 3:
						rtnStatus = modfiedParaType("sweetMap");
						if (rtnStatus == -1 || rtnStatus == 0) {
							System.out.println("輸入錯誤，請重新輸入" );
							break;
						}
	
						if ( modifiedFinallyCmfn(3, sweetMap.get(orderMap.get(modifiedKey).getOrderSwe()).getSweetNm(), sweetMap.get(rtnStatus).getSweetNm() ) ) {
							orderMap.get(modifiedKey).setOrderSwe(rtnStatus);
						}
						break;
					case 4:
						rtnStatus = modfiedParaType("IceMap");
						if (rtnStatus == -1 || rtnStatus == 0) {
							System.out.println("輸入錯誤，請重新輸入" );
							break;
						}
	
						if ( modifiedFinallyCmfn(4, IceMap.get(orderMap.get(modifiedKey).getOrderIce()).getIceNm(), IceMap.get(rtnStatus).getIceNm() ) ) {
							orderMap.get(modifiedKey).setOrderIce(rtnStatus);
						}
						break;
					case 5:
						if ( !modifiedCustInfo() ) {
							return false;
						}
						break;
					case 0:
						return false;
					default:
						System.out.println("輸入錯誤，請重新輸入" );
						continue;
					}
				}catch(Exception e) {
					scanner.next();
					System.err.print("輸入錯誤" );
					System.out.println();
					continue;
				}
				break;
			case "2":
				deleteOrder();
				System.out.println("已成功刪除 訂單 (" + modifiedOrderNo + "), 訂單序號 (" + modifiedSeqno + ")"  );
				return true;
				
			}
			
			System.out.print("是否繼續修改訂單 (" + orderMap.get(modifiedKey).getOrderId() + "), 訂單序號 (" + orderMap.get(modifiedKey).getSeqno() + 
					") 飲料細項? (Y: 是  N :否):" );
			
			if ( ( scanner.next()).equalsIgnoreCase("N")) {
				break;
			}
			
		}
		

		return false;
	}

	public void getModifiedOrderSeqno (String orderNo) {
		
		while (true) {
			
			searchOrderByNO(orderNo);
			try {
				System.out.print("請輸入訂單商品序號 ( 0.退出 ):" );
				int orderSeqno = scanner.nextInt();
				
				if ( checkRowCount(orderNo, orderSeqno) == 0) {
					System.out.println("輸入錯誤, 請重新輸入。" );
					continue;
				}
			}catch(Exception e) {
				scanner.next();
				System.err.print("輸入錯誤" );
				System.out.println();
				continue;
			}
			break;
		}
	}
	
	public boolean getModifiedOrderNo (String searchStr) {
		String inStr;
		int inStrSearchCnt;
		searchOrderByCust(searchStr);
		while (true) {
			System.out.print("請輸入修改訂單號 ( 0.退出 ):" );
			inStr = scanner.next();
			if ( inStr.equals("0")   ) {
				return false;
			}
			inStrSearchCnt = checkRowCount(inStr);
			if ( ( inStr.charAt(0) != 'O' || inStrSearchCnt == 0 ) ) {
				continue;
			}else if ( inStrSearchCnt > 1 ){
				getModifiedOrderSeqno(inStr);
			}
			break;
		}
		return true;
	}
}

//Q4 出售商品統計 
class Q7_s extends Q7_1 {
	
	int firstKey = 0, lastKey = 0;
	
	public void getKeyRange() {
		for ( int key : menuData.keySet()) {
			if ( firstKey == 0) {
				firstKey = key;
			}
			lastKey = key;
		}
	}
	
	public void comSaleData() {
		int row;
		String LoopYn;
		while(true) {
			showMenuData();
			try {
				getKeyRange();
				System.out.print("請輸入查詢品項 ( " + firstKey + " ~ " + lastKey + " or  全部 (999) or  退出(0) ):" );
				row = scanner.nextInt();
			}catch(Exception e) {
				scanner.next();
				System.err.print("輸入錯誤" );
				System.out.println();
				continue;
			}
			if ( row == 0 ) {
				break ;
			}else if (row == 999) {
				for ( int menuKey : menuData.keySet()){
					System.out.println("品名:" + menuData.get(menuKey).getName() + ", " + "共售出:" + getSalesProdQty(menuKey) + "杯, 總金額: $" + getSalesProdAmt(menuKey) );
				}
				System.out.println("共售出:" + getSalesProdQty(row) + "杯, 總金額: $" + getSalesProdAmt(row) );
				System.out.println();
			}else{
				System.out.println("品名:" + menuData.get(row).getName() + ", " + "共售出:" + getSalesProdQty(row) + "杯, 總金額: $" + getSalesProdAmt(row));
				System.out.println();
			}
			
			System.out.print("是否繼續查詢飲料統計 (Y: 是  N :否):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y")) {
				break;
			}
			
		}
	}
	
	public int getSalesProdQty(int row) {
		int rtnQty = 0;
		for (int key : orderMap.keySet()) {
			if (orderMap.get(key).getOrderMenuId() == row || row == 999) {
				rtnQty += 1;
			}
		}
		return rtnQty;
	}
	
	public int getSalesProdAmt(int row) {
		int rtnAmt = 0;
		for (int key : orderMap.keySet()) {
			if (orderMap.get(key).getOrderMenuId() == row || row == 999) {
				rtnAmt += orderMap.get(key).getOrderAmt();
			}
		}
		return rtnAmt;
	}
}

//Q3 飲料維護
class Q7_m extends Q7_1 {
	
	public int exModifyData(String row, String item, String newValue) {

		switch(item) {
			case "1":
				if ( cmfnAction(2, Integer.parseInt(row), "名稱", newValue) ){
					menuData.get(Integer.parseInt(row)).setName(newValue);
				}else{
					return 0;
				}
				break;
			case "2":
				if ( cmfnAction(2, Integer.parseInt(row), "中杯容量", newValue) ){
					menuData.get(Integer.parseInt(row)).setMediuCap(newValue);
				}else{
					return 0;
				}
				break;
			case "3":
				if ( cmfnAction(2, Integer.parseInt(row), "大杯容量", newValue) ){
					menuData.get(Integer.parseInt(row)).setBigCap(newValue);
				}else{
					return 0;
				}
				break;
			case "4":
				if ( cmfnAction(2, Integer.parseInt(row), "中杯熱量", newValue) ){
					menuData.get(Integer.parseInt(row)).setMediuHeat(newValue);
				}else{
					return 0;
				}
				break;
			case "5":
				if ( cmfnAction(2, Integer.parseInt(row), "大杯熱量", newValue) ){
					menuData.get(Integer.parseInt(row)).setBigHeat(newValue);
				}else{
					return 0;
				}
				break;
			case "6":
				if ( cmfnAction(2, Integer.parseInt(row), "飲品介紹", newValue) ){
					menuData.get(Integer.parseInt(row)).setDesc(newValue);
				}else{
					return 0;
				}
				break;
			case "7":
				if ( cmfnAction(2, Integer.parseInt(row), "中杯價格", newValue) ){
					menuData.get(Integer.parseInt(row)).setMediuPrice( Integer.parseInt(newValue));
				}else{
					return 0;
				}
				break;
			case "8":
				if ( cmfnAction(2, Integer.parseInt(row), "大杯價格", newValue) ){
					menuData.get(Integer.parseInt(row)).setBigPrice( Integer.parseInt(newValue));
				}else{
					return 0;
				}
				break;
		}
		return -1;
	}
	
	public void exModifyMenuStru(int type) {
		String LoopYn = "Y", inputData;
		String printStr = (type == 1 ? "新增" : ( type == 2 ) ? "修改" : "刪除") ;
		Scanner sc = new Scanner(System.in);

		while( !LoopYn.equalsIgnoreCase("N")) {
			switch(type) {
				case 1:
					showMenuData();			
					System.out.print("請輸入修改品項資料, 依序為名稱、容量(中)、容量(大)、熱量(中)、熱量(大)、飲品介紹、價格(中)、價格(大) , 依逗號隔開( 0:退出):");
					try {
						String[] data = new String[8];
						inputData = sc.nextLine();	
						if (inputData.equals("0")) {
							return;
						}
						data = inputData.split(",");
						if ( cmfnAction(1, menuData.size() +1, "", inputData) ) {
							insertMenu(menuData.size() +1, data[0], data[1], data[2], data[3], data[4], data[5], 
									(int) Double.parseDouble(data[6]) ,
									(int) Double.parseDouble(data[7]));
						}else{
							continue;
						}
					}catch(Exception e) {
						System.err.print("輸入錯誤" );
						System.out.println();
						continue;
					}
					System.out.println();
					break;
				case 2:
					showMenuData();			
					System.out.print("請輸入欲修改品項序號、項次、修改值，依逗號隔開(1.名稱 2.中杯容量 3.大杯容量 4.中杯熱量 5.大杯熱量 6.飲品介紹 7.中杯價格 8.大杯價格 0:退出):");
					inputData = sc.nextLine();		
					if (inputData.equals("0")) {
						return;
					}
					try {
						String[] data_m = new String[3];
						data_m = removeEmptyChar(inputData).split(",");
						
						if ( exModifyData(data_m[0], data_m[1], data_m[2]) == 0 ) {
							continue;
						}
					}catch(Exception e) {
						System.err.print("輸入錯誤" );
						System.out.println();
						continue;
					}
					System.out.println();
					break;
				case 3:
					showMenuData();		
					try {
						System.out.print("請數入欲刪除品項序號( 0:退出):" );
						menuRow = scanner.nextInt();
					}catch(Exception e) {
						scanner.next();
						System.err.print("輸入錯誤" );
						System.out.println();
						continue;
					}
					if (menuRow == 0) {
						return;
					}
					if ( cmfnAction(3, menuRow, "", "") ) {
						menuData.remove(menuRow);
						System.out.println("已刪除完成" );
					}else{
						continue;
					}
					break;
			}
			
			System.out.print(printStr + "完成，是否繼續" + printStr + " (Y: 是  N :否):" );
			LoopYn = scanner.next();

			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
		}	
//		sc.close();
	}
	
	public boolean cmfnAction (int asType, int Key, String moditem, String asContext) {
		
		switch(asType) {
		case 1:
			System.out.print("是否確定新增 新序號 " + Key + ", 飲品內容:  " + asContext + " ? (Y: 是  N :否):" );
			if ( (scanner.next()).equalsIgnoreCase("Y") ) {
				return true;
			}
			System.out.println("新增取消" );
			break;
		case 2:
			System.out.print("是否確定修改 序號 " + Key + ", 飲品細項 (" + moditem  + ") " + asContext + " 為 " + asContext + " ? (Y: 是  N :否):" );
			if ( (scanner.next()).equalsIgnoreCase("Y") ) {
				return true;
			}
			System.out.println("修改取消" );
			break;
		case 3:
			System.out.print("是否確定刪除 序號 " + Key + " 飲品  ? (Y: 是  N :否):" );
			if ( (scanner.next()).equalsIgnoreCase("Y") ) {
				return true;
			}
			System.out.println("刪除取消" );
			break;
		
		}
		
		return false;
	}
	
	public void modifyMenu() {
		String LoopYn = "Y";
		while ( !LoopYn.equalsIgnoreCase("N")) {
			try {
				System.out.print("請輸入修改類型 (1.新增  2.修改 3.刪除) :" );
				exModifyMenuStru(scanner.nextInt());
			}catch(Exception e) {
				scanner.next();
				System.err.print("輸入錯誤，請重新輸入" );
				System.out.println();
				continue;
			}

			System.out.print("是否繼續飲料維護 (Y: 是  N :否):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
		}
	}

}

class Q7_1 {

	//Menu初始化
	static Map<Integer, Menu> menuData = new LinkedHashMap<Integer, Menu>() ;
	static Map<Integer, OrderData> orderMap = new LinkedHashMap<Integer, OrderData>() ;
	static Map<Integer, SweetRange> sweetMap = new LinkedHashMap<Integer, SweetRange>() ;
	static Map<Integer, IceRange> IceMap = new LinkedHashMap<Integer, IceRange>() ;
	static Map<Integer, CapType> capMap = new LinkedHashMap<Integer, CapType>() ;
	static Map<Integer, CustInfo> custMap = new LinkedHashMap<Integer, CustInfo>() ;
	static int orderMapRow = 0, orderNo = 0, seqno = 0, menuRow = 1;

	Scanner scanner = new Scanner(System.in);

	public void init() {
		initMenuData();
		initSweetMap();
		initIceMap();
		initCapMap();
	}

	public void initMenuData() {
		insertMenu(menuRow++, "紅茶", "500", "700", "129.8", "186.1", "錫蘭紅茶，產地康提 (Kandy)", 30, 35);
		insertMenu(menuRow++, "薰衣草奶茶", "500", "700", "320", "407", "產地法國",  45, 55);
		insertMenu(menuRow++, "綠茶", "500", "700", "115", "211", "產地台灣 三峽", 30, 35);
		insertMenu(menuRow++, "青茶", "500", "700", "0", "0", "產地日本", 25, 30);
		insertMenu(menuRow++, "高山茶", "500", "700", "10", "14", "產地台灣原始森林台地", 30, 35);
		insertMenu(menuRow++, "水果茶", "500", "700", "290", "382", "產地台灣", 55, 70);
		//更改Menu項目
		insertMenu(menuRow++, "仙草凍紅茶", "500", "700", "150", "258", "手工仙草，錫蘭紅茶，產地康提 (Kandy)", 55, 65);
		insertMenu(menuRow++, "仙草凍乃茶", "500", "700", "353", "475", "手工仙草，奶茶產地法國", 60, 70);
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
	
	public void insertMenu(int index, String name, String mediuCap, String bigCap, String mediuHeat, String bigHeat, String desc, 
			int mediuPrice, int bigPrice) {
		menuData.put(index, new Menu(name, mediuCap, bigCap, mediuHeat, bigHeat, desc, mediuPrice, bigPrice));
	}
	
	public void showMenu() {
		System.out.print("\t名稱 " + "\t" + "價格(中/大)");
		System.out.println();

		for ( int key : menuData.keySet()){
			System.out.println(key + "\t" + menuData.get(key).getName() + "\t" +
					menuData.get(key).getMediuPrice() + "/" + menuData.get(key).getBigPrice());
		}
		System.out.println();
	}

	public void createOrder(String custId, int num, int cap, int swe, int ice) {
		seqno++;
		orderMap.put( orderMapRow, new OrderData(
				String.format("O000%s", String.valueOf(orderNo) ),
				custId, seqno, num, cap, swe, ice,
				( capMap.get(cap).getCapNm().equals("大") ? menuData.get(num).getBigPrice() : menuData.get(num).getMediuPrice()) ) );
	}

	public int newCustMap(int custIndex) {
		String custNm, custTel;

		custNm = getCustInfo("請輸入顧客姓名");
		if (custNm.equals("0")) {
			return 0;
		}

		custTel = getCustInfo("請輸入顧客電話");
		if (custTel.equals("0")) {
			return 0;
		}

		custIndex++;
		custMap.put(custIndex, new CustInfo( String.format("C00%s", String.valueOf(custIndex)) ,custNm, custTel) ) ;
		
		return custIndex;
	}

	public String getCustInfo(String asPrint) {
			System.out.print(asPrint + "( 0:退出 ):");
			return  ( scanner.next() );	
	}

	public int getSerialNumber() {
		try{
			System.out.print("請輸入餐點序號( 0:退出 ):");
			return  ( scanner.nextInt() );
		}catch(Exception e) {
			scanner.next();
			return  -1;
		}
	}

	public int getOrderInfo( Map<Integer, ?> asMap, String asPrint) {
		try{
			System.out.print(asPrint);
			for (int key : asMap.keySet()) {
				if ( asMap == capMap ) {
					System.out.print(key + "." + capMap.get(key).getCapNm() + "\t");
				}else if ( asMap == sweetMap ) {
					System.out.print(key + "." + sweetMap.get(key).getSweetNm() + "\t");
				}else if ( asMap == IceMap ) {
					System.out.print(key + "." +  IceMap.get(key).getIceNm() + "\t");
				}
			}
			System.out.print(" 0:退出 ) :" );
			return ( scanner.nextInt() );
		}catch(Exception e) {
			scanner.next();
			return -1;
		}
	}

	public void orderPara(int custRow) {
		int num, ice, swe, cap;
		showMenu();
		orderMapRow++;
		num = getSerialNumber();
		if ( checkArgument(num, menuData) == -1 ) {
			return ;
		}else if (checkArgument(num, menuData) == 0) {
			return;
		}

		cap = getOrderInfo(capMap, "請輸入餐點杯量\t(");
		if ( checkArgument(cap, capMap) == -1  ) {
			return ;
		}else if (checkArgument(cap, capMap) == 0) {
			return;
		}

		swe = getOrderInfo(sweetMap, "請輸入甜度\t(");
		if ( checkArgument(swe, sweetMap) == -1  ) {
			return ;
		}else if (checkArgument(swe, sweetMap) == 0) {
			return;
		}

		ice = getOrderInfo(IceMap, "請輸入冰度\t(");
		if ( checkArgument(ice, IceMap) == -1  ) {
			return ;
		}else if (checkArgument(ice, IceMap) == 0) {
			return;
		}

		createOrder(custMap.get(custRow).getCustId(), num, cap, swe, ice);

		System.out.printf("您點選的餐點為: %s, %s, %s, %s, $%d !",
				menuData.get(num).getName(),
				capMap.get(cap).getCapNm(),
				sweetMap.get(swe).getSweetNm() ,
				IceMap.get(ice).getIceNm() ,
				( capMap.get(cap).getCapNm().equals("大") ? menuData.get(num).getBigPrice() : menuData.get(num).getMediuPrice()) ) ;
		System.out.println();
		
	}
	
	public void orderMenu(int custRow) {
		orderNo ++;
		String LoopYn = "N";
		while( true ) {
			orderPara(custRow);
			
			System.out.printf("是否繼續點餐? (Y: 是  N :否):");
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") ) {
				System.out.println("您的餐點如下: ");
				if ( searchOrderByCust( custMap.get(custRow).getCustNm() ) == 0) {
					System.out.println("*未取取任何餐點。 ");
				}
				LoopYn = "N";
				break;
			}
		}
		seqno = 0;
	}

	public int checkArgument(int argu, Map<Integer, ?> asMap) {
		if (argu == 0) {
			System.out.println("回上一層");
			return -1;
		}else if (argu == -1 ) {
			System.out.println("輸入錯誤，請重新設定");
			return -1;
		}else if (!checkKeyVaild(asMap, argu) ) {
			System.out.println("找不到品項，請重新輸入");
			return 0;
		}
		return 1;
	}
	
	public boolean checkKeyVaild(Map<Integer, ?> asMap, int argu) {
		for (int key : asMap.keySet()) {
			if ( String.valueOf(key).equals(String.valueOf(argu))) {
				return true;
			}
		}
		return false;
	}
	
	public void printSearchOrderData(int key, int custKey) {
		// 更改熱量計算方式
		System.out.println(orderMap.get(key).getOrderId() + "\t" + custMap.get(custKey).getCustNm() + "\t"
				+ custMap.get(custKey).getCustTel() + "\t"
				+ (Integer.parseInt(custMap.get(custKey).getCustTel()) > 9999999 ? "" : "\t") // 排版調整
				+ orderMap.get(key).getSeqno() + "\t"
				+ menuData.get(orderMap.get(key).getOrderMenuId()).getName() + "\t"
				+ capMap.get(orderMap.get(key).getOrderCap()).getCapNm() + "\t"
				+ sweetMap.get(orderMap.get(key).getOrderSwe()).getSweetNm() + "\t"
				+ IceMap.get(orderMap.get(key).getOrderIce()).getIceNm() + "\t"
				+ (Double.parseDouble(capMap.get(orderMap.get(key).getOrderCap()).getCapNm().equals("大")
								? menuData.get(orderMap.get(key).getOrderMenuId()).getBigHeat()
								: menuData.get(orderMap.get(key).getOrderMenuId()).getMediuHeat())
						* orderMap.get(key).getOrderSwe() / 10)
				+ "\t" + orderMap.get(key).getOrderAmt());
	}
	
	public int getCustMapKey(String custId) {
		for (int key : custMap.keySet())  {
			if ( custMap.get(key).getCustId().equals(custId)) {
				return key;
			}
		}
		return -1;	
	}
	
	public int searchOrderByCust(String custNm) {
		int custKey, row = 0;
		for (int key : orderMap.keySet()) {
			custKey = getCustMapKey(orderMap.get(key).getCustId());
			if (custMap.get(custKey).getCustNm().equals(custNm)) {
				row ++;
				printSearchOrderData(key, custKey);
			}
		}
		System.out.println();
		return row;
	}

	public int searchOrderByNO(String orderNo) {
		int row = 0;
		for (int key : orderMap.keySet()) {
			if ( orderMap.get(key).getOrderId().equals(orderNo)) {
				row ++;
				printSearchOrderData(key, getCustMapKey(orderMap.get(key).getCustId()));
			}
		}
		System.out.println();
		return row;
	}
	
	public void searchOrder() {
		String searchStr;
		System.out.print("請輸入顧客姓名 或 訂單號:");
		searchStr = scanner.next();
		System.out.println("訂單號\t" + "顧客姓名\t" + "顧客電話\t\t" + "項次\t" + "品名\t" + "容量\t" + "甜度\t" + "冰度\t" + "熱量\t" + "商品價格\t" );
		switch (searchStr.charAt(0)) {
		case 'O':
			searchOrderByNO(searchStr);
			break;
		default:
			searchOrderByCust(searchStr);
			break;			
		}
	}
	
	//重新查詢機制
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
	
	public String removeEmptyChar(String str) {
		return str.replaceAll(" ", "");
	}
	
	public void showMenuData() {
		System.out.println( "\t名稱 \t中杯容量 \t大杯容量 \t中杯熱量 \t大杯熱量 \t飲品介紹 \t\t中杯價格 \t大杯價格");
		for (int key : menuData.keySet()) {
			System.out.print( key + "\t" + menuData.get(key).getName() + "\t");
			System.out.print( menuData.get(key).getMediuCap() + "\t");
			System.out.print( menuData.get(key).getBigCap() + "\t");
			System.out.print( menuData.get(key).getMediuHeat() + "\t");
			System.out.print( menuData.get(key).getBigHeat() + "\t");
			System.out.print( menuData.get(key).getDesc() + "\t");
			System.out.print( menuData.get(key).getMediuPrice() + "\t\t");
			System.out.print( menuData.get(key).getBigPrice() + "\t");
			System.out.println();
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
	String orderId, custId ;
	int seqno, orderMenuId, orderCap, orderSwe, orderIce, orderAmt;
	
	public OrderData(String orderId, String custId, int seqno, int orderMenuId, int orderCap, int orderSwe,
			int orderIce, int orderAmt) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		this.seqno = seqno;
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
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
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
	String sweetNm;

	public SweetRange(String sweetNm) {
		super();
		this.sweetNm = sweetNm;
	}

	public String getSweetNm() {
		return sweetNm;
	}

	public void setSweetNm(String sweetNm) {
		this.sweetNm = sweetNm;
	}

}

class IceRange{
	String iceNm;

	public IceRange(String iceNm) {
		super();
		this.iceNm = iceNm;
	}

	public String getIceNm() {
		return iceNm;
	}

	public void setIceNm(String iceNm) {
		this.iceNm = iceNm;
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

class CustInfo {
	String custId, custNm, custTel;

	public CustInfo(String custId, String custNm, String custTel) {
		super();
		this.custId = custId;
		this.custNm = custNm;
		this.custTel = custTel;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getCustTel() {
		return custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}
}