package br.com.juridico.enums;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public enum SimNaoEnum implements IStringEnum {

    SIM("SIM"),
    NAO("NÃO");

    private String value;

    private String label;

    private SimNaoEnum(String labelParam) {
        label = labelParam;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static SimNaoEnum enumForValue(String value) {
        for (SimNaoEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    public static String getValidValues() {
        String comma = "";
        StringBuilder enumValue = new StringBuilder();

        for (SimNaoEnum i : SimNaoEnum.class.getEnumConstants()) {
            enumValue.append(comma).append(i.getValue());
            comma = ", ";
        }

        return enumValue.toString();
    }
}
