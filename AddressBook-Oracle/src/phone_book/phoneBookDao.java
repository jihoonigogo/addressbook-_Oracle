package phone_book;

import java.util.List;


public interface phoneBookDao { // 인터페이스들 

	public List<phoneBookVo> getList(); //테이블로부터 필드를 받아옴
	public List<phoneBookVo> search(String keyword); // 스캐너를 통해 입력한 값 포함한 필드를 찾아옴
	public phoneBookVo get(Long id); //
	public boolean insert(phoneBookVo vo); //name,hp,tel
	public boolean delete(Long id); //입력한 id값의 행을 지움 ?
}

