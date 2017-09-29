package com.summi.denomination.helpers;

import com.summi.denomination.Constants;
import com.summi.denomination.value_objects.Currency;

import org.json.JSONObject;

public class CurrencyParserHelper {

    public static Currency parseCurrency(JSONObject obj, String currencyName) {
        Currency currency = new Currency();
        currency.setBase(obj.optString(Constants.BASE));
        currency.setDate(obj.optString(Constants.DATE));
        JSONObject rateObject = obj.optJSONObject(Constants.RATES);
        if(rateObject != null) {
            currency.setRate(rateObject.optDouble(currencyName));
        }
        currency.setName(currencyName);
        return currency;
    }
}