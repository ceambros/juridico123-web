package br.com.juridico.enums;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public enum ProcessoSentencaEnum implements IStringEnum {

    SELECIONE(""),
    PROCEDENTE("PROCEDENTE"),
    IMPROCEDENTE("IMPROCEDENTE");

    private String value;

    private String label;

    private ProcessoSentencaEnum(String labelParam) {
        label = labelParam;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ProcessoSentencaEnum enumForValue(String value) {
        for (ProcessoSentencaEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    public static String getValidValues() {
        String comma = "";
        StringBuilder enumValue = new StringBuilder();

        for (ProcessoSentencaEnum i : ProcessoSentencaEnum.class.getEnumConstants()) {
            enumValue.append(comma).append(i.getValue());
            comma = ", ";
        }

        return enumValue.toString();
    }
}
