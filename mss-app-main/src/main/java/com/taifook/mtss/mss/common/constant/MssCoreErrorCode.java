package com.taifook.mtss.mss.common.constant;

public interface MssCoreErrorCode {
    public static final String VALUE_DATE_IS_BEFORE_COMPANY_DATE = "MSSCOR_MST_000006";
    public static final String ACCOUNT_IS_CLOSED = "MSSCOR_MST_000007";
    public static final String FROM_ACCOUNT_IS_CLOSED = "MSSCOR_MST_000594";
    public static final String TO_ACCOUNT_IS_CLOSED = "MSSCOR_MST_000595";

    public static final String INVALID_ACCOUNT_ID = "MSSCOR_MST_000008";
    public static final String ACCOUNT_NOT_MATCH_WITH_AE_ACCESS_GROUP = "MSSCOR_MST_000011";
    public static final String NOT_BE_NEGATIVE = "MSSCOR_MST_000012";
    public static final String TRAD_DATE_AFTER_INSTRUMENT_TRADING_DATE = "MSSCOR_MST_000013";
    public static final String CLOSEOUT_DATE_EARLIERTHAN_BUSINESS_DATE = "MSSCOR_MST_000014";
    public static final String INVALID_CLOSEOUT_QTY_BY_OFFSET_RULE = "MSSCOR_MST_000019";
    public static final String NO_VALID_MSA_IN_FROM_ACCOUNT = "MSSCOR_MST_000021";
    public static final String ACCOUNT_IS_SUSPENDED = "MSSCOR_MST_000022";
    public static final String FROM_ACCOUNT_IS_SUSPENDED = "MSSCOR_MST_000596";
    public static final String TO_ACCOUNT_IS_SUSPENDED = "MSSCOR_MST_000597";

    public static final String ACCOUNT_IS_DECEASED = "MSSCOR_MST_000023";
    public static final String FROM_ACCOUNT_IS_DECEASED = "MSSCOR_MST_000598";
    public static final String TO_ACCOUNT_IS_DECEASED = "MSSCOR_MST_000599";

    public static final String NO_ACCOUNT_HOLDER_NAME = "MSSCOR_MST_000024";
    public static final String ACCOUNT_SIGN_ACCESS_ERROR = "MSSCOR_MST_000607";

    public static final String TO_AC_ID_SMALLER_FROM_AC_ID = "MSSCOR_MST_000560";
    public static final String TO_AC_ODATE_EARILER_FROM_AC_ODATE = "MSSCOR_MST_000561";
    public static final String TO_AC_CDATE_EARILER_FROM_AC_CDATE = "MSSCOR_MST_000562";

    public static final String EXPIRY_DATE_COULD_NOT_EARLIER = "MSSCOR_MST_000710";
    public static final String EFFECTIVE_DATE_COULD_NOT_EARLIER = "MSSCOR_MST_000074";
    public static final String INSTRUMENT_CLASS_IS_IN_USE = "MSSCOR_MST_000032";
    public static final String MUST_BE_POSITIVE = "MSSCOR_MST_000028";
    public static final String UNDERLYING_IS_IN_USE = "MSSCOR_MST_000035";
    public static final String UNDERLYING_USED_BY_INSTRUMENT_CLASS = "MSSCOR_MST_000036";
    public static final String INSTRUMENT_SYMBOL_RULE_USED_BY_INSTRUMENT_CLASS = "MSSCOR_MST_000037";
    public static final String PRICE_STRUCTURE_IS_IN_USE = "MSSCOR_MST_000038";
    public static final String PRICE_STRUCTURE_REF_BY_INSTCL = "MSSCOR_MST_000493";
    public static final String INSTRUMENT_GROUP_IS_IN_USE = "MSSCOR_MST_000039";
    public static final String INVALID_EFFECTIVE_DATE = "MSSCOR_MST_000044";
    public static final String FROM_TO_AMOUNT_IS_MISSING = "MSSCOR_MST_000052";
    public static final String INSUFFICIENT_FUND = "MSSCOR_MST_000053";
    public static final String VALUE_DATE_IS_FUTURE_DATE = "MSSCOR_MST_000063";
    public static final String DATE_FORMAT_INVALID = "MSSCOR_MST_000068";
    public static final String TRADE_DATE_AND_INSTR_CLS_TRADE_DATE_NOT_MATCH = "MSSCOR_MST_000071";
    public static final String SCHEME_NOENTYRY_INPUT = "MSSCOR_MST_000084";
    public static final String CHARGE_SCHEME_NOENTYRY_INPUT = "MSSCOR_MST_000084";
    public static final String EFFECTIVE_DATE_MUST_EARLIER_THAN_EXPIRY_DATE = "MSSCOR_MST_000085";
    public static final String INSTRUMENT_NOT_MATCH_MARKET = "MSSCOR_MST_000100";
    public static final String INSTRUMENT_CLASS_NOT_MATCH_MARKET = "MSSCOR_MST_000294";
    public static final String NO_ACCESS_RIGHTS_FOR_ACCOUNT = "MSSCOR_MST_000103";
    public static final String AUTO_CLOSEOUT_IN_PROGRESS = "MSSCOR_MST_000113";

    public static final String VALUE_IS_REQUIRED = "MSSCOR_MST_000121";
    public static final String DATA_DUPLICATED = "MSSCOR_MST_000126";
    public static final String BROKER_IS_IN_USE = "MSSCOR_MST_000130";
    public static final String MULTIPLE_DEFAULT = "MSSCOR_MST_000133";
    public static final String INVALID_TRANSFER_CCY_EXCHANGE_TRANSACTION = "MSSCOR_MST_000136";
    public static final String INVALID_DECIMAL_PLACE = "MSSCOR_MST_000139";
    public static final String INVALID_DATE_FORMAT = "MSSCOR_MST_000141";
    public static final String INVALID_CURRENCY_ON_THIS_BANK_ACCOUNT = "MSSCOR_MST_000149";
    public static final String PRIMARY_MUST_BE_ONE_AND_ONLY_ONE = "MSSCOR_MST_000154";
    public static final String TRADE_DATE_AFTER_LAST_TRADING_DATE="MSSCOR_MST_000157";
    public static final String NO_RECORD_FOUND = "MSSCOR_MST_000166";
    public static final String TO_CHEQUE_NUMBER_IS_SMALLER_THAN_FROM = "MSSCOR_MST_000175";
    public static final String ACCOUNT_STATUS_NOT_NORMAL = "MSSCOR_MST_000181";
    public static final String NOT_ALLOW_FUND_SAVE_SUBMIT_APPROVAL_DELETE = "MSSCOR_MST_000187";
    public static final String MISSING_NAME_RECORD = "MSSCOR_MST_000194";
    public static final String DUPLICATED_LANGUAGE = "MSSCOR_MST_000195";
    public static final String REVISER_EQUALS_CHECKER = "MSSCOR_MST_000196";
    public static final String OVER_FUND_APPROVAL_LIMIT = "MSSCOR_MST_000197";
    public static final String OVER_FUND_REVIEWED_LIMIT = "MSSCOR_MST_000198";
    public static final String CONCURRENT_UPDATE = "MSSCOR_MST_000207";
    public static final String IS_ALLOW_FUND_PRINT = "MSSCOR_MST_000208";
    public static final String REVERSED_FUND_IS_UNDER_REVERSED = "MSSCOR_MST_000210";
    public static final String REVERSED_FUND_INVALID_STATUS = "MSSCOR_MST_000211";
    public static final String REVERSED_FUND_IS_REVERSE = "MSSCOR_MST_000212";
    public static final String DISHONORED_CHEQUE_IS_UNDER_DISHONORED = "MSSCOR_MST_000213";
    public static final String MISSING_INSTRUMENT_CLASS_NAME = "MSSCOR_MST_000217";
    public static final String REVERSED_FUND_IS_UNDER_DISHONORED = "MSSCOR_MST_000218";
    public static final String DISHONORED_CHEQUE_IS_UNDER_REVERSED = "MSSCOR_MST_000219";
    public static final String LAST_TRADE_DATE_IS_EARLIER_THAN_FIRST_NOTICE_DATE = "MSSCOR_MST_000222";
    public static final String SETTLEMENT_DATE_IS_EARLIER_THAN_LAST_TRADE_DATE = "MSSCOR_MST_000223";
    public static final String EXPIRY_DATE_IS_EARLIER_THAN_SETTLEMENT_DATE = "MSSCOR_MST_000224";
    public static final String VALUE_DATE_LATER_CLEARING_DATE = "MSSCOR_MST_000227";
    public static final String DISHONORED_CHEQUE_NOT_CHEQUE_DEPOSIT = "MSSCOR_MST_000229";
    public static final String DISHONORED_CHEQUE_INVALID_STATUS = "MSSCOR_MST_000230";
    public static final String RETURNED_CHEQUE_NOT_CHEQUE = "MSSCOR_MST_000231";
    public static final String RETURNED_CHEQUE_FUND_IS_UNDER_RETURNED = "MSSCOR_MST_000232";
    public static final String RETURNED_CHEQUE_FUND_IS_UNDER_REVERSED = "MSSCOR_MST_000233";
    public static final String RETURNED_CHEQUE_INVALID_STATUS = "MSSCOR_MST_000234";
    public static final String REVERSED_FUND_IS_UNDRE_RETURNED = "MSSCOR_MST_000235";
    public static final String FAILURE_COUNT_OVERTHAN_IMPORT_COUNT = "MSSCOR_MST_000237";
    public static final String IS_OVER_FUNDIMPORT_LIMIT = "MSSCOR_MST_000238";
    public static final String IS_NOT_ALLOW_CHANGE_CHEQUESTATUS = "MSSCOR_MST_000241";
    public static final String NO_MARKET_RECORD = "MSSCOR_MST_000243";
    public static final String MISSING_ATTRIBUTE_RECORD = "MSSCOR_MST_000245";
    public static final String ATTRIBUTE_SETTING = "MSSCOR_MST_000246";
    public static final String AT_LEAST_ONE_SEARCH_CRITERION = "MSSCOR_MST_000250";
    public static final String INPUT_DATE_EXCEED_ARCHIVED_DATE = "MSSCOR_MST_000256";
    public static final String NO_DELETE_ON_REFERED_FUND_AUTH_GROUP = "MSSCOR_MST_000257";
    public static final String NO_VALID_MSA = "MSSCOR_MST_000260";
    public static final String DUPLICATE_SETTLEMENT_ROLE_ACCOUNT = "MSSCOR_MST_000268";
    public static final String DATA_NOT_EXIST = "MSSCOR_MST_000269";
    public static final String ACCOUNT_CLOSED = "MSSCOR_MST_000304";
    public static final String TRANSACTION_SHOULD_BE_MEMO_TYPE = "MSSCOR_MST_000305";
    public static final String LANGUAGE_IS_DUPLICATED = "MSSCOR_MST_000306";
    public static final String INSUFFICIENT_DAILY_WITHDRAWAL_LIMIT = "MSSCOR_MST_000309";
    public static final String FUND_TRANSFER_MUST_BE_FROM_TF_SECURITIES = "MSSCOR_MST_000311";
    public static final String FUND_TRANSFER_MUST_BE_TO_TF_FUTURES = "MSSCOR_MST_000312";
    public static final String BROKER_ACCOUNT_IS_IN_USE_BY_LOOKUP_RULE = "MSSCOR_MST_000314";
    public static final String INVALID_NUM_OF_DECIMAL_PLACE = "MSSCOR_MST_000315";
    public static final String INVALID_DENOMINATOR = "MSSCOR_MST_000316";
    public static final String MISSING_SEGREGATED_FUND = "MSSCOR_MST_000324";
    public static final String SAME_INSTRUMENT_CLASS = "MSSCOR_MST_000329";
    public static final String RATIO_MUST_BE_POSITIVE_INTEGER = "MSSCOR_MST_000330";
    public static final String RECORD_EXIST = "MSSCOR_MST_000334";
    public static final String INVALID_DATE_RANGE = "MSSCOR_MST_000504";
    public static final String EXPIRED_OR_EFFECTIVED_VERSION_NOT_DELETABLE = "MSSCOR_MST_000348";
    public static final String INVALID_EXPIRY_DATE = "MSSCOR_MST_000349";
    public static final String AT_LEAST_REMAIN_ONE_VERSION = "MSSCOR_MST_000351";
    public static final String INSTRUMENT_DAY_BATCH_IN_PROGRESS = "MSSCOR_MST_000374";
    public static final String COMPANY_DAY_BATCH_IN_PROGRESS = "MSSCOR_MST_000375";
    public static final String ENTERPRISE_DAY_BATCH_IN_PROGRESS = "MSSCOR_MST_000376";
    public static final String BROKER_ACCOUNT_LOOKUP_RULE_EXIST = "MSSCOR_MST_000381";
    public static final String INACTIVE_BROKER_ACCOUNT = "MSSCOR_MST_000382";
    public static final String CURRENCY_EXCHANGE_NOT_FOUND = "MSSCOR_MST_000385";
    public static final String INSTRUMENT_CLASS_NOT_EXIST = "MSSCOR_MST_000395";
    public static final String DUPLICATED_SYMBOL_CODE = "MSSCOR_MST_000444";
    public static final String AT_LEAST_ONE_NAME_REQUIRED = "MSSCOR_MST_000403";
    public static final String ACCEPT_NUMERIC_ONLY = "MSSCOR_MST_000423";
    public static final String MISSING_TODAY_EXCHANGE_RATE = "MSSCOR_MST_000445";
    public static final String CURRENCY_NOT_MATCH = "MSSCOR_MST_000450";
    public static final String BROKER_ACCOUNT_AND_BROKER_NOT_MATCH = "MSSCOR_MST_000463";
    public static final String HOLD_DATE_TO_EARLIER_THAN_HOLD_DATE_FROM = "MSSCOR_MST_000667";
    public static final String INVALID_CMPNY_BANK_ACC_FROM_TO = "MSSCOR_MST_000600";
    public static final String INVALID_HOLIDAY_DATE_EARLIER_THAN_MAX_TRADE_DATE = "MSSCOR_MST_000651";
    public static final String HOLD_FUND_IS_UNDER_RELEASED = "MSSCOR_MST_000680";
    public static final String EXPIRY_DATE_LATER_THAN_CURR_BUSDATE = "MSSCOR_MST_000681";
    public static final String HOLD_DATE_LATER_THAN_EXPIRY_DATE = "MSSCOR_MST_000682";
    public static final String HOLIDAY_DATE_EARLIER_THAN_LATEST_REFRRED_DATE = "MSSCOR_MST_000711";



    public static final String SAME_SEGREGATED_FUND = "MSSCOR_MST_000467";

    public static final String INVALID_BANK_CLEARING_DATE = "MSSCOR_MST_000521";
    public static final String AVAILABLE_BALANCE_IS_LESSTHAN_AMOUNT = "MSSCOR_MST_000551";
    public static final String EXPIRY_DATE_TO_EARLIER_THAN_EXPIRY_DATE_FROM = "MSSCOR_MST_000557";
    public static final String NO_INSTRUMENT_CLOSING_PRICE = "MSSCOR_MST_000510";

    public static final String ADD_CURRENCY_CODE_DELETE_BEFORE = "MSSCOR_MST_000516";


    public static final String ACCOUNT_ATTRIBUTE_GROUP_NOT_MATCH_BROKER_ACCOUNT = "MSSCOR_MST_000605";

    public static final String MORE_THAN_ONE_MARKET_MATCH_INSTRUMENT = "MSSCOR_MST_000566";

    public static final String INSTRUMENT_BIZ_DATE_AFTER_COMPANY_BIZ_DATE = "MSSCOR_MST_000372";
    public static final String EARLIER_THAN_HISTORY_RETENTION_PERIOD = "MSSCOR_MST_000446";
    public static final String NO_ACCESS_RIGHTS_FOR_BROKER_ACCOUNT = "MSSCOR_MST_000464";
    public static final String HOLIDAY_CONFLIC_WITH_CALENDAR = "MSSCOR_MST_000473";
    public static final String HOLIDAY_MUST_CHECKED = "MSSCOR_MST_000474";
    public static final String DUPLICATE_HOLIDAY_FOR_CALENDAR = "MSSCOR_MST_000475";
    public static final String NO_MODIFY_BEFORE_COMPANY_BUSINESSDATE = "MSSCOR_MST_000476";
    public static final String AT_LEAST_ONE_HOLIDAY_DATE = "MSSCOR_MST_000478";
    public static final String NO_DELETE_BEFORE_COMPANY_BUSINESSDATE = "MSSCOR_MST_000479";
    public static final String USED_BY_MARKET_OR_INSTRUMENTCLASS = "MSSCOR_MST_000480";
    public static final String CALENDAR_WITHOUT_HOLIDAY_ATTACHED = "MSSCOR_MST_000481";
    public static final String DUPLICATED_SYMBOL_CODE_WITH_INSTURMENTS = "MSSCOR_MST_000484";
    public static final String DUPLICATED_SYMBOL_OR_DISPLAY_CODE = "MSSCOR_MST_000485";
    public static final String INVALID_INSTRUMENT_EFFECTIVE_DATE_RANGE = "MSSCOR_MST_000488";
    public static final String DATE_MUST_BE_BOTH_CHECKED_OR_UNCHECKED = "MSSCOR_MST_000495";
    public static final String VERSION_EFFECTIVEDAY_IS_INFINITY = "MSSCOR_MST_000577";
    public static final String NOT_ALL_CURRENCY_HAVE_EXCHANGERATE = "MSSCOR_MST_000511";
    public static final String INACTIVE_NEXT_YEAR_HOLIDAY = "MSSCOR_MST_000512";

    public static final String DUPLICATE_BATCH_GROUP_CODE = "MSSCOR_MST_000461";
    public static final String REFERRED_BATCH_GROUP = "MSSCOR_MST_000645";
    public static final String ANOTHER_VERSION_ATTACHED = "MSSCOR_MST_100028";

    public static final String VERSION_NO_LOGGER_FUNCTION = "MSSCOR_MST_200060";
    public static final String VERSION_EFFECTIVE_DATE_DEFERED = "MSSCOR_MST_200061";
    public static final String EXPIRED_VERSION_CONTENT_CHANGE_ONLY = "MSSCOR_MST_200062";
    public static final String EXPIRED_ADJACENT_VERSION_CONTENT_CHANGED = "MSSCOR_MST_200063";
    public static final String EFFECTIVE_VERSION_CONTENT_CHANGE = "MSSCOR_MST_200064";
    public static final String VERSION_EFFECTIVE_DATE_DEFERRED = "MSSCOR_MST_200065";
    public static final String PENDING_VERSION_EXPIRY_DATE_UNCHANGE = "MSSCOR_MST_200066";
    public static final String PENDING_VERSION_EXPIRY_DATE_CHANGE = "MSSCOR_MST_200067";
    public static final String LISTING_DATE_EARLIER_THAN_TODAY = "MSSCOR_MST_200068";
    public static final String UNMATCH_BATCH_GROUP = "MSSCOR_MST_200071";


    public static final String NUMBER_MUST_BE_POSITIVE = "MSSCOR_MST_000497";

    public static final String EFFECTIVE_DATE_MUST_AFTER_MARKET_BUSSINESS_DATE = "MSSCOR_MST_000505";

    public static final String NEW_VERSION_FULLY_OVERWRITE_THE_EXIST_VERSION = "MSSCOR_MST_000419";

    public static final String NEW_VERSION_PARTIAL_OVERWRITE_THE_EXIST_EVERSION = "MSSCOR_MST_200069";

    public static final String INSTRUMENT_CLASS_BIZ_DATE_AND_BATCH_BIZ_DATE_NOT_MATCH = "MSSCOR_MST_000567";

    public static final String EXIST_NOT_TERMINATE_INSTRUMENT = "MSSCOR_MST_000483";

    public static final String TRANSACTION_DATE_TOO_LATE = "MSSCOR_MST_000489";
    public static final String BUSINESS_DATE_TOO_LATE = "MSSCOR_MST_000692";

    public static final String VERSION_EFFECTIVE_DATE_MUST_AFTER_LAST_ARCHIVE_DATE = "MSSCOR_MST_000545";
    public static final String VERSION_EXPIRY_ON_MUST_AFTER_LAST_ARCHIVE_DATE = "MSSCOR_MST_000401";
    public static final String NOT_ALLOW_DELETE_LAST_VERSION_REC = "MSSCOR_MST_000421";
    public static final String VER_EFF_DATE_MUST_EARLIER_THAN_VER_EXP_DATE = "MSSCOR_MST_000407";
    public static final String ORIGINAL_EFF_DATE_BEFORE_BEFORE_COMPANY_BUSINESS_DATE = "MSSCOR_MST_200042";

    public static final String NO_DELETE_ON_REFERENCED_MODEL = "MSSCOR_MST_000153";
    public static final String EXCHANGE_RATE_NOT_FOUND = "MSSCOR_MST_000614";
    public static final String COMPANY_BIZDATE_OUTDATED = "MSSCOR_MST_000523";
    public static final String DATE_EARLIER_THAN_EPOCH = "MSSCOR_MST_000542";
    public static final String DATE_LATER_THAN_FOREVER = "MSSCOR_MST_000543";
    public static final String TO_DATE_MUST_NOT_EARLIER_THAN_FROM_DATE = "MSSCOR_MST_000544";
    public static final String TO_DATE_MUST_NOT_EARLIER_THAN_RETENTION_DATE = "MSSCOR_MST_000545";
    public static final String EXPIRY_DATE_COULD_NOT_BE_UPDATE_FROM_INFINITY = "MSSCOR_MST_000574";
    public static final String MAINTAINED_RECORD_NOT_CURRENT_BUSINESS_DATE = "MSSCOR_MST_000700";


    //
    // Statement
    //
    public static final String COMPANY_DAY_BATCH_NOT_COMPLETED = "MSSCOR_MST_000411";
    // Statement Cycle
    public static final String CYCLE_NAME_DUPLICATED_WITH_DELETED_RECORD = "MSSCOR_MST_000576";
    public static final String CYCLE_DAY_AND_FACTOR_DUPLICATED = "MSSCOR_MST_000586";
    public static final String CYCLE_ALREADY_REFERENCED = "MSSCOR_MST_000066";
    public static final String NEW_MAPPED_DATE_TOO_EARLY = "MSSCOR_MST_000272";
    public static final String NEW_CALENDAR_DATE_MUST_BETWEEN_PREVIOUS_AND_NEXT_MAPPED_DATE = "MSSCOR_MST_000273";
    public static final String NO_STATEMENT_CYCLE_MAPPED = "MSSCOR_MST_000631";
    // Statement Message
    public static final String EFFECTIVE_DATE_TOO_EARLY = "MSSCOR_MST_000277";
    public static final String EXPIRY_DATE_EARLIER_THAN_EFFECTIVE_DATE = "MSSCOR_MST_000580";

    //
    // Transaction type
    //
    public static final String REFERENCE_NUMBER_PREFIX_DELETED = "MSSCOR_MST_000624";
    public static final String TRANSACTION_TYPE_CANNOT_DELETE = "MSSCOR_MST_000627";
    public static final String INVALID_REFERENCE_NUMBER_PREFIX = "MSSCOR_MST_000652";
    public static final String REFERENCE_NUMBER_TOO_LONG = "MSSCOR_MST_000653";

    //
    // TPA
    //
    public static final String NO_TPA_RECORD = "MSSCOR_MST_300034";
    public static final String TPA_INVALID_EXPRIY_DATE = "MSSCOR_MST_000553";
    public static final String TPA_INVALID_EFF_DATE = "MSSCOR_MST_000554";

    //
    // Instrument
    //
    public static final String REMIND_SET_MARGING_OR_SPAN_MAPPING = "MSSCOR_MST_300026";
    public static final String INSTRUMENT_CLASS_HAS_LISTED = "MSSCOR_MST_300027";
    public static final String TRADING_CURRENCY_NOT_ALLOWD_MODIFY_WHEN_TRADE_EXIST = "MSSCOR_MST_000532";
    public static final String INFINITY_EXPIRY_DATE_MUST_NOT_BE_CHANGED_BACKWARD = "MSSCOR_MST_000574";
    public static final String DISPLAYCODE_DUPLICATED_IN_MASTER = "MSSCOR_MST_000573";
    public static final String INSTRUMENT_CLASS_REFERED_BY_TRAD_AFTER_TERMINATE_DATE = "MSSCOR_MST_000587";
    public static final String INSTRUMENT_REFERED_BY_TRADE_AFTER_TERMINATE_DATE = "MSSCOR_MST_000588";
    public static final String EFFECTIVE_PERIOD_MUST_NOT_BE_EARLIER_THAN_SYSTEM_EFFECTIVE_DATE = "MSSCOR_MST_000542";
    public static final String EFFECTIVE_PERIOD_MUST_BE_EARLIER_THAN_SYSTEM_INFINITY_DATE = "MSSCOR_MST_000543";
    public static final String DUPLICATED_INSTRUMENT_WITH_STRIKEPRICE_LASTTRADEDATE_IN_SAME_EFFECTIVE_PERIOD = "MSSCOR_MST_000590";
    public static final String HAS_OPEN_POSITION= "MSSCOR_MST_000623";
    public static final String INSTRUMENT_OFFSET_CLOSEOUT_EXIST = "MSSCOR_MST_000658";
    public static final String DECIMAL_POINT_LESS_THAN_ORIGINAL = "MSSCOR_MST_000659";

    public static final String CURRENCY_MARKED_INVALID = "MSSCOR_MST_000563";
    public static final String ADDED_CCY_CONFLICT = "MSSCOR_MST_000564";
    public static final String SYS_DEFAULT_CCY_UPDATED = "MSSCOR_MST_000565";
    public static final String DATA_ALREADY_EXISTS = "MSSCOR_MST_000570";
    public static final String INSTRUMENT_CLASS_EFFECTIVE_DATE_LATTER = "MSSCOR_MST_000572";
    public static final String TRADE_DATE_NOT_MATCH_USER_SPECIFIED_TRADE_DATE = "MSSCOR_MST_000517";

    public static final String EXPLICT_MMNS_UNIQUEKEY_ERR = "MSSCOR_MST_000628";
    public static final String BUSINESSDATE_BEFORE_INSTRUMENT_BUSINESSDATE = "MSSCOR_MST_000668";
    public static final String CALCULATED_EXCH_RATE_VALUE_MORE_THAN_MAX_VALUE = "MSSCOR_MST_000669";
    public static final String AT_LEAST_ONE_DEFAULT_BROKER_ACCOUNT_LOOKUP_RULE = "MSSCOR_MST_000671";
    public static final String INSTR_TYPE_GROUP_CDE_NOT_MATCH_UPPER_LEVEL = "MSSCOR_MST_000672";
    public static final String INSTR_TYPE_GROUP_CDE_NOT_MATCH_UPPER_LEVEL_INSTCL = "MSSCOR_MST_000676";
    public static final String DEFINED_UPPER_LEVEL_FOR_NOT_OPTION_INSTR_TYPE_GROUP_CODE = "MSSCOR_MST_000673";

    //
    // Batch
    //
    public static final String NOT_CURRENT_BUSINESS_DATE = "MSSCOR_MST_000261";

    public static final String INACTIVE_BATCHGROUP = "MSSCOR_MST_000634";
    public static final String CURRENT_BATCH_DATE_NOT_EQUAL_TO_INSTRUMENT_BATCH = "MSSCOR_MST_000635";
    public static final String INSTRUMENT_BATCH_DATE_SMALLER_CURRENT_BATCH_DATE = "MSSCOR_MST_000638";
    public static final String COMPANY_BATCH_DATE_SMALLER_CURRENT_BATCH_DATE = "MSSCOR_MST_000636";
    public static final String CURRENT_BATCH_DATE_NOT_EQUAL_TO_ENTERPRISE_BATCH = "MSSCOR_MST_000637";
    public static final String CURRENT_BATCH_DATE_NOT_EQUAL_TO_COMPANY_BATCH = "MSSCOR_MST_000640";

    public static final String COMPANY_DAY_BATCH_NOT_FOUND = "MSSCOR_MST_000641";
    public static final String COMPANY_NOT_FOUND = "MSSCOR_MST_000639";
    public static final String BATCH_GROUP_NOT_FOUND = "MSSCOR_MST_000633";
    public static final String INSTRUMENT_DAY_BATCH_NOT_FOUND = "MSSCOR_MST_000642";
    public static final String INSTRUMENT_DAY_BATCH_STATE_NOT_FOUND = "MSSCOR_MST_000647";
    public static final String JOB_RUN_NOT_FOUND = "MSSCOR_MST_000644";
    public static final String PRE_VALIDATION_FAIL = "MSSCOR_MST_000646";
    public static final String JOB_RUN_REJECTED = "MSSCOR_MST_000643";
    public static final String REQUEST_REJECTED= "ZZZZZZZ";

    // Account Balance Enquiry
    public static final String AVAILABLE_WITHDRAW_BALANCE_NOT_FOUND = "MSSCOR_MST_000579";
}
