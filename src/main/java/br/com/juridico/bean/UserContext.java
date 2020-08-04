package br.com.juridico.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserContext extends GenericModel {

    private static final long serialVersionUID = 1L;

    private String login;

    private String localeString;

    public UserContext() {
    }

    public UserContext(String strLogin) {
        this();
        setLogin(strLogin);
    }

    public String getLocaleString() {
        return localeString;
    }

    public void setLocaleString(String value) {
        localeString = value;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserContext [getLocaleString()=" + getLocaleString() + ", getLogin()=" + getLogin() + ", toString()="
                + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (login == null ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserContext other = (UserContext) obj;
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        return true;
    }

}
