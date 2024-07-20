import burp.api.montoya.MontoyaApi;
import burp.api.montoya.extension.ExtensionUnloadingHandler;

public class UnloadingHandler implements ExtensionUnloadingHandler {

    private MontoyaApi api;

    private MyFirstHttpHandler handler;

    public UnloadingHandler(MontoyaApi api, MyFirstHttpHandler handler){
        this.api = api;
        this.handler = handler;
    }

    @Override
    public void extensionUnloaded() {
        this.api.persistence().preferences().setString("hash", this.handler.getHash());
    }
}
