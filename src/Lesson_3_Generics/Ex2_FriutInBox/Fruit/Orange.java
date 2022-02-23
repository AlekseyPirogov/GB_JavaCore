package Lesson_3_Generics.Ex2_FriutInBox.Fruit;

public class Orange extends Fruit {

    public Orange() {
        this.weightFruit = 1.5f;
    }

    public Orange(float weight) {
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
