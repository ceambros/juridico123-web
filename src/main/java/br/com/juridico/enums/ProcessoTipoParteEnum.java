package br.com.juridico.enums;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public enum ProcessoTipoParteEnum implements IStringEnum {

    CLIENTE("C"),
    ADVOGADO("A"),
    PARTE_CONTRARIA("PC"),
    ADVOGADO_PARTE_CONTRARIA("APC"),
    EMPRESA_FATURAMENTO("EF");

    private String value;

    private ProcessoTipoParteEnum(String valor) {
        value = valor;
    }

    public String getValue() {
        return value;
    }

    public static ProcessoTipoParteEnum enumForValue(String value) {
        for (ProcessoTipoParteEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    public static String getValidValues() {
        String comma = "";
        StringBuilder enumValue = new StringBuilder();

        for (ProcessoTipoParteEnum i : ProcessoTipoParteEnum.class.getEnumConstants()) {
            enumValue.append(comma).append(i.getValue());
            comma = ", ";
        }

        return enumValue.toString();
    }
}
