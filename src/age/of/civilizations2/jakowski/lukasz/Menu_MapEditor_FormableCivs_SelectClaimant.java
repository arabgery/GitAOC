/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button_Menu_LR_Line;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.SliderMenuTitle;
import java.util.ArrayList;

class Menu_MapEditor_FormableCivs_SelectClaimant
extends SliderMenu {
    protected Menu_MapEditor_FormableCivs_SelectClaimant() {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        menuElements.add(new Button_Menu_LR_Line(null, -1, 0, 0, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT, true));
        this.initMenuWithBackButton(new SliderMenuTitle(null, CFG.BUTTON_HEIGHT * 3 / 4, false, false), 0, CFG.BUTTON_HEIGHT * 3 / 4, CFG.GAME_WIDTH, CFG.GAME_HEIGHT - CFG.BUTTON_HEIGHT * 3 / 4, menuElements, true, true);
        this.updateLanguage();
    }

    @Override
    protected void updateLanguage() {
        this.getMenuElement(0).setText(CFG.langManager.get("Back"));
        this.getTitle().setText(CFG.langManager.get("SelectCivilization"));
    }

    @Override
    protected final void actionElement(int iID) {
        this.onBackPressed();
    }

    @Override
    protected void onBackPressed() {
        CFG.menuManager.setViewID(Menu.eMAP_EDITOR_FORMABLE_CIVS_EDIT);
        CFG.menuManager.clearMapEditor_FormableCivs_SelectClaimant();
    }

    @Override
    protected void actionClose() {
        this.onBackPressed();
    }
}

