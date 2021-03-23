package phone_book;

public class BookView {
	public void openingView() {
		System.out.println("****************************************");
	    System.out.println("*           전화번호 관리 프로그램           *");
	    System.out.println("****************************************");
	    System.out.println("****************************************");
	      
	}
	
	public void menuView() {
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
	    System.out.println("--------------------------------");
	    System.out.println(">메뉴 번호 : ");
	}
	
	public void listView() {
		//tdb.addresslist();
		System.out.println("<1.리스트>");
		
	}
	
	public void addView() {
		System.out.println("<2.추가>");
		
	}
	public void deleteView() {
		System.out.println("<3.삭제>");
		
	}
	public void searchView() {
		System.out.println("<4.검색>");
		
	}
	
	public void wrongView() {
		System.out.println("다시 입력해주세요");
		
	}
	public void endingView() {
		System.out.println("****************************************");
	    System.out.println("*           프로그램이 종료되었습니다.         *");
	    System.out.println("****************************************");
	   	      
	}
}