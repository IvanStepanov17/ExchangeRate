package segment.utils;

import java.net.URL;

import org.json.simple.JSONObject;

/**
 * Класс для создания и отправки запроса к биржевым API HitBTC и Poloniex 
 * @author ivan.v.stepanov
 *
 */

public class JsonForExchanges {
	
	/** @param url_HitBTC - параметр для запроса к API HitBTC сформированный на основании вводных данных клиента. */
	private String url_HitBTC;
	
	/** @param url_Poloniex - параметр для запроса к API Polniex сформированный на основании вводных данных клиента. */
	private String url_Poloniex;
	
	/** @param jsonForHitBTC - книга ордеров биржи HitBTC */
	private JSONObject jsonForHitBTC;
	
	/** @param jsonForPoloniex - книга ордеров биржи Poloniex */
	private JSONObject jsonForPoloniex;
	
	public JsonForExchanges() {
		
	}
	
	/** Конструктор для получения курсов валют с бирж HitBTC и Poloniex
	 * @param baseCurrency - строка для создания запроса к API HitBTC
	 * @param quoteCurrency - строка для создания запроса к API Poloniex
	 */ 
	public JsonForExchanges(String baseCurrency, String quoteCurrency) {
		getTheValueOfExchangeRatesHitBTC(baseCurrency);
		getTheValueOfExchangeRatesPoloniex(quoteCurrency);
	}
	
	/** Метод для получения значений курса валют {@link JsonForExchanges#jsonForHitBTC} с биржи HitBTC */
	private void getTheValueOfExchangeRatesHitBTC(String exchangeRatesHitBTC) {
		url_HitBTC = "https://api.hitbtc.com/api/2/public/orderbook/" + exchangeRatesHitBTC + "?limit=1";
		URL url = JsonUtils.createUrl(url_HitBTC);
		String resultJson = JsonUtils.parseUrl(url);
		jsonForHitBTC = JsonUtils.parseCurrentRatesHitBTC(resultJson);
	}
	
	/** Метод для получения значений курса валют {@link JsonForExchanges#jsonForPoloniex} с биржи Poloniex */
	private void getTheValueOfExchangeRatesPoloniex(String exchangeRatesPoloniex) {
		url_Poloniex = "https://poloniex.com/public?command=returnOrderBook&currencyPair=" + exchangeRatesPoloniex + "&depth=1";
		URL url = JsonUtils.createUrl(url_Poloniex);
		String resultJson = JsonUtils.parseUrl(url);
		jsonForPoloniex = JsonUtils.parseCurrentRatesPoloniex(resultJson);
	}

	public JSONObject getJsonForHitBTC() {
		return jsonForHitBTC;
	}

	public void setJsonForHitBTC(JSONObject jsonForHitBTC) {
		this.jsonForHitBTC = jsonForHitBTC;
	}

	public JSONObject getJsonForPoloniex() {
		return jsonForPoloniex;
	}

	public void setJsonForPoloniex(JSONObject jsonForPoloniex) {
		this.jsonForPoloniex = jsonForPoloniex;
	}

}
