package segment.selected;

import segment.utils.JsonForExchanges;

/**
 * Класс определения идентификатора валюты и формирования данных для запроса к биржевым API
 * @author ivan.v.stepanov
 *
 */

public class CurrencyName {
	
	/** Выбранная валюта */
	private int currencyId;
	
	/** Строка с наименованием сравниваемых валют для формирования запроса к API HitBTC */
	private String exchangeRatesHitBTC;
	
	/** Строка с наименованием сравниваемых валют для формирования запроса к API Poloniex */
	private String exchangeRatesPoloniex;
	
	/** Объект с текущим курсом валют */
	private JsonForExchanges exchanges;
	
	public CurrencyName() {
		
	}
	
	/**
	 * Конструктор для получения идентификатора выбранной валюты {@link CurrencyName#choiseCurrency()} 
	 * и вызова и создания объекта с курсом валют {@link segment.utils.JsonForExchanges}.
	 * @param currency - Идентификатор выбранной клиентом валюты
	 */
	public CurrencyName(int currency) {
		this.currencyId = currency;
		choiseCurrency();
		exchanges = new JsonForExchanges(exchangeRatesHitBTC, exchangeRatesPoloniex);
	}
	
	/** В соответствии с выбранной валютой {@link CurrencyName#currencyId} метод присваивает 
	 * значения параметрам {@link CurrencyName#exchangeRatesHitBTC}, {@link CurrencyName#exchangeRatesPoloniex} 
	 * для формирования запроса к биржевым API 
	 */
	private void choiseCurrency() {
		switch(currencyId) {
			case 1:
				exchangeRatesHitBTC = "BTCUSD";
				exchangeRatesPoloniex = "USDT_BTC";
				break;
			case 2:
				exchangeRatesHitBTC = "ETHBTC";
				exchangeRatesPoloniex = "BTC_ETH";
				break;
		}
	}
	
	public String getExchangeRatesHitBTC() {
		return exchangeRatesHitBTC;
	}

	public void setExchangeRatesHitBTC(String exchangeRatesHitBTC) {
		this.exchangeRatesHitBTC = exchangeRatesHitBTC;
	}

	public String getExchangeRatesPoloniex() {
		return exchangeRatesPoloniex;
	}

	public void setExchangeRatesPoloniex(String exchangeRatesPoloniex) {
		this.exchangeRatesPoloniex = exchangeRatesPoloniex;
	}

	public JsonForExchanges getExchanges() {
		return exchanges;
	}

	public void setExchanges(JsonForExchanges exchanges) {
		this.exchanges = exchanges;
	}
}
