package mp.exceptions.logOut;

import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class CierreSesion extends Result {
    public CierreSesion(MiembroURJC userLogued) {
        super(userLogued.getNick() + " ha cerrado su sesión. LOG OUT CORRECTO");
    }
}
