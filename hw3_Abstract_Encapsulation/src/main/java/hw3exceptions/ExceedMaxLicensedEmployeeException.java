package hw3exceptions;

public class ExceedMaxLicensedEmployeeException extends Exception{
  public ExceedMaxLicensedEmployeeException(String message){
    super(message);
  }
}
