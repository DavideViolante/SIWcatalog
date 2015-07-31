package helper;

import javax.servlet.http.HttpServletRequest;

public class FormOrdineHelper extends Helper {
	private String idOrdine;
	private String quantita;
	private String idProdotto;

	public FormOrdineHelper(HttpServletRequest request) {
		super(request);
		this.idOrdine = request.getParameter("idOrdine");
		this.quantita = request.getParameter("quantita");
		this.idProdotto = request.getParameter("idProdotto");
	}

	@Override
	public boolean convalida() {
		boolean bool = true;
		
		if (this.idOrdine.isEmpty() || !this.idOrdine.matches("^[0-9]*$")) {
			request.setAttribute("erroreID", "ID obbligatorio.");
			bool = false;
		}
		return bool;
	}
	
	public boolean convalida2() {
		boolean bool = true;
		
		if (this.idOrdine.isEmpty() || !this.idOrdine.matches("^[0-9]*$")) {
			request.setAttribute("erroreID2", "ID obbligatorio.");
			bool = false;
		}
		return bool;
	}
	
	public boolean convalidaRiga() {
		boolean bool = true;
		
		if(this.idProdotto.isEmpty()) {
			request.setAttribute("erroreID", "ID prodotto obbligatorio.");
			bool = false;
		}
		if(this.quantita.isEmpty() || !this.quantita.matches("^[1-9][0-9]*$")) {
			request.setAttribute("erroreQuantita", "Quantità obbligatoria.");
			bool = false;
		}
		return bool;
	}

}
