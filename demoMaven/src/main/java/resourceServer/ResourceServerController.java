package resourceServer;

import resources.TestResource;
import sax.ReadXMLFileSAX;

/**
 * Created by misha on 07.10.17.
 */
public class ResourceServerController implements ResourceServerControllerMBean {

    private TestResource testResource;
    public ResourceServerController(TestResource testResource){
        this.testResource = testResource;
    }

    @Override
    public String getName() {
        return this.testResource.getName();
    }

    @Override
    public int getAge() {
        return this.testResource.getAge();
    }

    @Override
    public void loadResource(final String nameFile){
        this.testResource = (TestResource) ReadXMLFileSAX.readXML(nameFile);

    }
}
