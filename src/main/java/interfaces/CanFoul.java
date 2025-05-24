package interfaces;

public interface CanFoul {
    default void foul(){
        System.out.println("I need to cover it up");
    };
}