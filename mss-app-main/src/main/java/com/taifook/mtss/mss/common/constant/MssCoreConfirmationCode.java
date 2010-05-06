package com.taifook.mtss.mss.common.constant;

public interface MssCoreConfirmationCode {
      public static final String DUPLICATED_TRANSACTION = "MSSCOR_MST_200002";
      public static final String TRANSFER_TO_ANOTHER_CLIENT = "MSSCOR_MST_200007";
      public static final String OVER_FUND_INPUT_LIMIT = "MSSCOR_MST_200008";
      public static final String FROM_TO_AMOUNT_NOT_MATCHED = "MSSCOR_MST_200012";
      public static final String AVAILABLE_BALANCE_IS_LESSTHAN_AMOUNT = "MSSCOR_MST_200010";
      public static final String INVALID_CURRENCY_EXCHANGE_INPUT = "MSSCOR_MST_200009";
      public static final String CLOSING_PRICE_GREATER_THAN_DEVIATION_RADIO = "MSSCOR_MST_200017";
      public static final String DEVIATION_EXCEEDS_WARNING = "MSSCOR_MST_200018";
      public static final String EXCHANGE_RATE_GREATER_THAN_TOLERANCE_RATE = "MSSCOR_MST_200019";
      public static final String TO_AMOUNT_EXCEED_TOLERANCE_RATE = "MSSCOR_MST_200020";

      public static final String MARKET_USED_BY_OTHER_GROUP = "MSSCOR_MST_200077";

      public static final String DUPLICATED_DISASTER_HOLIDAY = "MSSCOR_MST_200086";

      public static final String INVALID_CLEARING_DATE_SAT_SUN = "MSSCOR_MST_200088";
      public static final String INVALID_CLEARING_DATE_HOLIDAY = "MSSCOR_MST_200089";
      public static final String CLOSING_PRICE_NOT_EQUAL_FINAL_SETTLEMENT_PRICE = "MSSCOR_MST_200090";

}
