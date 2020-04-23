package mp.exceptions.subForo;

import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class VerSubforo extends Result {
    public VerSubforo(MiembroURJC userLogued, String strForos) {
        super(userLogued.getNick()+" es miembro de la URJC y tiene permiso para ver los Subforos. Los subforos existentes en RedditURJC son:"+strForos);
    }
}
