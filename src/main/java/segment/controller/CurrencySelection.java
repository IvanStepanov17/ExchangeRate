package segment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import segment.selected.CurrencyName;

/**
 * Класс для получения вводных данных от клиента и отправки ответа на отображение.
 * @author ivan.v.stepanov
 */

public class CurrencySelection extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**	select_Currency - Идентификатор выбранной клиентом валюты. */
	private int select_Currency; 
	
	/**	jsonExchanges - Экземпляр класса @see CurrencyName с набором данных для отображения клиенту. */
	private CurrencyName jsonExchanges;
	
	/** Метод для отправки ответа клиенту на основании данных {@link CurrencySelection#jsonExchanges} */
	private void ratesExchange(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("purchasePriceHitBTC", jsonExchanges.getExchanges().getJsonForHitBTC().get("purchasePriceHitBTC").toString());
        request.setAttribute("sellingPriceHitBTC", jsonExchanges.getExchanges().getJsonForHitBTC().get("sellingPriceHitBTC").toString());
		request.setAttribute("purchasePricePoloniex", jsonExchanges.getExchanges().getJsonForPoloniex().get("purchasePricePoloniex").toString());
        request.setAttribute("sellingPricePoloniex", jsonExchanges.getExchanges().getJsonForPoloniex().get("sellingPricePoloniex").toString());
        
		RequestDispatcher view = request.getRequestDispatcher("viewRate.jsp");
		view.forward(request, response);
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		select_Currency = Integer.parseInt(req.getParameter("currency"));
		jsonExchanges = new CurrencyName(select_Currency);
			ratesExchange(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		select_Currency = Integer.parseInt(req.getParameter("currency"));
		jsonExchanges = new CurrencyName(select_Currency);
			ratesExchange(req, resp);
	}
	
}
