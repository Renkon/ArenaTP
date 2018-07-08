package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.utils.HashingUtils;
import org.uqbar.commons.utils.Observable;

@Observable
public class PasswordViewModel {
    protected String password = "";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return HashingUtils.sha256Of(password);
    }
}
