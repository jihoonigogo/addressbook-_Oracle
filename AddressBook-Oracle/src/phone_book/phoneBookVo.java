package phone_book;

public class phoneBookVo {

	private long id; // DTO객체에서는 기본타입은 잘 사용하지 않는다 . NULL이 가능해야함
	private String name;
	private String hp;
	private String tel;
	
	public phoneBookVo() {
		//기본 생성자
	}
	
	public phoneBookVo(String name,String hp,String tel) {
		this.name = name;
		this.hp=hp;
		this.tel = tel;
		
}
	public phoneBookVo(long id ,String name,String hp,String tel) {
		this(name,hp,tel);
		this.id = id;
		
		
	}
	// getter setter 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "phoneBookVo [id=" + id + ", name=" + name + ", hp=" + hp + ", tel=" + tel + "]";
	}
	
}
