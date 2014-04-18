package qd.Entities.pkg;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="words")
public class MyWord {
	@DatabaseField(generatedId=true)
	private Long id = null; 
	@DatabaseField(unique=true)
	private String value = null;
	public MyWord() {
		// TODO Auto-generated constructor stub
	}
	public MyWord(String value)
	{
		setValue(value);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
