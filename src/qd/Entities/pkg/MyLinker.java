package qd.Entities.pkg;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="linkers")
public class MyLinker {
	@DatabaseField(generatedId=true)
	private Long id = null; 
	@DatabaseField(uniqueCombo=true, foreign=true)
	private MyWord wordBF = null;
	@DatabaseField(uniqueCombo=true, foreign=true)
	private MyWord wordAF = null;
	public MyLinker() {
		// TODO Auto-generated constructor stub
	}
	
	public MyWord getWordBF() {
		return wordBF;
	}

	public void setWordBF(MyWord wordBF) {
		this.wordBF = wordBF;
	}

	

	public MyWord getWordAF() {
		return wordAF;
	}

	public void setWordAF(MyWord wordAF) {
		this.wordAF = wordAF;
	}

	public MyLinker(MyWord word_bf, MyWord word_af)
	{
		setWordAF(word_bf);
		setWordBF(word_af);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
