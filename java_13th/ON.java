package swing;


class ON{
	static String name,id,pw;
	static int manager;
	public void setOn(String name,String id,String pw,int manager) {
		this.name= name;
		this.id = id;
		this.pw = pw;
		this.manager = manager;
	}
	public void setOff() {
		this.name=null;
		this.id=null;
		this.pw=null;
		this.manager=0;
	}
	public void print() {
		System.out.println(name+" " +id+" "+pw+" "+manager);
	}
}