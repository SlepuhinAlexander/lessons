package ru.ifmo.base.lesson17.ditask.tstclasses;

import ru.ifmo.base.lesson17.ditask.container.marks.Required;
import ru.ifmo.base.lesson17.ditask.container.marks.RequiredClass;
import ru.ifmo.base.lesson17.ditask.tstclasses.config.AnimalsConfig;

import java.util.ArrayList;


@RequiredClass
public class Cat {
    @Required
    private AnimalsConfig catConfig;

    @Required
    private Owner owner;

    private ArrayList<Mouse> mice = new ArrayList<>(20);

    public void catchMouse(Mouse mouse) {
        if (catConfig.getCatSpeed() < mouse.getSpeed()) {
            System.out.println(mouse.getName() + " убежал от " + catConfig.getCatName());
            return;
        }
        mice.add(mouse);
        System.out.println(catConfig.getCatName() + " поймал " + mouse.getName());

    }



}
