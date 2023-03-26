package exam.chan.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExamVO {
	public ExamVO(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	private String id;
	private String name;
	private String password;
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
