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
		//���Menu����
		menuDate.put( 1, new Menu("����", "500", "700", "129.8", "186.1", "���������A���a�d�� (Kandy)", 30, 35));
		menuDate.put( 2, new Menu("�Ȧ�󥤯�", "500", "700", "320", "407", "���a�k��",  45, 55));
		menuDate.put( 3, new Menu("���", "500", "700", "115", "211", "���a�x�W �T�l", 30, 35));
		menuDate.put( 4, new Menu("�C��", "500", "700", "0", "0", "���a�饻", 25, 30));
		menuDate.put( 5, new Menu("���s��", "500", "700", "10", "14", "���a�x�W��l�˪L�x�a", 30, 35));
		menuDate.put( 6, new Menu("���G��", "500", "700", "290", "382", "���a�x�W", 55, 70));
	}
	
	@Override
	public void searchOrder() {
		//�����q�p��覡
		String custNm;
		System.out.print("�п�J�U�ȩm�W:");
		custNm = scanner.next();
		System.out.println("�q�渹\t" + "�U�ȩm�W\t" + "�~�W\t" + "�e�q\t" + "����\t" + "�B��\t" + "���q\t" + "�ӫ~����\t" );
		for (int key : orderMap.keySet()) {
			if (orderMap.get(key).getOrderCustNm().equals(custNm)) {
				System.out.println( orderMap.get(key).getOrderId() + "\t" + 
									orderMap.get(key).getOrderCustNm() + "\t" + 
									menuDate.get(orderMap.get(key).getOrderMenuId()).getName()   + "\t" + 
									capMap.get(orderMap.get(key).getOrderCap()).getCapNm()  + "\t" + 
									sweetMap.get(orderMap.get(key).getOrderSwe()).getSweetDesc() + "\t" + 
									IceMap.get(orderMap.get(key).getOrderIce()).getIceDesc()  + "\t" + 
									( Double.parseDouble( capMap.get(orderMap.get(key).getOrderCap()).getCapNm().equals("�j") ? 
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
			System.out.print("�п�ܰ���\�� (1. ���߭q��  2.�d�߭q��):" );
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
			System.out.print("�O�_�~����� (Y: �O  N :�_):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
			System.out.println();
		}
		System.out.print("����!" );
	}
	//��ﭫ�s�d�߾���
	public void searchOrderLoop() {
		String LoopYn = "Y";
		while ( !LoopYn.equalsIgnoreCase("N") ) {
			searchOrder();
			System.out.print("�O�_�~��d�� (Y: �O  N :�_):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
			System.out.println();
		}
	}
}


abstract class Q7_1 implements Q7Action{
	
	//Menu��l��
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
		menuDate.put( 1, new Menu("�եɼ���", "500", "700", "395", "443", new menuDesc().getDrinkDesc1(), 50, 60));
		menuDate.put( 2, new Menu("�گצh�h", "500", "700", "320", "407", new menuDesc().getDrinkDesc2(), 45, 55));
		menuDate.put( 3, new Menu("���ì���", "500", "700", "287", "377", new menuDesc().getDrinkDesc3(), 50, 60));
		menuDate.put( 4, new Menu("�K���B��", "500", "700", "257", "356", new menuDesc().getDrinkDesc4(), 40, 50));
		menuDate.put( 5, new Menu("�N�S����", "500", "700", "221", "307", new menuDesc().getDrinkDesc5(), 45, 55));
		menuDate.put( 6, new Menu("��������", "500", "700", "258", "311", new menuDesc().getDrinkDesc6(), 45, 55));
		menuDate.put( 7, new Menu("����N�S", "500", "700", "176", "247", new menuDesc().getDrinkDesc7(), 30, 35));
		menuDate.put( 8, new Menu("�����N�S", "500", "700", "155", "211", new menuDesc().getDrinkDesc8(), 30, 35));
		menuDate.put( 9, new Menu("�K�ާN�S", "500", "700", "135", "211", new menuDesc().getDrinkDesc9(), 30, 35));
		menuDate.put(10, new Menu("��������", "500", "700", "180", "200", new menuDesc().getDrinkDesc10(), 30, 35));
		menuDate.put(11, new Menu("�R�K����", "500", "700", "180", "200", new menuDesc().getDrinkDesc11(), 30, 35));
		menuDate.put(12, new Menu("�گ׬���", "500", "700", "180", "200", new menuDesc().getDrinkDesc12(), 40, 45));
		menuDate.put(13, new Menu("�Ӧm����", "500", "700", "161", "182", new menuDesc().getDrinkDesc13(), 35, 40));
		menuDate.put(14, new Menu("�K�޺��", "500", "700", "160", "180", new menuDesc().getDrinkDesc14(), 30, 35));
		menuDate.put(15, new Menu("�����f�G", "500", "700", "168", "300", new menuDesc().getDrinkDesc15(), 55, 65));
	}
	
	public void initSweetMap() {
		sweetMap.put(1, new sweetRange("�L�}"));
		sweetMap.put(2, new sweetRange("�@���}"));
		sweetMap.put(3, new sweetRange("�G���}"));
		sweetMap.put(4, new sweetRange("�L�}"));
		sweetMap.put(5, new sweetRange("�b�}"));
		sweetMap.put(6, new sweetRange("�ֿ}"));
		sweetMap.put(7, new sweetRange("���`�}"));
	}
	
	public void initIceMap() {
		IceMap.put(1, new IceRange("��"));
		IceMap.put(2, new IceRange("��"));
		IceMap.put(3, new IceRange("�`��"));
		IceMap.put(4, new IceRange("�����h�B"));
		IceMap.put(5, new IceRange("�h�B"));
		IceMap.put(6, new IceRange("�L�B"));
		IceMap.put(7, new IceRange("�֦B"));
		IceMap.put(8, new IceRange("���`�B"));
	}
	
	public void initCapMap() {
		capMap.put(1, new capType("�j", 700));
		capMap.put(2, new capType("��", 500));
	}
	
	public void showMenu() {
		System.out.print("\t�W�� " + "\t" + "����  \t" + "��" + "/" + "�j");
		System.out.print("\t\t");
		System.out.print("\t�W�� " + "\t" + "����  \t" + "��" + "/" + "�j");
		System.out.print("\t\t");
		System.out.print("\t�W�� " + "\t" + "����  \t" + "��" + "/" + "�j");
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
				( capMap.get(cap).getCapNm().equals("�j") ? menuDate.get(num).getBigPrice() : menuDate.get(num).getMediuPrice()) ) );
	}
	
	public void createMenu() {
		String LoopYn = "Y", chooseType = null;
		
		while ( !LoopYn.equalsIgnoreCase("N") ) {
			System.out.print("�п�ܰ���\�� (1. ���߭q��  2.�d�߭q��):" );
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
			System.out.print("�O�_�~����� (Y: �O  N :�_):" );
			LoopYn = scanner.next();
			if ( !LoopYn.equalsIgnoreCase("Y") && !LoopYn.equalsIgnoreCase("N")) {
				LoopYn = "N";
			}
			System.out.println();
		}
		System.out.print("����!" );
	}
	
	public void orderMenu() {
		int num, ice, swe, cap;
		String custNm;

		System.out.print("�п�J�U�ȩm�W( 0:�h�X ):");
		custNm = scanner.next();
		if (custNm.equals("0")) {
			return ;
		}
		
		System.out.print("�п�J�\�I�Ǹ�( 0:�h�X ):");
		num = scanner.nextInt();
		if (num == 0) {
			return ;
		}

		System.out.print("�п�J�\�I�e�q\t(");
		for (int key : capMap.keySet()) {
			System.out.print(key + "." + capMap.get(key).getCapNm() + "\t");
		}
		System.out.print(" 0:�h�X ) :" );
		cap = scanner.nextInt();
		if (cap == 0) {
			return ;
		}
		
		System.out.print("�п�J����\t(" );
		for (int key : sweetMap.keySet()) {
			System.out.print(key + "." + sweetMap.get(key).getSweetDesc() + "\t");
		}
		System.out.print(" 0:�h�X ) :" );
		swe = scanner.nextInt();
		if (swe == 0) {
			return ;
		}

		System.out.print("�п�J�B��\t(" );
		for (int key : IceMap.keySet()) {
			System.out.print(key + "." + IceMap.get(key).getIceDesc() + "\t");
		}
		System.out.print(" 0:�h�X ) :" );
		ice = scanner.nextInt();
		if (ice == 0) {
			return ;
		}

		orderRow ++;
		createOrder(String.format("0000%s", String.valueOf(orderRow)), custNm, num, cap, swe, ice);
		
	    System.out.printf("�z�I�諸�\�I��: %s, %s, %s, %s, $%d !", 
	    			menuDate.get(num).getName(),  
	    			capMap.get(cap).getCapNm(), 
	    			sweetMap.get(swe).getSweetDesc() , 
	    			IceMap.get(ice).getIceDesc() ,  
	    			( capMap.get(cap).getCapNm().equals("�j") ? menuDate.get(num).getBigPrice() : menuDate.get(num).getMediuPrice()) ) ;
		System.out.println();
		System.out.println();
		

		
	}
	
	public void searchOrder() {
		String custNm;
		System.out.print("�п�J�U�ȩm�W:");
		custNm = scanner.next();
		System.out.println("�q�渹\t" + "�U�ȩm�W\t" + "�~�W\t" + "�e�q\t" + "����\t" + "�B��\t" + "���q\t" + "�ӫ~����\t" );
		for (int key : orderMap.keySet()) {
			if (orderMap.get(key).getOrderCustNm().equals(custNm)) {
				System.out.println( orderMap.get(key).getOrderId() + "\t" + 
									orderMap.get(key).getOrderCustNm() + "\t" + 
									menuDate.get(orderMap.get(key).getOrderMenuId()).getName()   + "\t" + 
									capMap.get(orderMap.get(key).getOrderCap()).getCapNm()  + "\t" + 
									sweetMap.get(orderMap.get(key).getOrderSwe()).getSweetDesc() + "\t" + 
									IceMap.get(orderMap.get(key).getOrderIce()).getIceDesc()  + "\t" + 
									( capMap.get(orderMap.get(key).getOrderCap()).getCapNm().equals("�j") ? 
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
	private String drinkDesc1  = "�x�W��n�����i�ίʪ��g��X�X�ï]�A�����C�n���Z�P���եɬï]�A������n�k�l���ï]�����A�H���طP�W�⭷��C�P���������������X�A�f�P�p��Ӽh���״I�A�O�@�����H���h����ı�W�b�C";
	private String drinkDesc2  = "�H������e��I���֦������q�n���u�D�B�v����A�e���������򩳪��گ׬����A�[�J�Ĳ�������p������i�֦h�A�İ_���Ӥ�������ɦ^�СA���H�۪����P�[���᭻����H�A�p�P���K�H����²b�����Ť����A�p��Ӭ��n�C";
	private String drinkDesc3  = "�ճ��ĩ�������ӽ����A�p�ꪺ�����P�B�N�O�������ۤ���´�A�v���ƶ}�����@�J�M�������C�������N�����B�������A�T�_�@���W���k�k���Ѻq�A�Ḩ���Ъ����P�����A�ĤH�߻�U�d���h�C";
	private String drinkDesc4  = "�K���P�V�ʪ��۹J�A�n�񸤸����j��Ũ�m�Pģ������A��y�I��70�~�N�P�C�¼��һs���V�ʡA�t�W�A�ĬX�ƪ����l�A�N�Ĳ��n�f�������h�h���|�A�h�­����O�H�K�ߡC";
	private String drinkDesc5  = "�V�ʻP�@�J�A���@���@�ۡB�����a�y�S��B�����A���o������{�p���_�k�l�⤤���w�u�A�����J���a�s´����A���㤧�����H�����k�Ӫ����P�A�@�Ѽ��x�������P�����C";
	private String drinkDesc6  = "��V���ܪ�����A�S�p���Y�^�֭��쪺�k�l�A�f�����N�a��ۭ����C�@�����������A���O��ı�O�Ф������~�A�P�Ŷ��̾J���A����ۥ��šA����������ĭ��K�@�Ѩ��������A���Ʋӿ��ϤHı���C";
	private String drinkDesc7  = "�X���Ҫ��V�ʡA�g���몺���J�A���N�W���������έ���A�ϩ��j��̦w�M�۱o�B����h�®������ѥ����A�@�|����ĩ�󮰰_���L���B�t�ۦ������A�ɨ��ŷ֪��ȫ�H�͡C";
	private String drinkDesc8  = "�V�ʻP���������P�S�աA�C���J�����V�ʭ���N�M�G�ƶ��������a�J�t�@�ؼh���C�^�а_��B�Ͼ��U��۷Ϥ�B���g�~�֪������A�b���Ѥ����j���a�A�A�@���ͬ��P��ꪺ�թM���C";
	private String drinkDesc9  = "�K�ާN�S�O�@�ѭ@�H�M������P�A�p�P�R�n���s�M�ֵ������B�C�V�ʳ��~�������A������M������l���U�^�̡A��̩����񪺴��p����A�M�M�V�V�ϤH�N�S���ɡA�A�X�P��Ǥ@�P�㶼�C";
	private String drinkDesc10 = "���a���G���ժ������A�y�S���֨k�l���Hí�𮧡A�C�զӰg�H�C�Y��۴������d���Ϥ������A�a���@���G���ξJ�p�۶ꭻ��F�P�����Ʋz�@�P�~�|�A�o�H�ƸѦަy�W�Ҵݯd���o���P�C";
	private String drinkDesc11 = "�H�����ժ��᭻�աA�i��b�v���w��Ģ������A���o�W���Өq�����A�u���ӥO�H�ɤߡC���ۨu�����������d�������޲��ϯ����A�a�M�n�t�ƪ��᭻�F�f�t���A�Ʋz�ɥΡA�����M�{û��������C";
	private String drinkDesc12 = "��H���G���ջP�@�ٻe�筷���A���H�����P�[���᭻�����e����A�n���B�ٯگת����R�k�l�C�M�s�������p�v¯�^�O���������z�A�N60�~�N�جv����@�����^��A�Ƭ��g�H�����·N�ѡC";
	private String drinkDesc13 = "�@�ػP�����������f�t�X�X �A��������f���ĦX�w�V�A�yø�X�_�j���h����C�֤k�A�bCafe�̺V�ۥ��r���B�Ǩӯȱi�P�����a�������n�T�C�@�ب����f�Ҫ`�J��������ڡA�H�X�ƴ��������A�ҿסu�_��g��v�C";
	private String drinkDesc14 = "�a�����O�B�����yø���C�s�֦~�A�b�K���|�����s�L���֩�۵M�B�����K�ީ�ަy������C�Ѩ��ۥx�W����Aĭ�t�c�Z�K���ҹ��s�����g�A���|�̲����P�C�W�ߡA�C�A���w�Y������f�C";
	private String drinkDesc15 = "�p�P�R���p�~�����֤k�A�a�۪��ʪ����߻P�ߤW�H�u���A�t�W�Ĳ��@�����f�c�J�|�A�b�S�ɪ��ȫ�ɥ����֤k���h�C�����s�A�f�c���{������A���ղn�f�ӯ²b�A���h����7���}�A���N�B���N���n�C";
	
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
