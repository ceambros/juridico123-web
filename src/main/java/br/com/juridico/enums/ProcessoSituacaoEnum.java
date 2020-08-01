package br.com.juridico.enums;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public enum ProcessoSituacaoEnum implements IStringEnum {

    TODAS("T", "TODAS"),
    ABERTO("1", "ABERTO"),
    ACORDO("2", "ACORDO"),
    ENCERRADO("3", "ENCERRADO"),
    AGUARDANDO_ARQUIVAMENTO("4", "AGUARDANDO ARQUIV.");

    private String value;

    private String label;

    private ProcessoSituacaoEnum(String valorParam, String labelParam) {
        value = valorParam;
        label = labelParam;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ProcessoSituacaoEnum enumForValue(String value) {
        for (ProcessoSituacaoEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    public static String getValidValues() {
        String comma = "";
        StringBuilder enumValue = new StringBuilder();

        for (ProcessoSituacaoEnum i : ProcessoSituacaoEnum.class.getEnumConstants()) {
            enumValue.append(comma).append(i.getValue());
            comma = ", ";
        }

        return enumValue.toString();
    }
}
