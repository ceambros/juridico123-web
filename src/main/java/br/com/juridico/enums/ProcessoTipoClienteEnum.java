package br.com.juridico.enums;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public enum ProcessoTipoClienteEnum implements IStringEnum {

    AUTOR("AUTOR"),
    REU("RÉU");

    private String value;

    private String label;

    private ProcessoTipoClienteEnum(String labelParam) {
        label = labelParam;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ProcessoTipoClienteEnum enumForValue(String value) {
        for (ProcessoTipoClienteEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    public static String getValidValues() {
        String comma = "";
        StringBuilder enumValue = new StringBuilder();

        for (ProcessoTipoClienteEnum i : ProcessoTipoClienteEnum.class.getEnumConstants()) {
            enumValue.append(comma).append(i.getValue());
            comma = ", ";
        }

        return enumValue.toString();
    }
}
