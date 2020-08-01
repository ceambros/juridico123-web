package br.com.juridico.enums;

public enum PessoaTipoEnum implements IIntegerEnum {

    EMPRESA(1),
    CLIENTE(2),
    FUNCIONARIO(3),
    ADVOGADO(4),
    EMPRESA_FATURAMENTO(5);

    private Integer value;

    private PessoaTipoEnum(Integer valor) {
        value = valor;
    }

    public Integer getValue() {
        return value;
    }

    public static PessoaTipoEnum enumForValue(Integer value) {
        for (PessoaTipoEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    public static String getValidValues() {
        String comma = "";
        StringBuilder enumValue = new StringBuilder();

        for (PessoaTipoEnum i : PessoaTipoEnum.class.getEnumConstants()) {
            enumValue.append(comma).append(i.getValue());
            comma = ", ";
        }

        return enumValue.toString();
    }
}
