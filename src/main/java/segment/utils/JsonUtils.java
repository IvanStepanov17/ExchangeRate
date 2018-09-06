package segment.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Класс для получения и парсинга данных с биржевых API
 * @author ivan.v.stepanov
 */

public class JsonUtils {

	/**
	 * Метод для загрузки JSON в виде строки Java
	 * @param url - запрос к биржевому API
	 * @return
	 */
	public static String parseUrl(URL url) {
		if (url == null) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				stringBuilder.append(inputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	/**
	 * Парсим данные курсов валют HitBTC
	 * @param resultJson - Java строка созданная на основании полученного JSON
	 * @return возвращается книга ордеров выбранной валюты с биржи HitBTC
	 */
	public static JSONObject parseCurrentRatesHitBTC(String resultJson) {
		JSONObject jsonObject = new JSONObject();
		try {
			// конвертируем строку с Json в JSONObject для дальнейшего его парсинга
			JSONObject hitBtcJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
			// получаем массив элементов для поля ask
			JSONArray currencyValuesArray = (JSONArray) hitBtcJsonObject.get("ask");
			// достаем из массива первый элемент
			JSONObject bestPurchasePrice = (JSONObject) currencyValuesArray.get(0);
			System.out.println("Лучшая цена покупки на данный момент HitBTC: " + bestPurchasePrice.get("price"));
			jsonObject.put("purchasePriceHitBTC", bestPurchasePrice.get("price"));
			// получаем массив элементов для поля bid
			currencyValuesArray = (JSONArray) hitBtcJsonObject.get("bid");
			// достаем из массива первый элемент
			JSONObject bestSellingPrice = (JSONObject) currencyValuesArray.get(0);
			System.out.println("Лучшая цена продажи на данный момент HitBTC: " + bestSellingPrice.get("price"));
			jsonObject.put("sellingPriceHitBTC", bestSellingPrice.get("price"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * Парсим данные курсов валют Poloniex
	 * @param resultJson - Java строка созданная на основании полученного JSON
	 * @return возвращается книга ордеров выбраной валюты с биржи Poloniex
	 */
	public static JSONObject parseCurrentRatesPoloniex(String resultJson) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject poloniexJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);

			JSONArray currencyValuesArray2 = (JSONArray) poloniexJsonObject.get("asks");
			JSONArray currencyValuesArray = (JSONArray) currencyValuesArray2.get(0);
			String bestPurchasePrice = (String) currencyValuesArray.get(0);
			System.out.println("Лучшая цена покупки на данный момент Poloniex: " + bestPurchasePrice);
			jsonObject.put("purchasePricePoloniex", bestPurchasePrice);
			currencyValuesArray2 = (JSONArray) poloniexJsonObject.get("bids");
			currencyValuesArray = (JSONArray) currencyValuesArray2.get(0);
			String bestSellingPrice = (String) currencyValuesArray.get(0);
			System.out.println("Лучшая цена продажи на данный момент Poloniex: " + bestSellingPrice);
			jsonObject.put("sellingPricePoloniex", bestSellingPrice);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * создаем объект URL из указанной в параметре строки
	 * @param link - строка необходимая для создания url
	 * @return
	 */
	public static URL createUrl(String link) {
		try {
			return new URL(link);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}