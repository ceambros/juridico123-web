package br.com.juridico.util;

import com.sun.nio.sctp.MessageInfo;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationUtil.
 */
public final class ValidationUtil {

    /**
     * The Constant PERIOD.
     */
    private static final String PERIOD = ".";

    /**
     * The Constant FWD_SLASH.
     */
    private static final String FWD_SLASH = "/";

    /**
     * Checks if is null or empty.
     *
     * @param aList the a list
     * @return true, if is null or empty
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(List aList) {
        return isNull(aList) || aList.isEmpty();
    }

    /**
     * Checks if is null or empty.
     *
     * @param aList the a list
     * @param msgCode the msg code
     * @param msgList the msg list
     * @return the list
     */
    @SuppressWarnings("rawtypes")
    public static List<MessageInfo> isNullOrEmpty(List aList, String msgCode, List<MessageInfo> msgList) {
        if (msgList == null) {
            msgList = new ArrayList<MessageInfo>();
        }

//        if (isNullOrEmpty(aList)) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }

        return msgList;
    }
    /**
     * Checks if is null or empty.
     *
     * @param value the value
     * @return true, if is null or empty
     */
    public static boolean isNullOrEmpty(String value) {
        return isNull(value) || (value.trim().length() <= 0);
    }

//    public static List<MessageInfo> isNullOrEmpty(String value, String msgCode, List<MessageInfo> msgList) {
//        if (msgList == null) {
//            msgList = new ArrayList<MessageInfo>();
//        }
//
//        if (isNull(value) || (value.trim().length() <= 0)) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }
//
//        return msgList;
//    }
    /**
     * Checks if is null or empty.
     *
     * @param value the value
     * @param defaultValue the default value
     * @return the string
     */
    public static String isNullOrEmpty(String value, String defaultValue) {
        if (isNullOrEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Checks if is null.
     *
     * @param object the object
     * @return true, if is null
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * Checks if is null.
     *
     * @param object the object
     * @param msgCode the msg code
     * @param msgList the msg list
     * @return the list
     */
    public static List<MessageInfo> isNull(Object object, String msgCode, List<MessageInfo> msgList) {
        if (msgList == null) {
            msgList = new ArrayList<MessageInfo>();
        }

//        if (isNull(object)) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }

        return msgList;
    }
    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @return true, if is null or zero
     */
    public static boolean isNullOrZero(Integer value) {
        return isNull(value) || (value == 0);
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param msgCode the msg code
     * @param msgList the msg list
     * @return the list
     */
    public static List<MessageInfo> isNullOrZero(Integer value, String msgCode, List<MessageInfo> msgList) {
        if (msgList == null) {
            msgList = new ArrayList<MessageInfo>();
        }

//        if (isNullOrZero(value)) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }
        return msgList;
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param defaultValue the default value
     * @return the integer
     */
    public static Integer isNullOrZero(Integer value, Integer defaultValue) {
        if (isNullOrZero(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @return true, if is null or zero
     */
    public static boolean isNullOrZero(Long value) {
        return isNull(value) || (value == 0);
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param msgCode the msg code
     * @param msgList the msg list
     * @return the list
     */
    public static List<MessageInfo> isNullOrZero(Long value, String msgCode, List<MessageInfo> msgList) {
        if (msgList == null) {
            msgList = new ArrayList<MessageInfo>();
        }

//        if (isNullOrZero(value)) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }
        return msgList;
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param defaultValue the default value
     * @return the long
     */
    public static Long isNullOrZero(Long value, Long defaultValue) {
        if (isNullOrZero(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @return true, if is null or zero
     */
    public static boolean isNullOrZero(Double value) {
        return isNull(value) || (value == 0);
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param defaultValue the default value
     * @return the double
     */
    public static Double isNullOrZero(Double value, Double defaultValue) {
        if (isNullOrZero(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param msgCode the msg code
     * @param msgList the msg list
     * @return the list
     */
    public static List<MessageInfo> isNullOrZero(Double value, String msgCode, List<MessageInfo> msgList) {
        if (msgList == null) {
            msgList = new ArrayList<MessageInfo>();
        }

//        if (isNullOrZero(value)) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }
        return msgList;
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @return true, if is null or zero
     */
    public static boolean isNullOrZero(BigDecimal value) {
        return isNull(value) || value.equals(BigDecimal.ZERO);
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param msgCode the msg code
     * @param msgList the msg list
     * @return the list
     */
    public static List<MessageInfo> isNullOrZero(BigDecimal value, String msgCode, List<MessageInfo> msgList) {
        if (msgList == null) {
            msgList = new ArrayList<MessageInfo>();
        }

//        if (isNullOrZero(value)) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }
        return msgList;
    }

    /**
     * Checks if is null or zero.
     *
     * @param value the value
     * @param defaultValue the default value
     * @return the big decimal
     */
    public static BigDecimal isNullOrZero(BigDecimal value, BigDecimal defaultValue) {
        if (isNullOrZero(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Checks if is valid length.
     *
     * @param field the field
     * @param maxLength the max length
     * @param msgCode the msg code
     * @param msgList the msg list
     * @return the list
     */
    public static List<MessageInfo> isValidLength(String field, int maxLength, String msgCode, List<MessageInfo> msgList) {
        if (msgList == null) {
            msgList = new ArrayList<MessageInfo>();
        }

//        if (field.length() > maxLength) {
//            msgList.add(MessageInfo.createFieldValidationError(msgCode));
//        }
        return msgList;
    }

    /**
     * Checks if is valid effective dates.
     *
     * @param fromDate the from date
     * @param toDate the to date
     * @return true, if is valid effective dates
     */
    public static boolean isValidEffectiveDates(Date fromDate, Date toDate) {
        if (fromDate == null) {
            return false;
        }
        if (toDate == null) {
            return false;
        }

//        if (DateUtil.compare(fromDate, toDate) >= 0) {
//            return false;
//        }
        return true;
    }

    /**
     * Checks if is date mmddyyyy.
     *
     * @param dateValue the date value
     * @param lenient the lenient
     * @return true, if is date mmddyyyy
     */
    public static boolean isDateMMDDYYYY(String dateValue, boolean lenient) {
        SimpleDateFormat simpleDateFormat = null;

        // Does the input use slashes ?
        if (dateValue.indexOf(FWD_SLASH) > 0) {
            simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        } else if (dateValue.indexOf(PERIOD) > 0) {
            simpleDateFormat = new SimpleDateFormat("MM.dd.yyyy");
        } else {
            simpleDateFormat = new SimpleDateFormat("MMddyyyy");
        }

        try {
            simpleDateFormat.setLenient(lenient);
            simpleDateFormat.parse(dateValue);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Checks if is date yyyymmdd.
     *
     * @param dateValue the date value
     * @param lenient the lenient
     * @return true, if is date yyyymmdd
     */
    public static boolean isDateYYYYMMDD(String dateValue, boolean lenient) {
        SimpleDateFormat simpleDateFormat = null;
        // Does the input use slashes ?
        if (dateValue.indexOf(FWD_SLASH) > 0) {
            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        } else if (dateValue.indexOf(PERIOD) > 0) {
            simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        }

        try {
            simpleDateFormat.setLenient(lenient);
            simpleDateFormat.parse(dateValue);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Are new dates within.
     *
     * @param existingFromDate the existing from date
     * @param existingToDate the existing to date
     * @param newFromDate the new from date
     * @param newToDate the new to date
     * @param msgCode the msg code
     * @param msgInfo the msg info
     * @return true, if successful
     */
//    public static boolean areNewDatesWithin(Date existingFromDate, Date existingToDate, Date newFromDate,
//            Date newToDate, String msgCode, List<MessageInfo> msgInfo) {
//        // Make sure the dates are all not-null
//        if ((existingFromDate == null) || (existingToDate == null) || (newFromDate == null) || (newToDate == null)) {
//            return false;
//        }
//
//        // if new-from-date greater-than or equal to existing-from-date...
//        if (DateUtil.compare(newFromDate, existingFromDate) >= 0) {
//            // if new-from-date less-than or equal to existing-from-date then the new-from-date is within the existing
//            // dates.
//            if (DateUtil.compare(newFromDate, existingToDate) <= 0) {
//                // if new-to-date greater-than or equal to existing-from-date...
//                if (DateUtil.compare(newToDate, existingFromDate) >= 0) {
//                    // if new-to-date less-than or equal to existing-from-date then the new-from-date is within the
//                    // existing dates.
//                    if (DateUtil.compare(newToDate, existingToDate) <= 0) {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        msgInfo.add(MessageInfo.createFieldValidationError(msgCode, existingFromDate, existingToDate,
//                newFromDate, newToDate));
//
//        return true;
//    }
    /**
     * Are dates overlapping.
     *
     * @param existingFromDate the existing from date
     * @param existingToDate the existing to date
     * @param newFromDate the new from date
     * @param newToDate the new to date
     * @param msgCode the msg code
     * @param msgInfo the msg info
     * @return true, if successful
     */
//    public static boolean areDatesOverlapping(Date existingFromDate, Date existingToDate, Date newFromDate,
//            Date newToDate, String msgCode, List<MessageInfo> msgInfo) {
//        // Make sure the dates are all not-null
//        if ((existingFromDate == null) || (existingToDate == null) || (newFromDate == null) || (newToDate == null)) {
//            return false;
//        }
//
//        // if the new-from-date is less-than or equal-to the existing date...
//        if (DateUtil.compare(newFromDate, existingToDate) <= 0) {
//            // if the new-to-date is greater-than or equal-to the existing-from-date...
//            if (DateUtil.compare(newToDate, existingFromDate) >= 0) {
//                msgInfo.add(MessageInfo.createFieldValidationError(msgCode, existingFromDate, existingToDate,
//                        newFromDate,
//                        newToDate));
//            }
//        }
//
//        return true;
//    }
    // [end] More convenience methods - "is" methods
    /**
     * Checks if is long.
     *
     * @param longValue the long value
     * @return true, if is long
     */
    public static boolean isLong(String longValue) {
        try {
            Long.parseLong(longValue);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is short.
     *
     * @param shortValue the short value
     * @return true, if is short
     */
    public static boolean isShort(String shortValue) {
        try {
            Short.parseShort(shortValue);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is integer.
     *
     * @param integerValue the integer value
     * @return true, if is integer
     */
    public static boolean isInteger(String integerValue) {
        try {
            Integer.parseInt(integerValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if is double.
     *
     * @param doubleValue the double value
     * @return true, if is double
     */
    public static boolean isDouble(String doubleValue) {
        try {
            Double.parseDouble(doubleValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if is decimal.
     *
     * @param decimalValue the decimal value
     * @return true, if is decimal
     */
    public static boolean isDecimal(String decimalValue) {
        try {
            new BigDecimal(decimalValue);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is float.
     *
     * @param floatValue the float value
     * @return true, if is float
     */
    public static boolean isFloat(String floatValue) {
        try {
            Float.parseFloat(floatValue);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is currency.
     *
     * @param currencyValue the currency value
     * @return true, if is currency
     */
    public static boolean isCurrency(String currencyValue) {
        return isDecimal(currencyValue);
    }

    /**
     * Validate sort fields.
     *
     * @param inquiryRequest the inquiry request
     * @param validSortFields the valid sort fields
     * @return the list
     */
//    public static List<SortExpression> validateSortFields(InquiryRequest inquiryRequest,
//            Map<String, String> validSortFields) {
//        return validateSortFields(inquiryRequest.getSortExpressions(), validSortFields);
//    }
    /**
     * Validate sort fields.
     *
     * @param sortExpressions the sort expressions
     * @param validSortFields the valid sort fields
     * @return the list
     */
//    public static List<SortExpression> validateSortFields(List<SortExpression> sortExpressions,
//            Map<String, String> validSortFields) {
//        List<SortExpression> badExpressions = new ArrayList<SortExpression>();
//
//        // nothing to do.
//        if ((sortExpressions == null) || (sortExpressions.size() == 0)) {
//            return badExpressions;
//        }
//
//        for (SortExpression expression : sortExpressions) {
//            if (expression.getField() != null) {
//                if (!validSortFields.containsKey(expression.getField())) {
//                    badExpressions.add(expression);
//                }
//            } else {
//                badExpressions.add(expression);
//            }
//        }
//
//        return badExpressions;
//    }
}
