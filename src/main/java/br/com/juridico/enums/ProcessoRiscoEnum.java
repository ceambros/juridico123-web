package br.com.juridico.enums;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public enum ProcessoRiscoEnum implements IStringEnum {

    SELECIONE("T", ""),
    PROVAVEL("1", "PROVÁVEL"),
    POSSIVEL("2", "POSSÍVEL"),
    REMOTO("3", "REMOTO"),
    AMBOS("4", "AMBOS");

    private String value;

    private String label;

    private ProcessoRiscoEnum(String valorParam, String labelParam) {
        value = valorParam;
        label = labelParam;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ProcessoRiscoEnum enumForValue(String value) {
        for (ProcessoRiscoEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    public static String getValidValues() {
        String comma = "";
        StringBuilder enumValue = new StringBuilder();

        for (ProcessoRiscoEnum i : ProcessoRiscoEnum.class.getEnumConstants()) {
            enumValue.append(comma).append(i.getValue());
            comma = ", ";
        }

        return enumValue.toString();
    }
}
