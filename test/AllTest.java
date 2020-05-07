import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({mp.admin.AdministradorTest.class,
        mp.penalizaciones.PenalizacionTest.class,
        mp.subforos.SubForoTest.class,
        mp.subforos.entradas.EntradaGenericaTest.class,
        mp.subforos.entradas.EntradaTest.class,
        mp.subforos.entradas.EstadoEntradaTest.class,
        mp.subforos.entradas.ObjetoPuntuableTest.class,
        mp.subforos.entradas.opiniones.ComentarioTest.class,
        mp.subforos.entradas.opiniones.EstadoValoracionTest.class,
        mp.subforos.entradas.opiniones.VotacionTest.class,
        mp.users.MiembroURJCTest.class,
        mp.users.NotificacionTest.class,
        mp.RedditURJCTest.class
})

public class AllTest {
}
