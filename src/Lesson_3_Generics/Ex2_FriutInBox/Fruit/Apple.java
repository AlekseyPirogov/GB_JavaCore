package Lesson_3_Generics.Ex2_FriutInBox.Fruit;

public class Apple extends Fruit {

    public Apple() {
        this.weightFruit = 1.0f;
    }

    public Apple(float weight) {
        this.weightFruit = weight;
    }

    @Override
    public Float getWeight() {
        return this.weightFruit;
    }

    @Override
    public void setWeight(Float weight) {
        this.weightFruit = weight;
    }


//    @Override
//    public String toString() {
//        return this.toString();
//    }
}
