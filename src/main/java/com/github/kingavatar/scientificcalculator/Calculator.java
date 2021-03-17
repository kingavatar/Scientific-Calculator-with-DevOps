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
        result=Double.NaN;
        logger.error("[SQUARE_ROOT - NEG_INT_ERROR] : "+error.getLocalizedMessage());
      }
      catch(Exception error){
        result=Double.NaN;
        logger.error("[SQUARE_ROOT - ERROR] : "+error.getLocalizedMessage());
      }
      logger.info("[SQUARE_ROOT - RESULT] : "+result);
      return result;}
    public int Factorial(int num){return num;}
    public double Log (double num){return num;}
    public double Pow(double num1, int num2){return num1;}
}
