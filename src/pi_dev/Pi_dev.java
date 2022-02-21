package pi_dev;

import pi_dev.entities.boost;
import pi_dev.services.BoostService;

public class Pi_dev {

    
    
    public static void main(String[] args) {
        BoostService service=new BoostService();
        boost b1 =new boost("test7",2.5f);
        //service.add_boost(b1);
        //service.delete_boost(4);
        service.update(b1, 7);
        
       // System.out.println(service.displayAll());
        
    }
    
}
