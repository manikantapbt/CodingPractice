public class InheritanceExceptionCheck extends SuperClass{

    void functionThrowsException(int a) throws Exception{
        if(true){
            throw  new Exception();
        }
    }
}

class SuperClass{
    void functionThrowsException(){
        return;
    }
}

