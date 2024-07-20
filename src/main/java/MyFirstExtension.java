import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class MyFirstExtension implements BurpExtension {

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("MyFirstExtension");
        api.logging().logToOutput("Extension Loaded");

        String hash = "";

        if(api.persistence().preferences().stringKeys().contains("hash")){
            hash = api.persistence().preferences().getString("hash");
        }

        MyFirstHttpHandler handler = new MyFirstHttpHandler(hash);
        api.http().registerHttpHandler(handler);

        api.extension().registerUnloadingHandler(new UnloadingHandler(api, handler));
    }
}
