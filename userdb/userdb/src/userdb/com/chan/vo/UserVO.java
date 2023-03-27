package userdb.com.chan.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserVO {
	private String id; 
	private String name; 
	private String password; 
}
