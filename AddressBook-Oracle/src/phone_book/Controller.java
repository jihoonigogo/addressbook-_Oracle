package phone_book;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {

		//pbDaoOracle PBDO = new pbDaoOracle ();
		PBApp app = new PBApp();
		BookView view = new BookView();
		
	 view.openingView();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			view.menuView();
			
			switch(sc.nextInt()) {
			
			case 1 : view.listView();	
			app.listPhoneBook();
				continue;
			case 2 : view.addView();
			app.addphoneBook();		
				continue;
			case 3 : view.deleteView();
			app.deletePhoneBook();
				continue;
			case 4 :view.searchView();
			app.searchPhoneBook();
				continue;
			case 5 : view.endingView();
						break;
				
			default: view.wrongView();
				continue;
			}
			sc.close();
			break;
		}
		
	}

}
