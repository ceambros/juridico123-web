package br.com.juridico.enums;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public enum ProcessoSituacaoEnum implements IStringEnum {

    TODAS("TODAS"),
    ABERTO("ABERTO"),
    ACORDO("ACORDO"),
    ENCERRADO("ENCERRADO"),
    AGUARDANDO_ARQUIVAMENTO("AGUARDANDO ARQUIV.");

    private String value;

    private String label;

    private ProcessoSituacaoEnum(String labelParam) {
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
