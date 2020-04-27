package ru.ifmo.base.lesson17.ditask.tstclasses;


import ru.ifmo.base.lesson17.ditask.container.marks.Required;
import ru.ifmo.base.lesson17.ditask.container.marks.RequiredClass;
import ru.ifmo.base.lesson17.ditask.tstclasses.config.AnimalsConfig;

@RequiredClass
public class Mouse {
    @Required
    private AnimalsConfig mouseConfig;

    public String getName() {
        return mouseConfig.getMouseName();
    }

    public int getSpeed() {
        return mouseConfig.getMouseSpeed();
    }
}
