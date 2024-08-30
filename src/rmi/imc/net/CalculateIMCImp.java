package rmi.imc.net;

import rmi.imc.lib.DataIMC;
import rmi.imc.lib.IRemoteCalculateIMC;

public class CalculateIMCImp implements IRemoteCalculateIMC{

    private DataIMC data;

    public CalculateIMCImp() {}
    
    @Override
    public DataIMC CalculateIMC(DataIMC data) {
        float result = 0;
        if (data.getWeight() <= 0 || data.getHeight() <= 0){
            data.setMessage("ERROR: El peso y la altura deben ser mayores a cero.");
            return data;
        } else {
            result = data.getWeight() / (data.getHeight() * data.getHeight());
            data.setResult(result);
            if (result < 18.5) {
                data.setMessage("Deberias consultar un medico, tu peso es muy bajo.");
            } else if(result >= 18.5 && result <= 24.9) {
                data.setMessage("Estas bien de peso");
            } else {
                data.setMessage("Deberias consultar un medico, tu peso es muy alto.");
            }
            return data;
        }
    }
    
}
