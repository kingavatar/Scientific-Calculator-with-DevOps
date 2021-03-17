package com.github.kingavatar.scientificcalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Calculator {

    private static final String message = "Welcome to the Calculator CLI Application";
    
    private final static Logger logger = LogManager.getLogger(Calculator.class);
    Calculator(){
        
    }

    @Override
    public String toString() {
        return message;
    }

    public double SquareRoot(double num){
      double result;
      try{
        logger.info("[SQUARE_ROOT] : "+num);
        if(num<0)
        {
          throw new IllegalArgumentException("Given Number Can't be Negative");
        }
        result=Math.sqrt(num);
      }
      catch(IllegalArgumentException error){
        result=-1;
        logger.error("[SQUARE_ROOT - NEG_DOUBLE_ERROR] : "+error.getLocalizedMessage());
      }
      catch(Exception error){
        result=-1;
        logger.error("[SQUARE_ROOT - ERROR] : "+error.getLocalizedMessage());
      }
      logger.info("[SQUARE_ROOT - RESULT] : "+result);
      return result;
    }
    public int Factorial(int num){ 
        int result = 1;
        logger.info("[FACTORIAL] : "+num);
        if(num<0)
        {
            logger.error("[FACTORIAL - NEG_INT_ERROR] : "+0);
        	return 0;
        }
        else if(num<=1) 
        {
        	logger.info("[FACTORIAL - RESULT] : "+1);
        	return 1;
        }
        for(int i=2;i<=num;i++)
        {
        	result = result*i;
        }
        logger.info("[FACTORIAL - RESULT] : "+result);
        return result;
      }
    public double Log (double num){
      double result = 0;
      try {
          logger.info("[NATURAL_LOGARITHM] : "+num);
          if(num<=0)
          {
              result = Double.NaN;
              throw new IllegalArgumentException("Given Number Can't be Negative");
          }
          result =  Math.log(num);
      } 
      catch (IllegalArgumentException error) {
          result=-1;
          logger.error("[NATURAL_LOGARITHM - NEG_DOUBLE_ERROR] : "+error.getLocalizedMessage());
      }
      catch(Exception error){
        result=-1;
        logger.error("[NATURAL_LOGARITHM - ERROR] : "+error.getLocalizedMessage());
      }
      logger.info("[NATURAL_LOGARITHM - RESULT] : "+result);
      return result;
    }
    public double Pow(double num1, int num2){return num1;}
}
