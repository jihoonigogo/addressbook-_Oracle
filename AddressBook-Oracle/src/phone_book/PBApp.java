package phone_book;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;






public class PBApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listPhoneBook();
		
	addphoneBook();
		//deletePhoneBook();
		//listPhoneBook();
		//searchPhoneBook();
	}

	public static void listPhoneBook() {
		pbDaoOracle dao = new pbDaoOracle();
		List<phoneBookVo> list = dao.getList();
		Iterator<phoneBookVo> it = list.iterator()	; // 반복을 통해서 출력
		
		while(it.hasNext()) {
			phoneBookVo vo = it.next();// 내용불러오기 , 이렇게 연결되는걸 이해못하겠음.
		
			System.out.printf("%d %s %s %s%n", vo.getId(),vo.getName(),vo.getHp(),vo.getTel());
		}
	}

	public static void addphoneBook() {	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 : ");
		String name = sc.next();
		System.out.println("핸드폰번호 : ");
		String hp = sc.next();
		System.out.println("전화번호 : ");
		String tel = sc.next();
		
		phoneBookVo vo = new phoneBookVo (name,hp,tel); // 숫자는 pk로 받음
		pbDaoOracle dao = new pbDaoOracle();
		boolean success = dao.insert(vo); // 위 생성자 형태로 dao에 넣어줌?
		System.out.println("phoneBook INSERT : "+ (success ? "성공":"실패"));
		//sc.close();
	}
	
	public static void deletePhoneBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("삭제할 번호");
		long Id = scanner.nextLong();
		phoneBookDao dao = new pbDaoOracle();
		boolean success = dao.delete(Id);
		System.out.println("phonebook DELETE : " + (success ? "성공": "실패"));
		//scanner.close();
	}
	
	public static void searchPhoneBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("검색어 : ");
		String keyword = scanner.next();
		
		phoneBookDao dao = new pbDaoOracle();
		List<phoneBookVo> list = dao.search(keyword); // 키워드를 전달한다
		
		Iterator<phoneBookVo> it = list.iterator();
		while(it.hasNext()) {
			phoneBookVo vo = it.next();
			System.out.println(vo);
		}
		//scanner.close();
	}
	}


