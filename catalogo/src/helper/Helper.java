package helper;

import javax.servlet.http.HttpServletRequest;

public abstract class Helper {
	
	protected HttpServletRequest request;
	
	public Helper(HttpServletRequest request) {
		this.request = request;
	}
	
	public abstract boolean convalida();
}

