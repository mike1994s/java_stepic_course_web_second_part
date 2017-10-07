package resourceServer;


/**
 * Created by misha on 07.10.17.
 */
@SuppressWarnings("UnusedDeclaration")
public interface ResourceServerControllerMBean {
    String getName();
    int getAge();
    void loadResource(final String nameFile);
}
