package org.usc.demo.beanutils.convert;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.lang3.StringUtils;

public class ConvertUtil {
    private final static char defaultDelimiter = ',';
    private final static char[] defaultAllowedChars = new char[] { '.', '-', '=', '|' };

    public static List<String> convertToStringList(String value) {
        return parseElements(value, defaultDelimiter, defaultAllowedChars);
    }

    public static List<String> parseElements(String value, char delimiter, char[] allowedChars) {
        List<String> list = new ArrayList<String>();

        if (StringUtils.isEmpty(value)) {
            return list;
        }

        // Trim any matching '{' and '}' delimiters
        value = value.trim();
        if (value.startsWith("{") && value.endsWith("}")) {
            value = value.substring(1, value.length() - 1);
        }

        try {
            // Set up a StreamTokenizer on the characters in this String
            StreamTokenizer st = new StreamTokenizer(new StringReader(value));
            st.whitespaceChars(delimiter, delimiter); // Set the delimiters
            st.ordinaryChars('0', '9'); // Needed to turn off numeric flag
            st.wordChars('0', '9'); // Needed to make part of tokens
            for (int i = 0; i < allowedChars.length; i++) {
                st.ordinaryChars(allowedChars[i], allowedChars[i]);
                st.wordChars(allowedChars[i], allowedChars[i]);
            }

            // Split comma-delimited tokens into a List
            while (true) {
                int ttype = st.nextToken();
                if ((ttype == StreamTokenizer.TT_WORD) || (ttype > 0)) {
                    if (st.sval != null) {
                        list.add(st.sval);
                    }
                } else if (ttype == StreamTokenizer.TT_EOF) {
                    break;
                } else {
                    throw new ConversionException("Encountered token of type " + ttype + " parsing elements to String'.");
                }
            }

            // Return the completed list
            return list;
        } catch (IOException e) {
            throw new ConversionException("Error converting from String to 'String': " + e.getMessage(), e);
        }
    }

}
