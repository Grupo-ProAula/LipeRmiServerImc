package rmi.imc.net;

import java.io.IOException;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;
import rmi.imc.lib.IRemoteCalculateIMC;

public class ServerIMC {
    
    private int port = 9007;
    private CallHandler caller;
    private Server server;
    private CalculateIMCImp calculatorImc;
    private IRemoteCalculateIMC calculatorImcRemote;

    public ServerIMC() {
        this.caller = new CallHandler();
        this.server = new Server();
        this.calculatorImc = new CalculateIMCImp();
    }
    
    public void Start() throws Exception {
        try {
            caller.registerGlobal(IRemoteCalculateIMC.class, calculatorImc);
            server.bind(port, caller);
        } catch (LipeRMIException ex) {
            throw new Exception("Error: No fue posible invocar metodos remotos");
        } catch (IOException ex) {
            throw new Exception("Error: I/0");
        }
    }
    
    public void Stop(){
        server.close();
    }
}
