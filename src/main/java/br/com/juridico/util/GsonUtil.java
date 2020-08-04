package br.com.juridico.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public class GsonUtil {

    public static void printGsonObject(Object objeto) throws JsonProcessingException {
        System.out.println(new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(objeto));
    }

}
