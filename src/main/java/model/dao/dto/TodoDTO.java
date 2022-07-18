package model.dao.dto;

public class TodoDTO {
	
	//TodoのIdを保持する
	private int id;

	//Todoの内容を保持する
	private String todo;

	//引数なしコンストラクタ 初期化を行う
	public TodoDTO() {
		id = 0;
		todo = "";
	}

	public TodoDTO(int id, String todo) {
		this.id = id;
		this.todo = todo;
	}

	/**
	 * idを取得する
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * idを設定する
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Todoの内容を取得する
	 * 
	 * @return Todoの内容
	 */
	public String getTodo() {
		return todo;
	}

	/**
	 * Todoの内容を設定する
	 * 
	 * @param todo
	 */
	public void setTodo(String todo) {
		this.todo = todo;
	}

}
