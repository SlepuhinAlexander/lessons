package ru.ifmo.base.lesson17.ditask.tstclasses;


import ru.ifmo.base.lesson17.ditask.container.marks.Required;
import ru.ifmo.base.lesson17.ditask.container.marks.RequiredClass;
import ru.ifmo.base.lesson17.ditask.tstclasses.config.AnimalsConfig;

@RequiredClass
public class Owner {
    @Required
    private AnimalsConfig ownerConfig;

    public String getName(){
        return ownerConfig.getOwnerName();
    }
}
