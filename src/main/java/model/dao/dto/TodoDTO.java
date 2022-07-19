package model.dao.dto;

public class TodoDTO {
	
	//TodoのIdを格納します
	private int iTodoId;

	//Todoの内容を格納します。
	private String sTodoContent;

	//引数なしコンストラクタ 初期化を行う
	public TodoDTO() {
		iTodoId = 0;
		sTodoContent = "";
	}

	public TodoDTO(int iTodoId, String sTodoContent) {
		this.iTodoId = iTodoId;
		this.sTodoContent = sTodoContent;
	}

	/**
	 * Todoの内容を取得する
	 * 
	 * @return todoContent
	 */
	public String getTodoContent() {
		return sTodoContent;
	}

	/**
	 * Todoの内容を設定する
	 * 
	 * @param sTodoContent
	 */
	public void setTodoContent(String sTodoContent) {
		this.sTodoContent = sTodoContent;
	}
	
	/**
	 * idを取得
	 * 
	 * @return todoId
	 */
	public int getTodoId() {
		return iTodoId;
	}

	/**
	 * idを設定
	 * 
	 * @param iTodoId
	 */
	public void setTodoId(int iTodoId) {
		this.iTodoId = iTodoId;
	}

}
