package mediator;

import java.awt.*;

public class ColleagueButton extends Button implements Colleague{

    private Mediator mediator;

    public ColleagueButton(String caption){
        super(caption);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;   //保存Mediator
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);     //Mediator下达启用/禁用的指示
    }
}
