package example.run;

import example.ArrivalProcess;
import simkit.Schedule;
import simkit.random.RandomVariate;
import simkit.random.RandomVariateFactory;
import simkit.util.SimplePropertyDumper;

/**
 *
 * @author ahbuss
 */
public class TestArrivalProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         RandomVariate interarrivalTimeGenerator =
                 RandomVariateFactory.getInstance("Uniform", 3.5, 10.2);
         ArrivalProcess arrivalProcess = new ArrivalProcess(interarrivalTimeGenerator);
         System.out.println(arrivalProcess);
         
         SimplePropertyDumper simplePropertyDumper = new SimplePropertyDumper();
         arrivalProcess.addPropertyChangeListener(simplePropertyDumper);
         
         int totalNumnerArrivals = 10;
         System.out.printf("Simulation will run for %d Arrival events%n%n", 
                 totalNumnerArrivals);
         
         Schedule.setVerbose(true);
         Schedule.stopOnEvent(totalNumnerArrivals, "Arrival");
         
         Schedule.reset();
         Schedule.startSimulation();
    }

}
