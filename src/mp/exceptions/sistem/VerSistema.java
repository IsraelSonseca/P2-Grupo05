package mp.exceptions.sistem;

import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class VerSistema extends Result {
    public VerSistema(MiembroURJC userLogued, String sistema) {
        super(userLogued.getNick()+", puedes ver el sistema RedditURJC :"+sistema);
    }
}
