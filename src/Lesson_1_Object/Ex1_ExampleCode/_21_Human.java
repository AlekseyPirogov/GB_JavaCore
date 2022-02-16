package Lesson_1_Object.Ex1_ExampleCode;

public class _21_Human extends _11_Mammalian {

    @Override
    void createChild() {
        System.out.println("Реализация основного инстинкта по З.Фрейду/Ч.Дарвину.");
    }

    @Override
    void voiceForCreateChild() {
        System.out.println("Флирт там..., комплименты и все такое :) ");
    }
}
