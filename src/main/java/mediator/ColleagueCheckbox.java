package mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener ,Colleague {

    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state){
        super(caption,group,state);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();            //当状态发生变化时通知Mediator
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);                   //Mediator 下达启用/禁用指令
    }
}
