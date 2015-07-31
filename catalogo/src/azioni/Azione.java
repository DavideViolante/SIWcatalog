package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public abstract class Azione {
	public abstract String esegui(HttpServletRequest request) throws ServletException;	
}
