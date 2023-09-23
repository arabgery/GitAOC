/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button_Menu_LR_Line;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.SliderMenuTitle;
import age.of.civilizations2.jakowski.lukasz.Slider_BG;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

class Menu_CreateScenario_Events_Cond_EventChance
extends SliderMenu {
    protected Menu_CreateScenario_Events_Cond_EventChance() {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        int tY = CFG.PADDING;
        menuElements.add(new Button_Menu_LR_Line(null, -1, 0, tY, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT, true));
        menuElements.add(new Button_Menu_LR_Line(null, -1, 0, tY, CFG.GAME_WIDTH / 3, CFG.BUTTON_HEIGHT, true){

            @Override
            protected Color getColor(boolean isActive) {
                return CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.iCreateEvent_EditConditionID).conditionType == Event_Type.AND ? CFG.COLOR_TEXT_MODIFIER_POSITIVE : super.getColor(isActive);
            }
        });
        menuElements.add(new Button_Menu_LR_Line(null, -1, CFG.GAME_WIDTH / 3, tY, CFG.GAME_WIDTH / 3, CFG.BUTTON_HEIGHT, true){

            @Override
            protected Color getColor(boolean isActive) {
                return CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.iCreateEvent_EditConditionID).conditionType == Event_Type.NOT ? CFG.COLOR_TEXT_MODIFIER_POSITIVE : super.getColor(isActive);
            }
        });
        menuElements.add(new Button_Menu_LR_Line(null, -1, CFG.GAME_WIDTH - CFG.GAME_WIDTH / 3, tY, CFG.GAME_WIDTH - CFG.GAME_WIDTH / 3 * 2, CFG.BUTTON_HEIGHT, true){

            @Override
            protected Color getColor(boolean isActive) {
                return CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.iCreateEvent_EditConditionID).conditionType == Event_Type.OR ? CFG.COLOR_TEXT_MODIFIER_POSITIVE : super.getColor(isActive);
            }
        });
        menuElements.add(new Slider_BG(0, tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING * 2, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT - CFG.PADDING * 2, 0, 100, CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get(CFG.eventsManager.iCreateEvent_EditConditionID).getValue()){

            @Override
            protected String getDrawText() {
                return this.getText() + ": " + this.getCurrent() + "%";
            }
        });
        tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING;
        this.initMenuWithBackButton(new SliderMenuTitle(null, CFG.BUTTON_HEIGHT * 3 / 4, false, false), 0, CFG.BUTTON_HEIGHT * 3 / 4, CFG.GAME_WIDTH, CFG.GAME_HEIGHT - CFG.BUTTON_HEIGHT * 3 / 4, menuElements);
        this.updateLanguage();
    }

    @Override
    protected void updateLanguage() {
        this.getMenuElement(0).setText(CFG.langManager.get("Save"));
        this.getMenuElement(1).setText(CFG.langManager.get("AND"));
        this.getMenuElement(2).setText(CFG.langManager.get("NOT"));
        this.getMenuElement(3).setText(CFG.langManager.get("OR"));
        this.getMenuElement(4).setText(CFG.langManager.get("EventChance"));
        this.getTitle().setText(CFG.langManager.get("EventChance"));
    }

    @Override
    protected final void actionElement(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.iCreateEvent_EditConditionID).conditionType = Event_Type.AND;
                CFG.toast.setInView(this.getMenuElement(iID).getText(), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE);
                break;
            }
            case 2: {
                CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.iCreateEvent_EditConditionID).conditionType = Event_Type.NOT;
                CFG.toast.setInView(this.getMenuElement(iID).getText(), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE);
                break;
            }
            case 3: {
                CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.iCreateEvent_EditConditionID).conditionType = Event_Type.OR;
                CFG.toast.setInView(this.getMenuElement(iID).getText(), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE);
                break;
            }
            case 4: {
                CFG.eventsManager.lCreateScenario_Event.getTrigger((int)CFG.eventsManager.iCreateEvent_EditTriggerID).lConditions.get(CFG.eventsManager.iCreateEvent_EditConditionID).setValue(this.getMenuElement(iID).getCurrent());
            }
        }
    }

    @Override
    protected final void onBackPressed() {
        CFG.menuManager.setViewID(Menu.eCREATE_SCENARIO_EVENTS_TRIGGER);
        CFG.menuManager.setBackAnimation(true);
    }
}

