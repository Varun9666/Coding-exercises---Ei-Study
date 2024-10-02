package Project;

import behavioral.*;
import creational.*;
import structural.*;
import logger.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        
        try {
            logger.log("Demonstrating Observer Pattern:");
            ObserverPattern.execute();

            logger.log("\nDemonstrating Strategy Pattern:");
            StrategyPattern.execute();

            logger.log("\nDemonstrating Singleton Pattern:");
            SingletonPattern.execute();

            logger.log("\nDemonstrating Factory Pattern:");
            FactoryPattern.execute();

            logger.log("\nDemonstrating Adapter Pattern:");
            AdapterPattern.execute();

            logger.log("\nDemonstrating Decorator Pattern:");
            DecoratorPattern.execute();
        } catch (Exception e) {
            logger.log("Error occurred: " + e.getMessage());
        } finally {
            logger.close();
        }
    }
}
