package manageDetails;

public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String msg){
            super(msg);
        }

        public MyException(String s,Throwable error) {
            super(s, error);

        }
}
