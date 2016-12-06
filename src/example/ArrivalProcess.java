package example;

import simkit.SimEntityBase;
import simkit.random.RandomVariate;

/**
 *
 * @author ahbuss
 */
public class ArrivalProcess extends SimEntityBase {

    private RandomVariate interarrivalTimeGenerator;
    
    protected int numberArrivals;
    
    public ArrivalProcess() { }
    
    public ArrivalProcess(RandomVariate interarrivalTimeGenerator) {
        this.setInterarrivalTimeGenerator(interarrivalTimeGenerator);
    }
    
    @Override
    public void reset() {
        super.reset();
        this.numberArrivals = 0;
    }
    
    public void doRun() {
        firePropertyChange("numberArrivals", getNumberArrivals());
        
        waitDelay("Arrival", interarrivalTimeGenerator);
    }
    
    public void doArrival() {
        this.numberArrivals += 1;
        firePropertyChange("numberArrivals", getNumberArrivals());
        
        waitDelay("Arrival", interarrivalTimeGenerator);
    }

    /**
     * @return the interarrivalTimeGenerator
     */
    public RandomVariate getInterarrivalTimeGenerator() {
        return interarrivalTimeGenerator;
    }

    /**
     * @param interarrivalTimeGenerator the interarrivalTimeGenerator to set
     */
    public void setInterarrivalTimeGenerator(RandomVariate interarrivalTimeGenerator) {
        this.interarrivalTimeGenerator = interarrivalTimeGenerator;
    }

    /**
     * @return the numberArrivals
     */
    public int getNumberArrivals() {
        return numberArrivals;
    }
}
